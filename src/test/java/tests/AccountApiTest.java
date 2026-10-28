package tests;

import config.TestData;
import core.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountApiTest extends BaseTest {

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    @DisplayName("POST /Account/v1/User creates a new user")
    void postCreateUser() {
        String username = "user_" + System.currentTimeMillis();

        Response response = accountClient.createUser(username, TestData.VALID_PASSWORD);

        assertThat(response.statusCode())
                .as("Status code should be 201")
                .isEqualTo(201);

        String userId = response.jsonPath().getString(TestData.USER_ID_FIELD_CREATE);
        assertThat(userId)
                .as("Generated userId should not be blank")
                .isNotBlank();

        String actualUsername = response.jsonPath().getString("username");
        assertThat(actualUsername)
                .as("Username should match")
                .isEqualTo(username);
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    @DisplayName("POST /Account/v1/GenerateToken returns valid token")
    void postGenerateToken() {
        String username = "user_" + System.currentTimeMillis();

        // Создаем юзера перед генерацией токена
        accountClient.createUser(username, TestData.VALID_PASSWORD);

        Response response = accountClient.generateToken(username, TestData.VALID_PASSWORD);

        assertThat(response.statusCode())
                .as("Status code should be 200")
                .isEqualTo(200);

        String token = response.jsonPath().getString(TestData.TOKEN_FIELD);
        assertThat(token)
                .as("Token should not be blank")
                .isNotBlank();

        String status = response.jsonPath().getString("status");
        assertThat(status)
                .as("Status should be Success")
                .isEqualTo(TestData.SUCCESS_STATUS);
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    @DisplayName("GET /Account/v1/User/{uuid} returns user by id")
    void getUserById() {
        String username = "user_" + System.currentTimeMillis();

        Response createResponse = accountClient.createUser(username, TestData.VALID_PASSWORD);
        String userId = createResponse.jsonPath().getString(TestData.USER_ID_FIELD_CREATE);

        Response tokenResponse = accountClient.generateToken(username, TestData.VALID_PASSWORD);
        String token = tokenResponse.jsonPath().getString(TestData.TOKEN_FIELD);

        Response response = accountClient.getUser(userId, token);

        assertThat(response.statusCode())
                .as("Status code should be 200")
                .isEqualTo(200);

        String actualUserId = response.jsonPath().getString(TestData.USER_ID_FIELD_GET);
        assertThat(actualUserId)
                .as("Returned userId should match")
                .isEqualTo(userId);

        String actualUsername = response.jsonPath().getString("username");
        assertThat(actualUsername)
                .as("Returned username should match")
                .isEqualTo(username);
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    @DisplayName("DELETE /Account/v1/User/{uuid} deletes user")
    void deleteUserByUserId() {
        String username = "user_" + System.currentTimeMillis();

        Response createResponse = accountClient.createUser(username, TestData.VALID_PASSWORD);
        String userId = createResponse.jsonPath().getString(TestData.USER_ID_FIELD_CREATE);

        Response tokenResponse = accountClient.generateToken(username, TestData.VALID_PASSWORD);
        String token = tokenResponse.jsonPath().getString(TestData.TOKEN_FIELD);

        Response deleteResponse = accountClient.deleteUser(userId, token);

        assertThat(deleteResponse.statusCode())
                .as("Status code should be 204")
                .isEqualTo(204);

        // Проверяем, что юзера больше нет (401 или 404)
        Response getAfterDelete = accountClient.getUser(userId, token);
        assertThat(getAfterDelete.statusCode())
                .as("User should be deleted, so status should be 401 or 404")
                .isIn(401, 404);
    }
}

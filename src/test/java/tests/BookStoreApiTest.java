package tests;

import core.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DemoQA BookStore API")
class BookStoreApiTest extends BaseTest {

    private static final String VALID_PASSWORD = "Test@1234";


    @Test
    @DisplayName("GET /BookStore/v1/Books returns non-empty list")
    void getBooks() {
        Response response = client.getBooks();

        assertThat(response.statusCode())
                .as("Status code should be 200")
                .isEqualTo(200);

        List<String> titles = response.jsonPath().getList("books.title");

        assertThat(titles)
                .as("Books list should not be empty")
                .isNotEmpty();
    }

    @Test
    @DisplayName("GET /BookStore/v1/Book returns book by ISBN")
    void getBookByIsbn() {
        String isbn = "9781449325862";
        Response response = client.getBook(isbn);

        assertThat(response.statusCode())
                .as("Status code should be 200")
                .isEqualTo(200);

        String actualIsbn = response.jsonPath().getString("isbn");

        assertThat(actualIsbn)
                .as("ISBN should match the requested one")
                .isEqualTo(isbn);
    }

    @Test
    @DisplayName("POST /Account/v1/User creates a new user")
    void postCreateUser() {
        String username = "user_" + System.currentTimeMillis();

        Response response = client.createUser(username, VALID_PASSWORD);
        //response.prettyPrint();

        assertThat(response.statusCode())
                .as("Status code should be 201")
                .isEqualTo(201);

        String userId = response.jsonPath().getString("userID");
        assertThat(userId)
                .as("Generated userId should not be blank")
                .isNotBlank();

        String actualUsername = response.jsonPath().getString("username");
        assertThat(actualUsername)
                .as("Username should match the requested one")
                .isEqualTo(username);

    }
}
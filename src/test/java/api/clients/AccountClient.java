package api.clients;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class AccountClient extends BaseApiClient {

    public Response createUser(String username, String password) {
        Map<String, String> body = Map.of("userName", username, "password", password);
        return given(spec)
                .body(body)
                .post("/Account/v1/User");
    }

    public Response generateToken(String username, String password) {
        Map<String, String> body = Map.of("userName", username, "password", password);
        return given(spec)
                .body(body)
                .post("/Account/v1/GenerateToken");
    }

    public Response getUser(String userId, String token) {
        return given(spec)
                .pathParam("uuid", userId)
                .header("Authorization", "Bearer " + token)
                .get("/Account/v1/User/{uuid}");
    }

    public Response deleteUser(String userId, String token) {
        return given(spec)
                .pathParam("uuid", userId)
                .header("Authorization", "Bearer " + token)
                .delete("/Account/v1/User/{uuid}");
    }

}

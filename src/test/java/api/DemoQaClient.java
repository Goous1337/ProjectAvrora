package api;

import config.TestConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.patch;

public class DemoQaClient {

    private final RequestSpecification spec;

    public DemoQaClient() {
        if (TestConfig.logRequests()) {
            RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        }

        this.spec = given()
                .baseUri(TestConfig.apiUrl())
                .contentType("application/json")
                .accept("application/json");
    }

    public Response getBooks() {
        return given(spec)
                .get("/BookStore/v1/Books");
    }

    public Response getBook(String isbn) {
        return given(spec).queryParam("ISBN", isbn)
                .get("/BookStore/v1/Book");
    }


    public Response createUser(String userName, String password) {
        Map<String, String> body = Map.of("userName", userName,
                "password", password);

        return given(spec)
                .body(body)
                .post("/Account/v1/User");
    }

    public Response getGenerateToken(String userName, String password) {
        Map<String, String> body = Map.of("userName", userName,
                "password", password);

        return given(spec)
                .body(body)
                .post("/Account/v1/GenerateToken");
    }

    public Response getUser(String userId, String token){
        return given(spec)
                .pathParam("uuid", userId)
                .header("Authorization", "Bearer " + token)
                .get("/Account/v1/User/{uuid}");
    }

}
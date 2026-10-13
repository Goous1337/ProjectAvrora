package api;

import config.TestConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

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
        return given(spec).get("/BookStore/v1/Books");
    }
}
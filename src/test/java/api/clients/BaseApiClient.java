package api.clients;

import config.TestConfig;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseApiClient {

        protected RequestSpecification spec;

        public BaseApiClient() {
            this.spec = given()
                    .baseUri(TestConfig.apiUrl())
                    .contentType("application/json")
                    .accept("application/json");
        }

}

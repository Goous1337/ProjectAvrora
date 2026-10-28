package api.clients;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookClient extends BaseApiClient {

    public Response getBooks() {
        return given(spec).get("/BookStore/v1/Books");
    }

    public Response getBook(String isbn) {
        return given(spec)
                .queryParam("ISBN", isbn)
                .get("/BookStore/v1/Book");
    }

}

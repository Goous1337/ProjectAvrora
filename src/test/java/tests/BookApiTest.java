package tests;

import core.BaseTest;
import config.TestData;
import core.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class BookApiTest extends BaseTest {

    @Test
    @DisplayName("GET /BookStore/v1/Books returns non-empty list")
    void getBooks() {
        Response response = bookClient.getBooks();
        assertThat(response.statusCode()).isEqualTo(200);

        List<String> titles = response.jsonPath().getList("books.title");
        assertThat(titles).isNotEmpty();
    }

    @Test
    @DisplayName("GET /BookStore/v1/Book returns book by ISBN")
    void getBookByIsbn() {
        Response response = bookClient.getBook(TestData.EXISTING_BOOK_ISBN);
        assertThat(response.statusCode()).isEqualTo(200);

        String actualIsbn = response.jsonPath().getString("isbn");
        assertThat(actualIsbn).isEqualTo(TestData.EXISTING_BOOK_ISBN);
    }

}

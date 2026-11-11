package tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;
import core.BaseUiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.LinksPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LinksUiTest extends BaseUiTest {

    @Test
    @DisplayName("Check links: navigation and API responses")
    void clickLinksTest() {
        LinksPage linksPage = new LinksPage(page);
        linksPage.open();
        
        Page homeLinks = page.waitForPopup(linksPage::clickHomeLink);
        Page dynamicLinks = page.waitForPopup(linksPage::clickDynamicLink);

        assertThat(homeLinks.url()).isEqualTo("https://demoqa.com/");
        assertThat(dynamicLinks.url()).isEqualTo("https://demoqa.com/");


        Response responseCreated = page.waitForResponse(
                resp -> resp.url().contains("/created"),
                linksPage::clickCreatedLinks
        );
        assertThat(responseCreated.status()).as("API status for Created").isEqualTo(201);
        assertThat(page.locator("#linkResponse").innerText())
                .as("UI text for Created")
                .contains("201")
                .contains("Created");


        Response responseNoContent = page.waitForResponse(
                resp -> resp.url().contains("/no-content"),
                linksPage::clickNoContentLinks
        );
        assertThat(responseNoContent.status()).as("API status for No Content").isEqualTo(204);
        assertThat(page.locator("#linkResponse").innerText())
                .as("UI text for No Content")
                .contains("204")
                .contains("No Content");


        Response responseMoved = page.waitForResponse(
                resp -> resp.url().contains("/moved"),
                linksPage::clickMovedLinks
        );
        assertThat(responseMoved.status()).as("API status for Moved").isEqualTo(301);
        assertThat(page.locator("#linkResponse").innerText())
                .as("UI text for Moved")
                .contains("301")
                .contains("Moved");

        Response responseBadRequest = page.waitForResponse(
                resp -> resp.url().contains("/bad-request"),
                linksPage::clickBadRequestLinks
        );
        assertThat(responseBadRequest.status()).as("API status for Bad Request").isEqualTo(400);
        assertThat(page.locator("#linkResponse").innerText())
                .as("UI text for Bad Request")
                .contains("400")
                .contains("Bad Request");


        Response responseUnauthorized = page.waitForResponse(
                resp -> resp.url().contains("/unauthorized"),
                linksPage::clickUnauthorizedLinks
        );
        assertThat(responseUnauthorized.status()).as("API status for Unauthorized").isEqualTo(401);
        assertThat(page.locator("#linkResponse").innerText())
                .as("UI text for Unauthorized")
                .contains("401")
                .contains("Unauthorized");

        Response responseForbidden = page.waitForResponse(
                resp -> resp.url().contains("/forbidden"),
                linksPage::clickForbiddenLinks
        );
        assertThat(responseForbidden.status()).as("API status for Forbidden").isEqualTo(403);
        assertThat(page.locator("#linkResponse").innerText())
                .as("UI text for Forbidden")
                .contains("403")
                .contains("Forbidden");


        Response responseNotFound = page.waitForResponse(
                resp -> resp.url().contains("/invalid-url"),
                linksPage::clickNotFoundLinks
        );
        assertThat(responseNotFound.status()).as("API status for Not Found").isEqualTo(404);
        assertThat(page.locator("#linkResponse").innerText())
                .as("UI text for Not Found")
                .contains("404")
                .contains("Not Found");
    }
}

package ui;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LinksPage {

    private final Page page;

    public LinksPage(Page page) {
        this.page = page;
    }

    public void open() {
        page.navigate("https://demoqa.com/links");
    }

    public void clickHomeLink() {
        page.getByRole(AriaRole.LINK,
                        new Page.GetByRoleOptions()
                                .setName("Home")
                                .setExact(true))
                .click();
    }

    public void clickDynamicLink() {
        page.locator("#dynamicLink")
                .click();
    }

    public void clickCreatedLinks() {
        page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName("Created")).click();
    }

    public void clickNoContentLinks() {
        page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("No Content")).click();
    }

    public void clickMovedLinks() {
        page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Moved")).click();
    }

    public void clickBadRequestLinks() {
        page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Bad Request")).click();
    }

    public void clickUnauthorizedLinks() {
        page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Unauthorized")).click();
    }

    public void clickForbiddenLinks() {
        page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Forbidden")).click();
    }

    public void clickNotFoundLinks() {
        page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Not Found")).click();
    }

}

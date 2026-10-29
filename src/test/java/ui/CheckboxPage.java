package ui;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CheckboxPage {
    private final Page page;

    public CheckboxPage(Page page) {
        this.page = page;
    }

    public void open() {
        page.navigate("https://demoqa.com/checkbox");
    }

    public void clickHomeCheckbox() {
        page.getByRole(AriaRole.CHECKBOX,
                new Page.GetByRoleOptions().setName("Home")
        ).check();
    }
}

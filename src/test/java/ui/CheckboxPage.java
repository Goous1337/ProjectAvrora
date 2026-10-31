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
        // Ищем чекбокс по роли и имени "Home" и ставим галочку
        page.getByRole(AriaRole.CHECKBOX,
                new Page.GetByRoleOptions().setName("Home")
        ).check();
    }

    // Метод для получения текста результата
    public String getResultText() {
        // В Playwright текст блока достается через .textContent() или .innerText()
        return page.locator("#result").textContent();
    }
}

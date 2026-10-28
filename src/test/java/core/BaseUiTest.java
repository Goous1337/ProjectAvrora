package core;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public abstract class BaseUiTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeEach
    void setUpUi() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); //TODO headless меняем в true/false
        page = browser.newPage();
    }

    @AfterEach
    void tearDownUi() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}

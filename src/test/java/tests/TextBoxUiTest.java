package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TextBoxUiTest {

    private Playwright playwright;
    private Browser browser;
    private Page page;

    @BeforeEach
    void setUp(){
        playwright = Playwright.create();

        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        page = browser.newPage();
    }

    @AfterEach
    void teatDown() {

        browser.close();
        playwright.close();

    }

}

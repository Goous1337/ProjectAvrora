package tests;

import core.BaseUiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.ButtonsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ButtonsPageTest extends BaseUiTest {

    @Test
    @DisplayName("Checking all three button clicks")
    void clickedButtonsTest(){

        ButtonsPage buttonsPage = new ButtonsPage(page);
        buttonsPage.open();

        buttonsPage.clickDoubleClickButtonsMouse();
        buttonsPage.clickRightButtonMouse();
        buttonsPage.clickButtonsClickMe();

        String doubleClickMessage = page.locator("#doubleClickMessage").innerText();
        assertThat(doubleClickMessage)
                .as("Double click message")
                .contains("You have done a double click");

        String rightClickMessage = page.locator("#rightClickMessage").innerText();
        assertThat(rightClickMessage)
                .as("Right click message")
                .contains("You have done a right click");

        String dynamicClickMessage = page.locator("#dynamicClickMessage").innerText();
        assertThat(dynamicClickMessage)
                .as("Dynamic click message")
                .contains("You have done a dynamic click");
    }
}
package tests;

import core.BaseUiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.CheckboxPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxUiTest extends BaseUiTest {

    @Test
    @DisplayName("Check Home checkbox and verify result text")
    void checkHomeCheckbox() {
        CheckboxPage checkboxPage = new CheckboxPage(page);

        checkboxPage.open();

        checkboxPage.clickHomeCheckbox();

        String result = checkboxPage.getResultText();

        assertThat(result)
                .as("Result block should not be empty")
                .isNotEmpty()
                .as("Result should contain 'home'")
                .contains("home");
    }
}
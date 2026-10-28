package tests;

import core.BaseUiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.TextBoxPage;

import static org.assertj.core.api.Assertions.assertThat;

public class TextBoxUiTest extends BaseUiTest {

    @Test
    @DisplayName("Fill Text Box form and verify output")
    void fillTextBoxForm() {
        TextBoxPage textBoxPage = new TextBoxPage(page);

        textBoxPage.open();

        textBoxPage.fillFullName("Ivan Ivanov");
        textBoxPage.fillEmail("ivan@test.com");

        textBoxPage.clickSubmit();

        String output = textBoxPage.getOutputText();
        assertThat(output).contains("Ivan Ivanov");
    }
}

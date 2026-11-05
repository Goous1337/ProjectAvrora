package ui;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;

public class ButtonsPage {

    private final Page page;
    private final String doubleClickButtons = "#doubleClickBtn";
    private final String rightClickButtons = "#rightClickBtn";
    private final String meClickButtons = "#R3qrT";

    public ButtonsPage(Page page) {
        this.page = page;
    }

    public void open() {
        page.navigate("https://demoqa.com/buttons");
    }

    public void clickDoubleClickButtonsMouse(){
        page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Double Click Me")).dblclick();
    }

    public void clickRightButtonMouse(){
        page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Right Click Me"))
                .click(new Locator.ClickOptions()
                        .setButton(MouseButton.RIGHT));
    }

    public void clickButtonsClickMe(){
        page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Click Me")
                        .setExact(true))
                .click();
    }
}

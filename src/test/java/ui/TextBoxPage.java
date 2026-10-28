package ui;

    import com.microsoft.playwright.Page;

    public class TextBoxPage {
        private final Page page;

        private final String fullNameInput = "#userName";
        private final String emailInput = "#userEmail";
        private final String submitButton = "#submit";
        private final String outputBlock = "#output";

        public TextBoxPage(Page page) {
            this.page = page;
        }

        public void open() {
            page.navigate("https://demoqa.com/text-box");
        }

        public void fillFullName(String name) {
            page.fill(fullNameInput, name);
        }

        public void fillEmail(String email) {
            page.fill(emailInput, email);
        }

        public void clickSubmit() {
            page.click(submitButton);
        }

        public String getOutputText() {
            return page.locator(outputBlock).innerText();
        }

}

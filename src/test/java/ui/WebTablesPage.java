package ui;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class WebTablesPage {

    private final Page page;
    private final String firstNameInput = "#firstName";
    private final String lastNameInput = "#lastName";
    private final String emailInput = "#userEmail";
    private final String ageInput = "#age";
    private final String salaryInput = "#salary";
    private final String departmentInput = "#department";
    private final String submitButton = "#submit";


    public WebTablesPage(Page page) {
        this.page = page;
    }

    public void open() {
        page.navigate("https://demoqa.com/webtables");
    }

    public void clickAddButton() {
        page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Add")).click();
    }

    public void fillFirstName(String name) {
        page.fill(firstNameInput, name);
    }

    public void fillLastName(String name) {
        page.fill(lastNameInput, name);
    }

    public void fillEmail(String email) {
        page.fill(emailInput, email);
    }

    public void fillAge(String age) {
        page.fill(ageInput, age);
    }

    public void fillSalary(String salary) {
        page.fill(salaryInput, salary);
    }

    public void fillDepartment(String department){
        page.fill(departmentInput, department);
    }

    public void clickSubmit(){
        page.click(submitButton);
    }

}

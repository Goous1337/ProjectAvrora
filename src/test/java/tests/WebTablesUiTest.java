package tests;

import core.BaseUiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.WebTablesPage;
import utils.RandomDataGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTablesUiTest extends BaseUiTest {

    @Test
    @DisplayName("Add new user to Web Tables")
    void fillWebTables() {
        WebTablesPage webTablesPage = new WebTablesPage(page);

        webTablesPage.open();

        webTablesPage.clickAddButton();

        String firstName = RandomDataGenerator.getFirstName();
        String lastName = RandomDataGenerator.getLastName();
        String email = RandomDataGenerator.getEmail();
        String age = String.valueOf(RandomDataGenerator.getAge());
        String salary = String.valueOf(RandomDataGenerator.getSalary());
        String department = RandomDataGenerator.getDepartment();

        webTablesPage.fillFirstName(firstName);
        webTablesPage.fillLastName(lastName);
        webTablesPage.fillEmail(email);
        webTablesPage.fillAge(age);
        webTablesPage.fillSalary(salary);
        webTablesPage.fillDepartment(department);

        webTablesPage.clickSubmit();

        String tableText = page.locator(".table").innerText();
        assertThat(tableText)
                .as("Table should contain the new user email")
                .contains(email);
    }
}

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

        // 1. Открываем страницу
        webTablesPage.open();

        // 2. Нажимаем "Add" (метод уже есть в Page Object)
        webTablesPage.clickAddButton();

        // 3. Генерируем данные (через наш RandomDataGenerator)
        String firstName = RandomDataGenerator.getFirstName();
        String lastName = RandomDataGenerator.getLastName();
        String email = RandomDataGenerator.getEmail();
        String age = String.valueOf(RandomDataGenerator.getAge());
        String salary = String.valueOf(RandomDataGenerator.getSalary());
        String department = RandomDataGenerator.getDepartment();

        // 4. Заполняем форму (используй методы из Page Object)
        webTablesPage.fillFirstName(firstName);
        webTablesPage.fillLastName(lastName);
        webTablesPage.fillEmail(email);
        webTablesPage.fillAge(age);
        webTablesPage.fillSalary(salary);
        webTablesPage.fillDepartment(department);

        // 5. Нажимаем Submit
        webTablesPage.clickSubmit();

        String tableText = page.locator(".table").innerText(); // <-- убедись, что селектор правильный!
        assertThat(tableText)
                .as("Table should contain the new user email")
                .contains(email);
    }
}

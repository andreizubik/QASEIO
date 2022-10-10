package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.byXpath;


public class ProjectsPage extends BaseTest {
    static Faker faker = new Faker();


    public static final By CREATE_PROJECT_BUTTON = By.id("createButton");
    public static final By PROJECT_NAME_INPUT = By.xpath("//input[@id='inputTitle']");
    public static final By PROJECT_CODE_INPUT = By.xpath("//input[@id='inputCode']");
    public static final By PROJECT_DESC_INPUT = By.xpath("//textarea[@id='inputDescription']");
    public static final By MEMBER_ACCESS_PRIVATE = By.xpath("//input[@id='accessNone']");
    public static final By CREATE_NEW_PROJECT_BUTTON = By.xpath("//button[@type='submit']");


    public void createProject(String title, String code, String description) {
        $(CREATE_PROJECT_BUTTON).click();
        $(PROJECT_NAME_INPUT).setValue(faker.esports().team());
        $(PROJECT_CODE_INPUT).setValue(faker.code().gtin8());
        $(PROJECT_DESC_INPUT).setValue(faker.music().genre());
        $(MEMBER_ACCESS_PRIVATE).click();
        $(CREATE_NEW_PROJECT_BUTTON).click();
    }

    public void isProjectExist(String projectName) {
        open("https://app.qase.io/projects");
        $(byXpath(String.format("//tbody//a[contains(text(), '%s')]", projectName))).shouldBe(Condition.visible);
    }

    public void deleteProject(String title) {
        open("https://app.qase.io/projects");
        $(byXpath(String.format("//a[text()='%s']", title))).click();
        $(byXpath("//span[text()='Settings']")).click();
        $(byXpath("//*[contains(text(), 'Delete project')]")).click();
        $(byXpath("//*[contains(text(), 'Delete project')]")).click();
    }

    public void projectNotExist(String projectName) {
        $(byXpath(String.format("//a[text()='%s']", projectName))).shouldNotBe(Condition.visible);
    }

    public void editProject(String newName) {
        $(byXpath("//span[text()='Settings']")).click();
        $("#inputTitle").setValue(newName);
        $("#update").click();
    }
}
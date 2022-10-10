package tests;

import com.codeborne.selenide.Condition;

import org.testng.annotations.Test;
import pages.ProjectsPage;

import static com.codeborne.selenide.Selenide.$;


public class LoginTest extends BaseTest {

    @Test(description = "Login credentials input")
    public void loginIntoSite() {
        loginPage.openPage();
        loginPage.login();
        $(ProjectsPage.CREATE_PROJECT_BUTTON).shouldBe(Condition.visible);
    }


}
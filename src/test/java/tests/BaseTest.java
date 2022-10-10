package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProjectsPage;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    LoginPage loginPage;
    ProjectsPage projectPage;
    String user;
    String password;

    @BeforeMethod
    public void setup() {
        Configuration.baseUrl= System.getProperty("QASE_URL", PropertyReader.getProperty("qase.url"));
        user = PropertyReader.getProperty("qase.user");
        password = PropertyReader.getProperty("qase.password");
        Configuration.browser = "edge";
        Configuration.headless = true;
        Configuration.timeout = 10000;
        //Configuration.clickViaJs = true;
        //Configuration.fastSetValue = true;


        loginPage = new LoginPage();
        projectPage = new ProjectsPage();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

        open();
        getWebDriver().manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        if(getWebDriver() != null)
        getWebDriver().quit();


    }
}

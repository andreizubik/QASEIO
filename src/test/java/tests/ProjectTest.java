package tests;

import com.codeborne.selenide.Condition;

import org.testng.annotations.Test;
import com.github.javafaker.Faker;


import static com.codeborne.selenide.Selenide.$;

public class ProjectTest extends BaseTest {
    Faker fakerName = new Faker();
    Faker fakerCode = new Faker();

    @Test
    public void createNewProject() {
        String projectName = fakerName.funnyName().name();
        String code = fakerCode.color().name();
        loginPage.openPage();
        loginPage.login(user, password);
        projectPage.createProject(projectName, "Test", code);
        projectPage.isProjectExist(projectName);
    }

    @Test
    public void deletePtoject() {
        String projectName = fakerName.funnyName().name();
        String code = fakerCode.color().name();
        loginPage.openPage();
        loginPage.login(user, password);
        projectPage.createProject(projectName, "Test", code);
        projectPage.deleteProject(projectName);
        projectPage.projectNotExist(projectName);

    }

    @Test
    public void renameProject() {
        String projectName = fakerName.funnyName().name();
        String code = fakerCode.color().name();
        String newName = "������������";
        loginPage.openPage();
        loginPage.login(user, password);
        projectPage.createProject(projectName, "Test", code);
        projectPage.editProject(newName);
        projectPage.isProjectExist(newName);
    }
}

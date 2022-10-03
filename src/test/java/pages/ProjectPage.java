package pages;

import com.codeborne.selenide.Condition;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    public void isOpened() {
        $("#createButton").shouldBe(Condition.visible);

    }
}

package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

        public void openPage() {
            open("/login");

        }

        public void login(String user, String password) {
            $("#inputEmail").sendKeys(user);
            $("#inputPassword").sendKeys(password);
            $("#btnLogin").click();
        }

    public void login() {
    }
}


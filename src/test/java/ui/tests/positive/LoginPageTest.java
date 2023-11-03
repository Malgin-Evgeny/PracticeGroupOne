package ui.tests.positive;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.baseItems.Credentials;
import ui.pages.LoginPage;

import static io.qameta.allure.SeverityLevel.NORMAL;
@Epic("Проверка сайта MAXIMA")
@Feature("Проверка функицонала страниц")
public class LoginPageTest extends LoginPage {
    @Test
    @Story("Проверка логина")
    @Severity(NORMAL)
    public void loginPageLoginTest() {
        login(Credentials.getLogin(),Credentials.getPassword());
    }
    @Test
    @Story("Проверка логина")
    @Severity(NORMAL)
    public void loginPageLogoutTest() {
        login(Credentials.getLogin(),Credentials.getPassword());
        logout();
    }
    @Test
    @Story("Проверка смены цвета темы")
    @Severity(NORMAL)
    public void loginPageColorTest() {
        changeColor();
    }

    @Test
    @Story("Проверка смены языка страницы")
    @Severity(NORMAL)
    public void loginPageChangeLanguageTest() {
        changeLanguage();
    }

    @Test
    @Story("Проверка формы восстановления пароля")
    @Severity(NORMAL)
    public void LoginPageRecoverPasswordTest() {
        recoverPassword(Credentials.getEmail());
        login(Credentials.getLogin(),Credentials.getPassword());
    }
}
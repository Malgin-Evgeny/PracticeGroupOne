package ui.tests.positive;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.pages.LoginPage;

import static io.qameta.allure.SeverityLevel.NORMAL;
@Epic("Проверка сайта MAXIMA")
@Feature("Проверка функицонала страниц")
public class LoginPageTest extends LoginPage {
    String email = "exampleEmail@gmail.com";
    String login = "aqa_01";
    String password = "783891";
    @Test
    @Story("Проверка логина")
    @Severity(NORMAL)
    public void loginPageLoginTest() {
        login(login,password);
    }
    @Test
    @Story("Проверка логина")
    @Severity(NORMAL)
    public void loginPageLogoutTest() {
        login(login,password);
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
        recoverPassword(email);
        login(login,password);
    }
}
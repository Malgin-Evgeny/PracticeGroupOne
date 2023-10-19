package ui;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.pages.LoginPage;

import static io.qameta.allure.SeverityLevel.NORMAL;

public class LoginPageTest extends LoginPage {
    @Test
    @Epic("Проверка сайта MAXIMA")
    @Feature("Проверка функицонала страниц")
    @Story("Проверка логина")
    @Description("Позитивный")
    @Severity(NORMAL)
    public void loginPageLoginTest() {
        login();
    }
    @Test
    @Epic("Проверка сайта MAXIMA")
    @Feature("Проверка функицонала страниц")
    @Story("Проверка логина")
    @Description("Позитивный")
    @Severity(NORMAL)
    public void loginPageLogoutTest() {
        login();
        logout();
    }
    @Test
    @Epic("Проверка сайта MAXIMA")
    @Feature("Проверка функицонала страниц")
    @Story("Проверка логина")
    @Description("Негативный")
    @Severity(NORMAL)
    public void loginPageNegativeLoginTest() {
        loginNegative();
    }
    @Test
    @Epic("Проверка сайта MAXIMA")
    @Feature("Проверка функицонала страниц")
    @Story("Проверка логина")
    @Description("Негативный")
    @Severity(NORMAL)
    public void loginPageNegativePasswordTest() {
        loginNegativePass();
    }
    @Test
    @Epic("Проверка сайта MAXIMA")
    @Feature("Проверка функицонала страниц")
    @Story("Проверка смены цвета темы")
    @Description("Позитивный")
    @Severity(NORMAL)
    public void loginPageColorTest() {
        changeColor();
    }

    @Test
    @Epic("Проверка сайта MAXIMA")
    @Feature("Проверка функицонала страниц")
    @Story("Проверка смены языка страницы")
    @Description("Позитивный")
    @Severity(NORMAL)
    public void loginPageChangeLanguageTest() {
        changeLanguage();
    }

    @Test
    @Epic("Проверка сайта MAXIMA")
    @Feature("Проверка функицонала страниц")
    @Story("Проверка формы восстановления пароля")
    @Description("Позитивный")
    @Severity(NORMAL)
    public void LoginPageRecoverPasswordTest() {
        recoverPassword();
        login();
    }
}
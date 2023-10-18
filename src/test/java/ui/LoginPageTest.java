package ui;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.pages.LoginPage;

import static io.qameta.allure.SeverityLevel.NORMAL;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage = new LoginPage();

    @Test
    @Epic("Проверка сайта MAXIMA")
    @Feature("Проверка функицонала страниц")
    @Story("Проверка смены цвета темы")
    @Description("Тема")
    @Severity(NORMAL)
    public void checkChangeColorTest() {
        loginPage.loginMethod();
        loginPage.assertLoginSuccess();
    }

    @Test
    @Epic("Проверка сайта MAXIMA")
    @Feature("Проверка функицонала страниц")
    @Story("Проверка смены языка страницы")
    @Description("Тема")
    @Severity(NORMAL)
    public void checkChangeLanguageTest() {
        loginPage.loginMethod();
        loginPage.logout();
        loginPage.changeLanguage();
    }

    @Test
    @Epic("Проверка сайта MAXIMA")
    @Feature("Проверка функицонала страниц")
    @Story("Проверка смены цвета темы")
    @Description("Тема")
    @Severity(NORMAL)
    public void recoverPasswordTest() {
        loginPage.recoverPassword();
        loginPage.loginMethod();
    }
}
package ui;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.pages.LoginPage;

import static io.qameta.allure.SeverityLevel.NORMAL;

public class LoginPageTest extends LoginPage {
    @Test
    @Epic("Проверка сайта MAXIMA")
    @Feature("Проверка функицонала страниц")
    @Story("Проверка смены цвета темы")
    @Description("Тема")
    @Severity(NORMAL)
    public void loginPageColorTest() {
        logout();
        changeColor();
    }

    @Test
    @Epic("Проверка сайта MAXIMA")
    @Feature("Проверка функицонала страниц")
    @Story("Проверка смены языка страницы")
    @Description("Тема")
    @Severity(NORMAL)
    public void loginPageChangeLanguageTest() {
        logout();
        changeLanguage();
    }

    @Test
    @Epic("Проверка сайта MAXIMA")
    @Feature("Проверка функицонала страниц")
    @Story("Проверка смены цвета темы")
    @Description("Тема")
    @Severity(NORMAL)
    public void recoverPasswordTest() {
        logout();
        recoverPassword();
    }
}

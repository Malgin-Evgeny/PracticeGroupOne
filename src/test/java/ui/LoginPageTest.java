package ui;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.pages.LoginPage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;

public class LoginPageTest extends LoginPage {
    @Epic("Проверка сайта MAXIMA")
    @Feature("Проверка функицонала страниц")
    @Test
    @Story("Проверка смены цвета темы")
    @Description("Тема")
    @Severity(NORMAL)
    public void loginPageColorTest() {
        LoginPage loginPage = new LoginPage();
        try {
            Method method = LoginPage.class.getMethod("openBrowserWithUrlForLoginPage");
            method.invoke(loginPage);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            assertColor();
        }
    }
}

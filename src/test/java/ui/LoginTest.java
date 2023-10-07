package ui;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.pages.LoginPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class
LoginTest extends LoginPage {
        @Epic("Проверка сайта MAXIMA")
        @Feature("Проверка функицонала страниц")
        @Test
        @Story("Проверка входа с корректными входными параметрами")
        @Description("Логин")
        @Severity(CRITICAL)
        public void loginTest() {
            loginVoid();
            assertLoginSuccess();
}}

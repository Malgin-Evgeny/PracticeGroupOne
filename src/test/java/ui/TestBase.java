package ui;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestBase extends PageObject {
    final String URL = "https://dev.learn.maxima.school/";
    private final SelenideElement loginForm = $x("//div[@class=\"LoginForm_login-form__header__Ad3b9\"]");

    @BeforeMethod
    @Step("Открытие сайта и логин")
    public void openBrowserWithUrl() {
        Configuration.browser = Browsers.CHROME;
        open(URL);
        refresh();
        loginMethod();
        assertLoginSuccess();
    }

    @AfterMethod
    @Step("закрыть браузер")
    public void closedBrowser() {
        closeWebDriver();
    }

    @Step("Перезагрузка страницы если элемент невидим")
    public void refresh() {
        loginForm.shouldBe(Condition.visible);
        if (loginForm.exists()) {
            getWebDriver().manage().window().maximize();
        } else {
            Selenide.refresh();
            getWebDriver().manage().window().maximize();
        }
    }

    @Step("Вход в систему")
    public void loginMethod() {
        checkLoginInput();
        sendLogin();
        checkPasswordInput();
        sendPassword();
        checkLoginButton();
    }

    @Step("Разлогин")
    public void logout() {
        checkLogoutButton();
        clickLogout();
    }
}


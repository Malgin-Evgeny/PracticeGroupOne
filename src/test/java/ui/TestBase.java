package ui;

import com.codeborne.selenide.*;

import io.qameta.allure.Step;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class TestBase extends PageObject {
    final String URL = "https://dev.learn.maxima.school/";
    private final SelenideElement loginForm = $x("//div[@class=\"LoginForm_login-form__header__Ad3b9\"]");
    private final SelenideElement loginInput = $x("//input[@type='text' and contains(@class, 'MuiInputBase-input')]");
    private final SelenideElement passwordInput = $x("//input[@type='password']");
    private final SelenideElement loginButton = $x("//button[contains(@class, 'MuiButton-containedPrimary') or contains(text(), 'Войти')]");
    private final SelenideElement logoutButton = $x("//*[@data-testid=\"ExitToAppIcon\"]");
    private final String login = "aqa_01";
    private final String password = "783891";
    private final SelenideElement welcome = $x("//*[@class=\"TitleBase_title-base__n1Oxe\"]");

    @BeforeClass
    public static void setUp() {
        Configuration.remote = "http://194.58.120.63:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("latest");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
    }

    @BeforeMethod
    @Step("Открытие сайта и логин")
    public void openBrowserWithUrl() {
        open(URL);
        refresh();
        login();
    }

    @AfterMethod
    @Step("Закрыть браузер")
    public void closedBrowser() {
        closeWebDriver();
    }

    @Step("Перезагрузка страницы если элемент невидим")
    public void refresh() {
        if (loginForm.shouldBe(Condition.visible).isDisplayed()) {
            getWebDriver().manage().window().maximize();
        } else {
            Selenide.refresh();
            getWebDriver().manage().window().maximize();
        }
    }

    @Step("Вход в систему")
    public void login() {
        sendInLine(loginInput, login);
        sendInLine(passwordInput, password);
        click(loginButton);
    }

    @Step("Выход из системы")
    public void logout() {
        click(logoutButton);
        searchElement(loginForm);
    }
}
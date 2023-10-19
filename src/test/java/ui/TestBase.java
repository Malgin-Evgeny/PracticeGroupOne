package ui;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestBase extends PageObject {
    String URL = "https://dev.learn.maxima.school/";
    private final SelenideElement loginForm = $x("//div[@class=\"LoginForm_login-form__header__Ad3b9\"]");

    @BeforeClass
    public static void setUp() {
        Configuration.remote = "http://194.58.120.63:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserCapabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVNC", true);
        }});
    }

    @BeforeMethod
    @Step("Открытие сайта и логин")
    public void openBrowserWithUrl() {
        open(URL);
        refresh();
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
}
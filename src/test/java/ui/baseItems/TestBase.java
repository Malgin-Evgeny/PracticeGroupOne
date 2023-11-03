package ui.baseItems;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestBase {
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
        open(HelpLocators.getURLmaxima());
        refresh();
    }

    @AfterMethod
    @Step("Закрыть браузер")
    public void closedBrowser() {
        closeWebDriver();
    }

    @Step("Перезагрузка страницы если элемент невидим")
    public void refresh() {
        if (HelpLocators.getLoginForm().shouldBe(Condition.visible).isDisplayed()) {
            getWebDriver().manage().window().maximize();
        } else {
            Selenide.refresh();
            getWebDriver().manage().window().maximize();
        }
    }

    @Step("Ввод в строку")
    public void sendInLine(SelenideElement selenideElement, String string) {
        Assert.assertTrue(selenideElement.shouldBe(Condition.visible).isDisplayed());
        $(selenideElement).sendKeys(string);
    }

    @Step("Проверка видимости элемента")
    public void assertVisible(SelenideElement selenideElement) {
        Assert.assertTrue(selenideElement.shouldBe(Condition.visible).isDisplayed());
    }

    @Step("Проверка видимости элемента и клик")
    public void click(SelenideElement selenideElement) {
        Assert.assertTrue(selenideElement.shouldBe(Condition.visible).isDisplayed());
        selenideElement.click();
    }
    @Step("Ввести логин")
    public void loginInput(SelenideElement loginInput,String login) {
        sendInLine(loginInput, login);
    }

    @Step("Ввести пароль")
    public void passwordInput(SelenideElement passwordInput, String password) {
        sendInLine(passwordInput, password);
    }
}
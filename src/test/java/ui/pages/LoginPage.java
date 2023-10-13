package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;
import ui.TestBase;

import java.net.URL;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginPage extends TestBase {
    private final SelenideElement blackButton = $x("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-1q60gj7']");
    private final SelenideElement whiteButton = $x("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-qtyozs']");
    private final SelenideElement whiteColor = $x("//*[contains(@style,'background-color: rgb(248, 248, 248);')]\n");
    private final SelenideElement blackColor = $x("//*[contains(@style,'background-color: rgb(39, 39, 39);')]");

    @Step("Открыть сайт")
    public void openBrowserWithUrlForLoginPage() {
        open(URL);
        getWebDriver().manage().window().maximize();
    }

    @Step("Метод сменяющий цвет")
    public void assertColor() {
        findWhiteColorButton();
        clickWhiteColorButton();
        checkChangeWhiteToBlackColor();
        findBlackColorButton();
        clickBlackColorButton();
    }

    @Step("Проверка видимости кнопки смены цвета темы сайта")
    public void findWhiteColorButton() {
        whiteButton.shouldBe(Condition.visible);
        Assert.assertTrue(whiteButton.isDisplayed());
    }

    @Step("Сменить цвет")
    public void clickWhiteColorButton() {
        $(whiteButton).click();
    }

    @Step("Проверка видимости кнопки смены цвета темы сайта")
    public void findBlackColorButton() {
        blackButton.shouldBe(Condition.visible);
        Assert.assertTrue(blackButton.isDisplayed());
    }

    @Step("Поиск тёмного цвета темы окна логина")
    public void checkChangeWhiteToBlackColor() {
        $(blackColor).shouldBe(Condition.visible);
        Assert.assertTrue(blackColor.isDisplayed());
    }

    @Step("Сменить цвет")
    public void clickBlackColorButton() {
        $(blackButton).click();
    }
}



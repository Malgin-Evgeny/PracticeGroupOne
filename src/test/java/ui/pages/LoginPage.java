package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;
import ui.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends TestBase {
    private final SelenideElement blackButton = $x("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-1q60gj7']");
    private final SelenideElement whiteButton = $x("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-qtyozs']");
    private final SelenideElement whiteColor = $x("//*[contains(@style,'background-color: rgb(248, 248, 248);')]\n");
    private final SelenideElement blackColor = $x("//*[contains(@style,'background-color: rgb(39, 39, 39);')]");
    private final SelenideElement classWhite = $x("//*[@class='']");
    private final SelenideElement ruLang = $x("//*[@data-value=\"ru\"]");
    private final SelenideElement enLang = $x("//*[@data-value=\"en\"]");
    private final SelenideElement languageButton = $x("//*[@role=\"button\"]");
    private final SelenideElement enAuthorize = $x("//*[contains(text(), 'Authorize')]");
    private final SelenideElement reAuthorize = $x("//*[contains(text(), 'Авторизация')]");
    private final SelenideElement forgotPassword = $x("//button[contains(text(), 'Забыли пароль?')]");
    private final SelenideElement lineInputEmail = $x("//input[@type='text']");
    private final SelenideElement recoverPasswordButton = $x("//button[contains(text(), 'Востановить пароль')]");
    private final String email = "exampleEmail@gmail.com";

    @Step("Метод сменяющий цвет")
    public void changeColor() {
        findWhiteColorButton();
        clickWhiteColorButton();
        findChangeWhiteToBlackColor();
        findBlackColorButton();
        clickBlackColorButton();
        findChangeBlackToWhiteColor();
        assertTrueCheckColorClass();
    }

    @Step("Метод меняющий язык")
    public void changeLanguage() {
        checkVisibleLanguageButton();
        clickEngLanguage();
        checkEngLang();
        checkVisibleLanguageButton();
        clickRuLanguage();
        checkRuLang();
    }

    @Step("Метод восстановить пароль")
    public void recoverPassword() {
        clickForgotPassword();
        findLineAndClickToInputEmail();
        sendEmail();
        findAndClickToRecoverPassword();
    }

    @Step("Проверка видимости кнопки смены цвета темы сайта")
    public void findWhiteColorButton() {
        Assert.assertTrue(whiteButton.shouldBe(Condition.visible).isDisplayed());
    }

    @Step("Проверка видимости кнопки смены цвета темы сайта")
    public void findBlackColorButton() {
        Assert.assertTrue(blackButton.shouldBe(Condition.visible).isDisplayed());
    }

    @Step("Сменить цвет")
    public void clickWhiteColorButton() {
        $(whiteButton).click();
    }

    @Step("Сменить цвет")
    public void clickBlackColorButton() {
        $(blackButton).click();
    }

    @Step("Поиск светлого цвета темы окна логина")
    public void findChangeBlackToWhiteColor() {
        Assert.assertTrue($(whiteColor).shouldBe(Condition.visible).isDisplayed());
    }

    @Step("Поиск тёмного цвета темы окна логина")
    public void findChangeWhiteToBlackColor() {
        Assert.assertTrue($(blackColor).shouldBe(Condition.visible).isDisplayed());
    }

    @Step("Проверка смены цвета фона страницы")
    public void assertTrueCheckColorClass() {
        Assert.assertTrue($(classWhite).shouldBe(Condition.visible).isDisplayed());
    }

    @Step("Проверка наличия кнопки смены языкаи нажатие на неё")
    public void checkVisibleLanguageButton() {
        Assert.assertTrue($(languageButton).shouldBe(Condition.visible).isDisplayed());
        languageButton.click();
    }

    @Step("Выбрать в меню En")
    public void clickEngLanguage() {
        Assert.assertTrue($(enLang).shouldBe(Condition.visible).isDisplayed());
        enLang.click();
    }

    @Step("Выбрать в меню En")
    public void clickRuLanguage() {
        Assert.assertTrue($(ruLang).shouldBe(Condition.visible).isDisplayed());
        ruLang.click();
    }

    @Step("Проверка что сейчас русский язык")
    public void checkRuLang() {
        Assert.assertTrue($(reAuthorize).shouldBe(Condition.visible).isDisplayed());
    }

    @Step("Проверка что сейчас английский язык")
    public void checkEngLang() {
        Assert.assertTrue($(enAuthorize).shouldBe(Condition.visible).isDisplayed());
    }

    @Step("Найти и нажать элемент Забыли пароль?")
    public void clickForgotPassword() {
        Assert.assertTrue($(forgotPassword).shouldBe(Condition.visible).isDisplayed());
        forgotPassword.click();
    }

    @Step("Найти и кликнуть на строку ввода email")
    public void findLineAndClickToInputEmail() {
        Assert.assertTrue($(lineInputEmail).shouldBe(Condition.visible).isDisplayed());
        lineInputEmail.click();
    }

    @Step("Ввести email")
    public void sendEmail() {
        lineInputEmail.sendKeys(email);
    }

    @Step("Найти и нажать кнопку восстановить пароль")
    public void findAndClickToRecoverPassword() {
        Assert.assertTrue($(recoverPasswordButton).shouldBe(Condition.visible).isDisplayed());
        recoverPasswordButton.click();
    }
}
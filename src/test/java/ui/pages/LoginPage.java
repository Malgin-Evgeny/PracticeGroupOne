package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;
import ui.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage  {

    private final SelenideElement ruLang = $x("//*[@data-value=\"ru\"]");
    private final SelenideElement enLang = $x("//*[@data-value=\"en\"]");
    private final SelenideElement languageButton = $x("//*[@role=\"button\"]");
    private final SelenideElement enAuthorize = $x("//*[contains(text(), 'Authorize')]");
    private final SelenideElement reAuthorize = $x("//*[contains(text(), 'Авторизация')]");
    private final SelenideElement forgotPassword = $x("//button[contains(text(), 'Забыли пароль?')]");
    private final SelenideElement lineInputEmail = $x("//input[@type='text']");
    private final SelenideElement recoverPasswordButton = $x("//button[contains(text(), 'Востановить пароль')]");
    private final String email = "exampleEmail@gmail.com";
    private final SelenideElement loginInput = $x("//input[@type='text' and contains(@class, 'MuiInputBase-input')]");
    private final SelenideElement passwordInput = $x("//input[@type='password']");
    private final SelenideElement loginButton = $x("//button[contains(@class, 'MuiButton-containedPrimary') or contains(text(), 'Войти')]");
    private final SelenideElement logoutButton = $x("//*[@data-testid=\"ExitToAppIcon\"]");
    private final String login = "aqa_01";
    private final String password = "783891";
    private final SelenideElement welcome = $x("//*[@class=\"TitleBase_title-base__n1Oxe\"]");

    public LoginPage(){
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

    @Step("Проверка видимости поля ввода логина")
    public void checkLoginInput() {
        loginInput.shouldBe(Condition.visible);
        Assert.assertTrue(loginInput.isDisplayed());
    }

    @Step("Ввод логина")
    public void sendLogin() {
        $(loginInput).click();
        $(loginInput).sendKeys(login);
    }

    @Step("Проверка видимости поля ввода пароля")
    public void checkPasswordInput() {
        passwordInput.shouldBe(Condition.visible);
        Assert.assertTrue(passwordInput.isDisplayed());
    }

    @Step("ввод пароля")
    public void sendPassword() {
        $(passwordInput).click();
        $(passwordInput).sendKeys(password);
    }

    @Step("Проверка видимости и нажатие на кнопку логин")
    public void checkLoginButton() {
        loginButton.shouldBe(Condition.visible);
        Assert.assertTrue(loginButton.isDisplayed());
        $(loginButton).click();
    }

    @Step("Проверка наличия элемента на основной странице для подтверждения успешного логина")
    public void assertLoginSuccess() {
        welcome.shouldBe(Condition.visible);
        Assert.assertTrue(welcome.isDisplayed());
    }

    @Step("Проверка видимости кнопки логаут")
    public void checkLogoutButton() {
        logoutButton.shouldBe(Condition.visible);
        Assert.assertTrue(logoutButton.isDisplayed());
    }

    @Step("Нажать на логин")
    public void clickLogout() {
        logoutButton.click();
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
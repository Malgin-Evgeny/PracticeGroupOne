package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.TestBase;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends TestBase {
    private final SelenideElement loginInput = $x("//input[@type='text' and contains(@class, 'MuiInputBase-input')]");
    private final SelenideElement passwordInput = $x("//input[@type='password']");
    private final SelenideElement loginButton = $x("//button[contains(@class, 'MuiButton-containedPrimary') or contains(text(), 'Войти')]");
    private final SelenideElement logoutButton = $x("//*[@data-testid=\"ExitToAppIcon\"]");
    private final SelenideElement blackButton = $x("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-1q60gj7']");
    private final SelenideElement whiteButton = $x("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-qtyozs']");
    private final SelenideElement whiteColor = $x("//*[contains(@style,'background-color: rgb(248, 248, 248);')]\n");
    private final SelenideElement blackColor = $x("//*[contains(@style,'background-color: rgb(39, 39, 39);')]");
    private final SelenideElement ruLang = $x("//*[@data-value=\"ru\"]");
    private final SelenideElement enLang = $x("//*[@data-value=\"en\"]");
    private final SelenideElement languageButton = $x("//*[@role=\"button\"]");
    private final SelenideElement enAuthorize = $x("//*[contains(text(), 'Authorize')]");
    private final SelenideElement ruAuthorize = $x("//*[contains(text(), 'Авторизация')]");
    private final SelenideElement forgotPassword = $x("//button[contains(text(), 'Забыли пароль?')]");
    private final SelenideElement lineInputEmail = $x("//input[@type='text']");
    private final SelenideElement recoverPasswordButton = $x("//button[contains(text(), 'Востановить пароль')]");
    String email = "exampleEmail@gmail.com";
    String login = "aqa_01";
    String password = "783891";
    String loginFake = "aAqQaA_!&@#4";
    String passwordFake = "1293128487128497124";

    @Step("Тестовый метод Вход в систему")
    public void login() {
        loginInput();
        passwordInput();
        clickLoginButton();
        searchElement(logoutButton);
    }

    @Step("Тестовый негативный метод Вход в систему")
    public void loginNegative() {
        loginInputFake();
        passwordInput();
        clickLoginButton();
        searchElement(loginButton);
    }

    @Step("Тестовый негативный метод Вход в систему")
    public void loginNegativePass() {
        loginInput();
        inputFakePassword();
        clickLoginButton();
        searchElement(loginButton);
    }

    @Step("Тестовый метод Выход из системы")
    public void logout() {
        clickLogoutButton();
        searchElement(loginButton);
    }

    @Step("Тестовый метод сменяющий цвет")
    public void changeColor() {
        clickWhiteColorButton();
        assertTrueCheckBlackColor();
        clickBlackColorButton();
        assertTrueCheckWhiteColor();
    }

    @Step("Тестовый метод меняющий язык")
    public void changeLanguage() {
        clickLanguageButton();
        clickEngLanguage();
        checkEngLang();
        clickLanguageButton();
        clickRuLanguage();
        assertTrueRuLang();
    }

    @Step("Тестовый метод восстановить пароль")
    public void recoverPassword() {
        clickForgotPassword();
        clickInputEmail();
        sendEmail();
        clickRecoverPassword();
    }

    @Step("Ввести логин")
    public void loginInput() {
        searchElement(loginInput);
        sendInLine(loginInput, login);
    }

    @Step("Ввести пароль")
    public void passwordInput() {
        searchElement(passwordInput);
        sendInLine(passwordInput, password);
    }

    @Step("Клик на кнопку логин")
    public void clickLoginButton() {
        searchElement(loginButton);
        click(loginButton);
    }

    @Step("Клик на кнопку логаут")
    public void clickLogoutButton() {
        searchElement(logoutButton);
        click(logoutButton);
    }

    @Step("Ввести неверный логин")
    public void loginInputFake() {
        searchElement(loginInput);
        sendInLine(loginInput, loginFake);
    }

    @Step("Ввести неверный пароль")
    public void inputFakePassword() {
        searchElement(passwordInput);
        sendInLine(passwordInput, passwordFake);
    }

    @Step("Сменить цвет")
    public void clickWhiteColorButton() {
        searchElement(whiteButton);
        click(whiteButton);
    }

    @Step("Сменить цвет")
    public void clickBlackColorButton() {
        searchElement(blackButton);
        click(blackButton);
    }

    @Step("Проверка смены цвета фона страницы")
    public void assertTrueCheckWhiteColor() {
        searchElement(whiteColor);
    }

    @Step("Проверка смены цвета фона страницы")
    public void assertTrueCheckBlackColor() {
        searchElement(blackColor);
    }

    @Step("Нажатие на кнопку смены языка")
    public void clickLanguageButton() {
        searchElement(languageButton);
        click(languageButton);
    }

    @Step("Выбрать в меню En")
    public void clickEngLanguage() {
        searchElement(enLang);
        click(enLang);
    }

    @Step("Выбрать в меню Ru")
    public void clickRuLanguage() {
        searchElement(ruLang);
        click(ruLang);
    }

    @Step("Проверка что сейчас русский язык")
    public void assertTrueRuLang() {
        searchElement(ruAuthorize);
    }

    @Step("Проверка что сейчас английский язык")
    public void checkEngLang() {
        searchElement(enAuthorize);
    }

    @Step("Нажать элемент Забыли пароль?")
    public void clickForgotPassword() {
        searchElement(forgotPassword);
        click(forgotPassword);
    }

    @Step("Кликнуть на строку ввода email")
    public void clickInputEmail() {
        searchElement(lineInputEmail);
        click(lineInputEmail);
    }

    @Step("Ввести email")
    public void sendEmail() {
        sendInLine(lineInputEmail, email);
    }

    @Step("Нажать на кнопку восстановить пароль")
    public void clickRecoverPassword() {
        searchElement(recoverPasswordButton);
        click(recoverPasswordButton);
    }
}
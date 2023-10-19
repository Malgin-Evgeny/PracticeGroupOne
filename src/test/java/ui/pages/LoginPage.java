package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.TestBase;

import static com.codeborne.selenide.Selenide.*;

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
    private final SelenideElement ruAuthorize = $x("//*[contains(text(), 'Авторизация')]");
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
        findLanguageButton();
        clickLanguageButton();
        findEngLanguage();
        clickEngLanguage();
        checkEngLang();
        findLanguageButton();
        clickLanguageButton();
        findRuLanguage();
        clickRuLanguage();
        checkRuLang();
    }

    @Step("Метод восстановить пароль")
    public void recoverPassword() {
        searchElement(forgotPassword);
        clickForgotPassword();
        searchElement(lineInputEmail);
        clickInputEmail();
        sendEmail();
        findToRecoverPassword();
        clickRecoverPassword();
    }

    @Step("Проверка видимости кнопки смены цвета темы сайта")
    public void findWhiteColorButton() {
        searchElement(whiteButton);
    }

    @Step("Проверка видимости кнопки смены цвета темы сайта")
    public void findBlackColorButton() {
        searchElement(blackButton);
    }

    @Step("Сменить цвет")
    public void clickWhiteColorButton() {
        click(whiteButton);
    }

    @Step("Сменить цвет")
    public void clickBlackColorButton() {
        click(blackButton);
    }

    @Step("Поиск светлого цвета темы окна логина")
    public void findChangeBlackToWhiteColor() {
        searchElement(whiteColor);
    }

    @Step("Поиск тёмного цвета темы окна логина")
    public void findChangeWhiteToBlackColor() {
        searchElement(blackColor);
    }

    @Step("Проверка смены цвета фона страницы")
    public void assertTrueCheckColorClass() {
        searchElement(classWhite);
    }

    @Step("Поиск кнопки смены языка")
    public void findLanguageButton() {
        searchElement(languageButton);
    }

    @Step("Нажатие на кнопку смены языка")
    public void clickLanguageButton() {
        click(languageButton);
    }

    @Step("Найти елемент En")
    public void findEngLanguage() {
        searchElement(enLang);
    }

    @Step("Выбрать в меню En")
    public void clickEngLanguage() {
        click(enLang);
    }

    @Step("Найти елемент Ru")
    public void findRuLanguage() {
        searchElement(ruLang);
    }

    @Step("Выбрать в меню Ru")
    public void clickRuLanguage() {
        click(ruLang);
    }

    @Step("Проверка что сейчас русский язык")
    public void checkRuLang() {
        searchElement(ruAuthorize);
    }

    @Step("Проверка что сейчас английский язык")
    public void checkEngLang() {
        searchElement(enAuthorize);
    }

    @Step("Нажать элемент Забыли пароль?")
    public void clickForgotPassword() {
        click(forgotPassword);
    }

    @Step("Кликнуть на строку ввода email")
    public void clickInputEmail() {
        click(lineInputEmail);
    }

    @Step("Ввести email")
    public void sendEmail() {
        sendInLine(lineInputEmail, email);
    }

    @Step("Найти кнопку восстановить пароль")
    public void findToRecoverPassword() {
        searchElement(recoverPasswordButton);
    }

    @Step("Нажать на кнопку восстановить пароль")
    public void clickRecoverPassword() {
        click(recoverPasswordButton);
    }
}
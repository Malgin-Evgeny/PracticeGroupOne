package ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PageObject {
    private final SelenideElement loginInput = $x("//input[@type='text' and contains(@class, 'MuiInputBase-input')]");
    private final SelenideElement passwordInput = $x("//input[@type='password']");
    private final SelenideElement loginButton = $x("//button[contains(@class, 'MuiButton-containedPrimary') or contains(text(), 'Войти')]");
    private final SelenideElement logoutButton = $x("//*[@data-testid=\"ExitToAppIcon\"]");
    private final String login = "aqa_01";
    private final String password = "783891";
    private final SelenideElement welcome = $x("//*[@class=\"TitleBase_title-base__n1Oxe\"]");

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
}


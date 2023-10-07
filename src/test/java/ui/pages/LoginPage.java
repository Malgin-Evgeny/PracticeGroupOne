package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;
import ui.TestBase;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends TestBase {
    private final SelenideElement loginInput = $x("//*[@id=\":r0:\"]");
    private final SelenideElement passwordInput = $x("//*[@id=\":r1:\"]");
    private final SelenideElement loginButton = $x("//*[@class=\"MuiButtonBase-root MuiButton-root " +
            "MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium " +
            "MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium " +
            "MuiButton-containedSizeMedium css-y4p3a9\"]");
    private final String login = "aqa_01";
    private final String password = "783891";
    private final SelenideElement welcome = $x("//*[@class=\"TitleBase_title-base__n1Oxe\"]");
    @Step("Вход в систему")
    public void loginVoid() {
        getUrl();
        loginInput.shouldBe(Condition.visible);
        actions().moveToElement(loginInput).click().sendKeys(login).perform();
        actions().moveToElement(passwordInput).click().sendKeys(password).perform();
        actions().moveToElement(loginButton).click().perform();
    }
    @Step("Проверка Элемента")
    public void assertLoginSuccess() {
        welcome.shouldBe(Condition.visible);
        Assert.assertTrue(welcome.isDisplayed());
}}
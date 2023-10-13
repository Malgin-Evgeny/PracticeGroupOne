package ui;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestBase extends PageObject {
    public final String URL = "https://dev.learn.maxima.school/";
    private final SelenideElement loginForm = $x("//div[@class=\"LoginForm_login-form__header__Ad3b9\"]");
    @BeforeMethod
    @Step("Открыть сайт")
    public void openBrowserWithUrl() {
        open(URL);
        refresh();
        loginMethod();
        assertLoginSuccess();

    }
    @AfterMethod
    public void closedBrowser(){
        closeWebDriver();
    }
    //Перезагрузка страницы если элемент невидим
    public void refresh (){
        if (loginForm.exists()) {
            getWebDriver().manage().window().maximize();
        } else {
            Selenide.refresh();
            getWebDriver().manage().window().fullscreen();
        }
    }

    @Step("Вход в систему")
    public void loginMethod() {
        setLoginInput();
        sendLogin();
        setPasswordInput();
        sendPassword();
        setLoginButton();
    }
}


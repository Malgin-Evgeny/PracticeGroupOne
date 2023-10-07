package ui;

import ui.helpers.WebDrivers;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestBase extends WebDrivers {

    private final String URL = "https://dev.learn.maxima.school/";
    @Step("Открыть сайт")
    public void getUrl(){
        open(URL);
        getWebDriver().manage().window().maximize();
    }
}

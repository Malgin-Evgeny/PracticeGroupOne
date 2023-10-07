package ui.helpers;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDrivers {

    @BeforeMethod
    public void exampleTest() {
         Configuration.browser = Browsers.CHROME;



    }
    @AfterMethod
    public void close() {
        closeWebDriver();
    }
}
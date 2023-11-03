package ui.tests.negative;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.baseItems.Credentials;
import ui.pages.LoginPage;

import static io.qameta.allure.SeverityLevel.NORMAL;
@Epic("Проверка сайта MAXIMA")
@Feature("Проверка функицонала страниц")
public class LoginPageNegativeTest extends LoginPage {

    @Test
    @Story("Проверка логина")
    @Description("Негативный")
    @Severity(NORMAL)
    public void loginPageNegativeTest() {
        loginNegativePass(Credentials.getLoginFake(),Credentials.getPasswordFake());
    }
}

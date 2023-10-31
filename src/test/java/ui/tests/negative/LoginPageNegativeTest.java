package ui.tests.negative;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.pages.LoginPage;

import static io.qameta.allure.SeverityLevel.NORMAL;
@Epic("Проверка сайта MAXIMA")
@Feature("Проверка функицонала страниц")
public class LoginPageNegativeTest extends LoginPage {
    String loginFake = "aAqQaA_!&@#4";
    String passwordFake = "1293128487128497124";
    @Test
    @Story("Проверка логина")
    @Description("Негативный")
    @Severity(NORMAL)
    public void loginPageNegativeTest() {
        loginNegativePass(loginFake,passwordFake);
    }
}

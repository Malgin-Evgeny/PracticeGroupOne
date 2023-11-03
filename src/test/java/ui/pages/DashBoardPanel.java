package ui.pages;

import com.codeborne.selenide.SelenideElement;
import ui.baseItems.Credentials;
import ui.baseItems.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DashBoardPanel extends TestBase {
    LoginPage loginPage = new LoginPage();
    private final SelenideElement courses = $x("//*[contains(text(), 'Курсы')]");
    private final SelenideElement menuItemCourses = $x("//*[contains(text(), 'Курсы') and (@role='menuitem')]");
    private final SelenideElement users = $x("//*[contains(text(), 'Пользователи')]");
    private final SelenideElement maximaPlay = $x("//*[contains(text(), 'Maxima Play')]");
    private final SelenideElement more = $x("//*[contains(text(), 'Дополнительно')]");
    private final SelenideElement brightnessForIcon = $x("//*[@data-testid='Brightness4Icon']");
    private final SelenideElement brightnessSevenIcon = $x("//*[@data-testid='Brightness7Icon']");
    private final SelenideElement settingsIcon = $x("//*[@data-testid='SettingsIcon']");
    private final SelenideElement colorBlackCss = $(".css-17mli7j");
    private final SelenideElement colorWhiteCss = $(".css-1jbfl2o");

    public void changeColorToBlack() {
        loginPage.login(Credentials.getLogin(), Credentials.getPassword());
        click(brightnessForIcon);
        assertVisible(colorBlackCss);
        click(brightnessSevenIcon);
        assertVisible(colorWhiteCss);
    }
}

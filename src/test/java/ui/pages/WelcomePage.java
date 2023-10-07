package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class WelcomePage {
    public final SelenideElement logout = $("//*[contains(@data-testid, \"ExitToAppIcon\")]//..");

    public final SelenideElement reference = $x("//*[contains(@data-testid, \"HelpOutlineIcon\")]");
}

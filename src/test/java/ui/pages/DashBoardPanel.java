package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashBoardPanel {
    private final SelenideElement courses= $x("//*[contains(text(), 'Курсы')]");
    private final SelenideElement users = $x("//*[contains(text(), 'Пользователи')]");
    private final SelenideElement maximaPlay = $x("//*[contains(text(), 'Maxima Play')]");
    private final SelenideElement more =$x("//*[contains(text(), 'Дополнительно')]");
    private final SelenideElement brightnessForIcon=$x("//*[@data-testid='Brightness4Icon']");
    private final SelenideElement settingsIcon = $x("//*[@data-testid='SettingsIcon']");
}

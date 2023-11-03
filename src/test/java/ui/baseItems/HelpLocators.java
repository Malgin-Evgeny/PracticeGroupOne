package ui.baseItems;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;


public class HelpLocators {
    @Getter
    private static final String URLmaxima = "https://dev.learn.maxima.school/";
    @Getter
    private static final SelenideElement loginForm = $x("//div[@class=\"LoginForm_login-form__header__Ad3b9\"]");
}

package ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class PageObject {
    @Step("Ввод в строку")
    public void sendInLine(SelenideElement selenideElement, String string) {
        $(selenideElement).sendKeys(string);
    }

    @Step("Нажать на элемент c проверкой его видимости")
    public void click(SelenideElement selenideElement) {
        selenideElement.click();
    }

    @Step("Проверка видимости элемента")
    public void searchElement(SelenideElement selenideElement) {
        Assert.assertTrue(selenideElement.shouldBe(Condition.visible).isDisplayed());
    }
}
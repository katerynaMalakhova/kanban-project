package UI.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


public class LogInElements {

    private final SelenideElement userNameField = Selenide.$x("//input[@name='username']");
    private final SelenideElement passwordField = Selenide.$x("//input[@name='password']");
    private final SelenideElement logInButton = Selenide.$x("//button");
    private final SelenideElement alertParagraph = Selenide.$x("//p[contains(@class, 'alert')]");

    public SelenideElement getUserNameField() {
        return userNameField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public SelenideElement getLogInButton() {
        return logInButton;
    }

    public SelenideElement getAlertParagraph() {
        return alertParagraph;
    }
}
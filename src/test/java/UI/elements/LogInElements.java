package UI.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


public class LogInPage{

    private final SelenideElement userNameField = Selenide.$x("//input[@name='username']");
    private final SelenideElement passwordField = Selenide.$x("//input[@name='password']");
    private final SelenideElement logInButton = Selenide.$x("//button");
    private final SelenideElement alertParagraph = Selenide.$x("//p[contains(@class, 'alert')]");


    @Step("The user logs in with credentials [{0}, {1}]")
    public void logIn(String userName, String password) {
        getUserNameField().shouldBe(Condition.visible).sendKeys(userName);
        getPasswordField().shouldBe(Condition.visible).sendKeys(password);
        getLogInButton().shouldBe(Condition.visible).click();
    }

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
package UI.steps;

import UI.elements.LogInElements;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;


public class LogInPage extends LogInElements {

    @Step("The user logs in with credentials [{0}, {1}]")
    public void logIn(String userName, String password) {
        getUserNameField().shouldBe(Condition.visible).sendKeys(userName);
        getPasswordField().shouldBe(Condition.visible).sendKeys(password);
        getLogInButton().shouldBe(Condition.visible).click();
    }

}
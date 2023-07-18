package UI;

import UI.tests.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import UI.steps.LogInPage;

public class LogInTest extends BaseTest {

    private final static String ADMIN_NAME = "admin";
    private final static String ADMIN_PASS = "admin";

//    private final static String ADMIN_PASS = "rdaqa2023#p";

    private final static String EXPECTED_DASHBOARD_URL = "http://localhost/dashboard";

    @Test
    @Description("The test is checking positive case for login")
    public void testLogInToAccount() {
        new LogInPage()
                .logIn(ADMIN_NAME, ADMIN_PASS);

        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), EXPECTED_DASHBOARD_URL,
                "The logIn was not successful");
    }
    @Test
    @Description("The test is checking login with wrong password")
    public void testLogInToAccountWithWrongPassword() {
        LogInPage loginPage = new LogInPage();
                loginPage.logIn(ADMIN_NAME, "wrongPassword");

        Assert.assertEquals(loginPage.getAlertParagraph().shouldBe(Condition.visible).getText(), "Bad username or password",
                "The password validation is not successful"); //update text
    }

    @Test
    @Description("The test is checking login with wrong username")
    public void testLogInToAccountWithWrongUsername() {
        LogInPage loginPage = new LogInPage();
        loginPage.logIn("wrongUsername", ADMIN_PASS);

        Assert.assertEquals(loginPage.getAlertParagraph().shouldBe(Condition.visible).getText(), "Bad username or password",
                "The username validation is not successful"); //update text
    }

}

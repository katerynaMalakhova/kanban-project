package UI.tests;

import UI.steps.DashboardPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import UI.steps.LogInPage;

import static utils.EnvProperties.*;

public class LogInTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        Configuration.browser = BROWSER;
        Configuration.headless = Boolean.parseBoolean(HEADLESS);
        Selenide.open(BASE_URL);
    }

    @Test
    @Description("The test is checking positive case for login")
    public void testLogInToAccount() {
        new LogInPage()
                .logIn(ADMIN_USERNAME, ADMIN_PASSWORD);

        Assert.assertEquals(new DashboardPage().getDashboardTitle().getText(),
                "Dashboard for admin", "No redirect to dashboard");
  }

    @Test
    @Description("The test is checking login with wrong password")
    public void testLogInToAccountWithWrongPassword() {
        LogInPage loginPage = new LogInPage();
        loginPage.logIn(ADMIN_USERNAME, "wrongPassword");

        Assert.assertEquals(loginPage.getAlertParagraph().shouldBe(Condition.visible).getText(), "Bad username or password",
                "The password validation is not successful"); //update text
    }

    @Test
    @Description("The test is checking login with wrong username")
    public void testLogInToAccountWithWrongUsername() {
        LogInPage loginPage = new LogInPage();
        loginPage.logIn("wrongUsername", ADMIN_PASSWORD);

        Assert.assertEquals(loginPage.getAlertParagraph().shouldBe(Condition.visible).getText(), "Bad username or password",
                "The username validation is not successful"); //update text
    }

}

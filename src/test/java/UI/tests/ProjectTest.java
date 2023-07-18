package UI.tests;

import UI.steps.DashboardPage;
import UI.steps.LogInPage;
import UI.steps.ProjectPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import static utils.EnvProperties.*;

public class CreateProjectTest extends BaseTest {
    private final static String PROJECT_NAME = String.format("projectName-%d", Math.random());
    private final static String PROJECT_ID = String.format("new7%d", Math.random());
    private final static int PROJECT_LIMIT = 6;

    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
        Selenide.open(BASE_URL);
        new LogInPage().logIn(ADMIN_USERNAME, ADMIN_PASSWORD);
    }

    @Test
    @Description("The test is checking creating project")
    public void testCreateProject() {
        new DashboardPage().createProject(PROJECT_NAME, PROJECT_ID, PROJECT_LIMIT);

        //check on DB or by API
        Assert.assertTrue(new ProjectPage()
                        .getProjectTitle()
                        .shouldBe(Condition.visible)
                        .getText().contains(PROJECT_NAME),
                "Wrong title on the project page");
    }

}

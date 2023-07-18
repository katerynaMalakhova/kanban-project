package UI.tests;

import UI.steps.DashboardPage;
import UI.steps.LogInPage;
import UI.steps.ProjectPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static utils.EnvProperties.*;

public class ProjectTest extends BaseTest {
    @BeforeMethod
    public void setUp() {
        Configuration.browser = BROWSER;
        Configuration.headless = Boolean.parseBoolean(HEADLESS);
        Selenide.open(BASE_URL);
        new LogInPage().logIn(ADMIN_USERNAME, ADMIN_PASSWORD);
    }

    @Test
    @Description("The test is checking creating project")
    public void testCreateProject() {
        new DashboardPage().createProject(PROJECT_NAME, PROJECT_ID, PROJECT_LIMIT);

        Assert.assertEquals(new ProjectPage()
                        .getProjectTitle()
                        .shouldBe(Condition.visible)
                        .getText(), PROJECT_NAME,
                "Wrong title on the project page");
    }

}

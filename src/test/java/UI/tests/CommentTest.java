package UI.tests;

import DB.models.Task;
import UI.steps.DashboardPage;
import UI.steps.LogInPage;
import UI.steps.ProjectPage;
import api.enums.UserRoles;
import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.List;

import static utils.EnvProperties.BASE_URL;

public class AddCommentTest extends BaseTest {

    private String USER_ID;
    private String PROJECT_ID;
    private final static String USER_NAME = "user" + Math.random();
    private final static String USER_PASSWORD = "password";
    private final static String PROJECT_NAME = "project" + Math.random();
    private final static Task TASK = new Task("ProjectName", "Description", "admin", "2", "12/12/2023", "01/12/2023", 20, 30, 3);

    @BeforeMethod
    public void setUp() {
        //create user
        UserApiSteps userApiSteps = new UserApiSteps();
        USER_ID = userApiSteps.createUser(USER_NAME, USER_PASSWORD, UserRoles.USER.getRole());

        //create project
        ProjectApiSteps projectApiSteps = new ProjectApiSteps();
        PROJECT_ID = projectApiSteps.createProject(PROJECT_NAME);

        //link user and project
        projectApiSteps.addUserToProject(PROJECT_ID, USER_ID, UserRoles.USER.getRole());

        Configuration.browser = "chrome";
        Selenide.open(BASE_URL);
        new LogInPage().logIn(USER_NAME, USER_PASSWORD);
        new DashboardPage().openProject(PROJECT_ID);
    }

    @Test
    @Description("The test is checking task creation ")
    public void testCreateTask() throws ParseException {
        ProjectPage projectPage = new ProjectPage();
        Assert.assertEquals(projectPage.getProjectTitle().shouldBe(Condition.visible).getText(), PROJECT_NAME);
        List<Task> tasks = projectPage
                .createTask(TASK)
                .getTasks();
        Assert.assertTrue(tasks.contains(TASK),
                "Cannot find created task on the board");
    }

    @AfterMethod
    public void cleanUp() {
        //delete user and project link
        ProjectApiSteps projectApiSteps = new ProjectApiSteps();
        projectApiSteps.deleteUserToProjectLink(PROJECT_ID, USER_ID);

        //delete project
        projectApiSteps.deleteProject(PROJECT_ID);

        //delete user
        new UserApiSteps().deleteUser(USER_ID);
    }

}

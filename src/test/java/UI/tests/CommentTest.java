package UI.tests;

import UI.steps.DashboardPage;
import UI.steps.LogInPage;
import UI.steps.ProjectPage;
import UI.steps.TaskPage;
import api.enums.UserRoles;
import api.steps.ProjectApiSteps;
import api.steps.TaskApiSteps;
import api.steps.UserApiSteps;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static utils.EnvProperties.*;

public class CommentTest extends BaseTest {

    private String USER_ID;
    private String PROJECT_ID;
    private String TASK_ID;
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

        //create task
        TaskApiSteps taskApiSteps = new TaskApiSteps();
        TASK_ID = taskApiSteps.createTask(TASK_TITLE, PROJECT_ID);

        Configuration.browser = BROWSER;
        Configuration.headless = Boolean.parseBoolean(HEADLESS);
        Selenide.open(BASE_URL);
        new LogInPage().logIn(USER_NAME, USER_PASSWORD);
        new DashboardPage().openProject(PROJECT_ID);
        new ProjectPage().openTask(TASK_ID);
    }

    @Test
    @Description("The test is checking task creation ")
    public void addCommentTask() {
        TaskPage taskPage = new TaskPage();
        Assert.assertEquals(taskPage.getTaskTitle().shouldBe(Condition.visible).getText(), TASK_TITLE,
                "Task detail page is not opened");
        taskPage.addComment(COMMENT_TEXT);
        Assert.assertTrue(taskPage
                .getComments()
                .contains(COMMENT),"Message is not displayed");
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

package UI.tests;

import DB.models.Task;
import UI.steps.*;
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

import java.text.ParseException;
import java.util.List;

import static utils.EnvProperties.*;

public class TaskTest extends BaseTest {

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
        TASK_ID = taskApiSteps.createTask(TASK_TITLE, PROJECT_ID, USER_ID);


        Configuration.browser = BROWSER;
        Configuration.headless = Boolean.parseBoolean(HEADLESS);
        Selenide.open(BASE_URL);
        new LogInPage().logIn(USER_NAME, USER_PASSWORD);
        new DashboardPage().openProject(PROJECT_ID);
//        new ProjectPage().openTask(TASK_ID);
    }

    @Test
    @Description("The test is checking task creation")
    public void testCreateTask() throws ParseException {
        ProjectPage projectPage = new ProjectPage();
        Assert.assertEquals(projectPage.getProjectTitle().shouldBe(Condition.visible).getText(), PROJECT_NAME);
        List<Task> tasks = projectPage
                .createTask(TASK)
                .getTasks();
        Assert.assertTrue(tasks
                        .contains(TASK),
                "Cannot find created task on the board");
    }

    @Test
    @Description("The test is checking task closing")
    public void testClosingTask() {
        new ProjectPage().openTask(TASK_ID);
        TaskPage taskPage = new TaskPage();
        Assert.assertEquals(taskPage.getTaskTitle().shouldBe(Condition.visible).getText(), TASK_TITLE,
                "Task detail page is not opened");
        taskPage.closeTask(TASK_ID);
        Assert.assertEquals(taskPage.getTaskStatus().shouldBe(Condition.visible).getText(), "closed", "Task status is not set to close");
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
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

    private final static String USER_NAME = "user" + Math.random();
    private final static String USER_PASSWORD = "password";
    private final static String PROJECT_NAME = "project" + Math.random();
    private final static int PROJECT_LIMIT = 6;
    private final static String TASK_TITLE = "task" + Math.random();
    private final static Task TASK = new Task("ProjectName", "Description", "admin", "5", "12/12/2023", "01/12/2023", 20, 30, 10);

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

        Configuration.browser = "chrome";
        Selenide.open(BASE_URL);
        new LogInPage().logIn(USER_NAME, USER_PASSWORD);
        new DashboardPage().openProject(PROJECT_ID);
        new ProjectPage().openTask(TASK_ID);
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
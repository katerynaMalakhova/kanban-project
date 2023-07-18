package api.tests;

import api.steps.ProjectApiSteps;
import api.steps.TaskApiSteps;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TaskApiTests {
    private final static String PROJECT_NAME = "newProject"+Math.random();
    private final static String TASK_TITLE = "title"+Math.random();
    private String PROJECT_ID;
    @BeforeSuite
    public void setup(){
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    PROJECT_ID = projectApiSteps.createProject(PROJECT_NAME);
    }

    @Test
    public void createProjectByAdminTest() {
        TaskApiSteps taskApiSteps = new TaskApiSteps();
        String response = taskApiSteps.createTask(TASK_TITLE, PROJECT_ID);
        Assert.assertTrue(response!="false", "No task id in response");
        System.out.println(taskApiSteps.getTask(response));
    }

    @Test
    public void deleteProjectByAdminTest() {
        TaskApiSteps taskApiSteps = new TaskApiSteps();
        String taskId = taskApiSteps.createTask(TASK_TITLE, PROJECT_ID);
        Boolean response = taskApiSteps.deleteTask(taskId);
        Assert.assertTrue(response, "Problems during task deleting occur");
    }

    @AfterSuite
    public void cleanup(){
        ProjectApiSteps projectApiSteps = new ProjectApiSteps();
        projectApiSteps.deleteProject(PROJECT_ID);
    }
}

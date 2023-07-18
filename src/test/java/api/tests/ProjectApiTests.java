package api.tests;

import api.enums.UserRoles;
import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectApiTests {
    private final static String USER_NAME = "user"+Math.random();
    private final static String USER_PASSWORD = "password";
    private final static String PROJECT_NAME = "project"+Math.random();

    @Test
    public void createProjectByAdminTest() {
        ProjectApiSteps projectApiSteps = new ProjectApiSteps();
        String response = projectApiSteps.createProject(PROJECT_NAME);
        Assert.assertTrue(response!="false", "No project id in response");
        System.out.println(projectApiSteps.getProjectById(response));

    }

    @Test
    public void deleteProjectByAdminTest() {
        Boolean response;
        ProjectApiSteps projectApiSteps = new ProjectApiSteps();
        String projectId = projectApiSteps.createProject(PROJECT_NAME);// to delete user, user need to be created first
        response = projectApiSteps.deleteProject(projectId);
        Assert.assertTrue(response, "Problems during project deleting occur");
    }
//
//    @Test
//    public void createProjectByManagerTest() {
//        UserApiSteps userApiSteps = new UserApiSteps();
//        int ownerId = Integer.valueOf(userApiSteps.createUser(USER_NAME, USER_PASSWORD, UserRoles.MANAGER.getRole()));
//
//        ProjectApiSteps projectApiSteps = new ProjectApiSteps();
//        String response = projectApiSteps.createProject(PROJECT_NAME, ownerId, USER_NAME, USER_PASSWORD);
//        Assert.assertTrue(response!="false", "No project id in response");
//        System.out.println(projectApiSteps.getProjectById(response));
//
//    }


//    @Test
//    public void deleteProjectByManagerTest() {
//        Boolean response;
//        UserApiSteps userApiSteps = new UserApiSteps();
//        int ownerId = Integer.valueOf(userApiSteps.createUser(USER_NAME, USER_PASSWORD, UserRoles.MANAGER.getRole()));
//
//        ProjectApiSteps projectApiSteps = new ProjectApiSteps();
//        String projectId = projectApiSteps.createProject(PROJECT_NAME, ownerId, USER_NAME, USER_PASS);
//        response = projectApiSteps.deleteProject(projectId);
//        Assert.assertTrue(response, "Problems during user deleting occur");
//    }
}

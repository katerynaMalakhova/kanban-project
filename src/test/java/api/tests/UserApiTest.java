package api.tests;

import api.enums.UserRoles;
import api.steps.UserApiSteps;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserApiTest {
    private final static String USER_NAME = "user"+Math.random();
    private final static String USER_PASSWORD = "password";

    @Test
    public void createUserTest() {
        UserApiSteps userApiSteps = new UserApiSteps();
        String response = userApiSteps.createUser(USER_NAME, USER_PASSWORD, UserRoles.USER.getRole());
        Assert.assertTrue(response!="false", "No user id in response");
        System.out.println(response);
        userApiSteps.deleteUser(response);
 }

    @Test
    public void deleteUserTest() {
        Boolean response;
        UserApiSteps userApiSteps = new UserApiSteps();
        String userId = userApiSteps.createUser(USER_NAME, USER_PASSWORD, UserRoles.USER.getRole());// to delete user, user need to be created first
        response = userApiSteps.deleteUser(userId);
        Assert.assertTrue(response, "Problems during user deleting occur");
    }


}

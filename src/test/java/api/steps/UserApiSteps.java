package api.steps;


import io.restassured.response.Response;
import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.users.CreateUser;
import api.models.args.users.UserId;

import static api.methods.Users.*;

public class UserApiSteps extends BaseApiSteps {
    public String createUser(String username, String pass, String role) {
        CreateUser args = CreateUser.builder()
                .username(username)
                .name(username)
                .password(pass)
                .email(username + "@mail.com")
                .role(role)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().params(args)
                .method(CREATE_USER)
                .build();

        Response response = postRequest(bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }

    public boolean deleteUser(String userId) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new UserId(Integer.valueOf(userId)))
                .method(DELETE_USER)
                .build();

        Response response = postRequest(bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }

    public String getUser(String userId) {
        BodyArgs bodyArgs = BodyArgs.builder().
                params(new UserId(Integer.valueOf(userId)))
                .method(GET_USER)
                .build();

        Response response = postRequest(bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }

}
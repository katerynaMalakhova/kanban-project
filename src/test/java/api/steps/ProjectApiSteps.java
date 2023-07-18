package api.steps;

import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.projects.AddProductToProject;
import api.models.args.projects.CreateProject;
import api.models.args.projects.ProjectId;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static api.methods.Projects.*;

public class ProjectApiSteps extends BaseApiSteps {
    public String createProject(String name) {
            CreateProject args = CreateProject.builder()
                    .name(name)
                    .description(name+" description")
                    .owner_id(1)
//                    .start_date(DateTime.now().toString("dd/MM/yyyy hh:mm"))
                    .build();

            BodyArgs bodyArgs = BodyArgs.builder().params(args)
                    .method(CREATE_PROJECT)
                    .build();

            Response response = postRequest(bodyArgs);
            response.then().statusCode(200);
            Result result = response.as(Result.class);
            return result.getResult().toString();
        }
        public boolean deleteProject(String projectId) {

            BodyArgs bodyArgs = BodyArgs.builder().
                    params(new ProjectId(Integer.valueOf(projectId)))
                    .method(DELETE_PROJECT)
                    .build();

            Response response = postRequest(bodyArgs);
            return (boolean) response.as(Result.class).getResult();
        }
        public String getProjectById(String projectId) {
            BodyArgs bodyArgs = BodyArgs.builder().
                    params(new ProjectId(Integer.valueOf(projectId)))
                    .method(GET_PROJECT_BY_ID)
                    .build();

            Response response = postRequest(bodyArgs);
            response.then().statusCode(200);
            Result result = response.as(Result.class);
            return result.getResult().toString();
        }
    public boolean addUserToProject(String projectId, String userId, String role) {

        List<String> args = new ArrayList<>();
        args.add(projectId);
        args.add(userId);
        args.add(role);
        BodyArgs bodyArgs = BodyArgs.builder()
                .params(args)
                .method(ADD_USER_TO_PROJECT)
                .build();

        Response response = postRequest(bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }

    public boolean deleteUserToProjectLink(String projectId, String userId) {
        List<String> args = new ArrayList<>();
        args.add(projectId);
        args.add(userId);
        BodyArgs bodyArgs = BodyArgs.builder()
                .params(args)
                .method(DELETE_USER_TO_PROJECT_lINK)
                .build();

        Response response = postRequest(bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }

    public String createProject(String name, int ownerId, String ownerName, String ownerPassword) {
        CreateProject args = CreateProject.builder()
                .name(name)
                .description(name+" description")
                .owner_id(ownerId)
                //.start_date(DateTime.now().toString("dd/MM/yyyy hh:mm"))
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().params(args)
                .method(CREATE_PROJECT)
                .build();

        Response response = postRequest(bodyArgs, ownerName, ownerPassword);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }
//    public boolean deleteProject(String projectId, String ownerName, String ownerPassword) {
//
//        BodyArgs bodyArgs = BodyArgs.builder().
//                params(new ProjectId(Integer.valueOf(projectId)))
//                //params(projectId)
//                .method(DELETE_PROJECT)
//                .build();
//
//        Response response = postRequest(bodyArgs, ownerName, ownerPassword);
//        return (boolean) response.as(Result.class).getResult();
//    }
}

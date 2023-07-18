package api.steps;

import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.tasks.CreateTask;
import api.models.args.tasks.TaskId;
import io.restassured.response.Response;

import static api.methods.Tasks.*;

public class TaskApiSteps extends BaseApiSteps{

    public String createTask(String taskTitle, String projectId, String ownerId) {
        CreateTask args = CreateTask.builder()
                .title(taskTitle)
                .project_id(projectId)
                .owner_id(ownerId)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().params(args)
                .method(CREATE_TASK)
                .build();

        Response response = postRequest(bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }
    public String createTask(String taskTitle, String projectId) {
        CreateTask args = CreateTask.builder()
                .title(taskTitle)
                .project_id(projectId)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().params(args)
                .method(CREATE_TASK)
                .build();

        Response response = postRequest(bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }
    public boolean deleteTask(String taskId) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new TaskId(Integer.valueOf(taskId)))
                .method(DELETE_TASK)
                .build();

        Response response = postRequest(bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }
    public String getTask(String taskId) {
        BodyArgs bodyArgs = BodyArgs.builder().
                params(new TaskId(Integer.valueOf(taskId)))
                .method(GET_TASK)
                .build();

        Response response = postRequest(bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }
}

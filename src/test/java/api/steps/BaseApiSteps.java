package api.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import api.models.args.BodyArgs;

import static utils.EnvProperties.*;


public class BaseApiSteps {
    public Response postRequest( BodyArgs bodyArgs) {
        return RestAssured.given()
                .auth().basic(ADMIN_USERNAME, ADMIN_PASSWORD)
                .body(bodyArgs).log().all()
                .when()
                .post(API_URL);
    }
    public Response postRequest( BodyArgs bodyArgs, String username, String password) {
        return RestAssured.given()
                .auth().basic(username, password)
                .body(bodyArgs).log().all()
                .when()
                .post(API_URL);
    }
}
package adapters;

import com.google.gson.Gson;
import dto.APIResponse;
import dto.Project;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ProjectAPI {
    RequestSpecification requestSpecification;
    public ProjectAPI() {
        requestSpecification =
                given().
                        header("Token", "5c743659ad1dcbe6dfed64efedba6379b083bc9a").
                        header("Content-Type","application/json");


    }
    public void create(String body) {
        create(body, 200);
    }
    public ValidatableResponse create(String body, int statusCode) {
        return
                requestSpecification.
                        body(body).

                when().
                post("https://api.qase.io/v1/project").
                then().
                log().all().
                statusCode(statusCode);

    }

    public APIResponse getProjectByCode(String code) {
        Gson gson = new Gson();
        return
                requestSpecification.
        when().
        get("https://api.qase.io/v1/project/" + code).
            then().
            log().all().
            statusCode(200).
            extract().as(APIResponse.class);
        //return gson.fromJson(project, Project.class);




    }

    }

package API;

import adapters.ProjectAPI;
import com.google.gson.Gson;
import dto.Project;
import io.ous.jtoml.impl.Token;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ProjectAPITest {
    ProjectAPI  projectAPI;
    @Test
    public void createProject() {
        projectAPI = new ProjectAPI();
        projectAPI.create("{\n" +
                "        \"title\": \"APIProject\",\n" +
                "     \"code\": \"API\",\n" +
                "     \"description\": \"blabla\",\n" +
                "     \"access\": \"all\"\n" +
                "}\n" +
                "}");
    }

    @Test
    public void createProjectOnlyRequiredFields() {
        //TODO generate unique code

        projectAPI = new ProjectAPI();
        Gson gson = new Gson();
        Project project = Project.builder().
                tittle("APIProject").
                code("API").
                build();


        projectAPI.create(gson.toJson(project));

    }
    @Test
    public void createProject400NoTitle() {
        //TODO generate unique code
        projectAPI = new ProjectAPI();
        projectAPI.create("\n" +
                "     \"code\": \"API2\"\n" +
                        "}", 400)
                .body("status", equalTo(true));

    }
    @Test
    public void getProject() {
        projectAPI = new ProjectAPI();
        System.out.println(projectAPI.getProjectByCode("API"));    }
}
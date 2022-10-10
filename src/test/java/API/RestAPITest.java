package API;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class RestAPITest {
    @Test
    public void blabla() {
        when().
                get("https://r.onliner.by/sdapi/kurs/api/bestrate?currency=USD&type=NBRB").
        then().
                log().all().
                statusCode(200);
    }

}

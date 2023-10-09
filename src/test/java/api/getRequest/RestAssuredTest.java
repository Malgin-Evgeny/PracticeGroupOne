package api.getRequest;

import api.TestBase;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RestAssuredTest extends TestBase {
    @Test
    public void getSmsCallbackTest(){
        given().
                baseUri(URL)
                .when()
                .get("/sms/callback")
                .then().assertThat().statusCode(200);
    }
}

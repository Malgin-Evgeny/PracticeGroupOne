package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import static io.restassured.RestAssured.given;

public class MyToken extends TestBase {
    @Test
    public static void getToken() {
        Register register = new Register("aqa_01","783891");
        Response response = given()
                .contentType(ContentType.JSON)
                .body(register)
                .when()
                .post(URL + "/auth/login")
                .then().log().all()
                .extract()
                .response();

        SuccessReg successReg = response.as(SuccessReg.class);
        String token = successReg.getAccessToken().getToken();

        System.out.printf(token);
    }
}
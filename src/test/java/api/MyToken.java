package api;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MyToken extends TestBase {
    @Test
    public static void getToken() {
        Register register = new Register("aqa_01","783891");
        given()
                .contentType(ContentType.JSON)
                .body(register)
                .when()
                .post(URL + "/auth/login")
                .then().log().all();
    }
}
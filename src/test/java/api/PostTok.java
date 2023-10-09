package api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostTok extends TestBase{
@Test
    public void postTokenForTest() {
    Register user = new Register("aqa_01","783891");
    SuccessReg successReg = given()
            .body(user)
            .when()
            .post(URL+"/auth/login")
            .then().log().all()
            .extract().as(SuccessReg.class);
        System.out.printf(successReg.getToken(),successReg.getExpiredAt());
    }
}

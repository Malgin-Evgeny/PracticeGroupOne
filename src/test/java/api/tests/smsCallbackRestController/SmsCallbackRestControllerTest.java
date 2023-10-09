package api.tests.smsCallbackRestController;

import api.testBase.token.MyToken;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SmsCallbackRestControllerTest extends MyToken {
    @Test
    public void getSmsCallbackTest() {
        given().header(getHeader())
                .when()
                .get(URL+"/sms/callback")
                .then()
                .assertThat()
                .statusCode(200)
                .body(equalTo("100"));
    }

    @Test
    public void postSmsCallbackTest() {
        given().header(getHeader())
                .when()
                .post(URL+"/sms/callback")
                .then()
                .assertThat()
                .statusCode(200)
                .body(equalTo("100"));


    }
}

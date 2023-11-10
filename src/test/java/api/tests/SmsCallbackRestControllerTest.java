package api.tests;

import api.testBase.BaseMethod;
import org.testng.annotations.Test;

import static api.helper.Specifications.installSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SmsCallbackRestControllerTest extends BaseMethod {
    @Test
    public void getSmsCallbackTest() {
        installSpec(URL,200);
        given().header(getHeader())
                .when()
                .get("/sms/callback")
                .then().log().all()
                .assertThat().body(equalTo("100"));
    }

    @Test
    public void postSmsCallbackTest() {
        installSpec(URL,200);
        given().header(getHeader())
                .when()
                .post("/sms/callback")
                .then().log().all()
                .assertThat()
                .body(equalTo("100"));
    }
}
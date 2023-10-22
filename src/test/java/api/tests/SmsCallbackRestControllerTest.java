package api.tests;

import api.helper.Specifications;
import api.testBase.token.MyToken;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SmsCallbackRestControllerTest extends MyToken {
    @Test
    public void getSmsCallbackTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(200));
        given().header(getHeader())
                .when()
                .get("/sms/callback")
                .then().log().all()
                .assertThat()
                .body(equalTo("100"));
    }

    @Test
    public void postSmsCallbackTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(200));
        given().header(getHeader())
                .when()
                .post("/sms/callback")
                .then().log().all()
                .assertThat()
                .body(equalTo("100"));
    }
}

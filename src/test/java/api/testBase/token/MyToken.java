package api.testBase.token;

import io.restassured.http.Header;
import io.restassured.response.Response;

import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

public class MyToken {
    public static String URL = "https://backend.dev.learn.maxima.school";
    private String token;
    private String refreshToken;

    private void getToken() {
        Register register = new Register("aqa_01", "783891");
        Response response = given()
                .baseUri(URL)
                .contentType("application/json")
                .body(register)
                .when()
                .post("/auth/login")
                .then().statusCode(200)
                .extract()
                .response();
        SuccessReg successReg = response.as(SuccessReg.class);
        token = successReg.getAccessToken().getToken();
        refreshToken = successReg.getRefreshToken().getToken();
    }

    public void getValidateToken() {
        getToken();
        given()
                .header(getHeader())
                .post(URL + "/auth/validate?token="+token)
                .then().statusCode(200);
    }

    private void getRefreshToken() {
        getToken();
        given()
                .header(getHeader())
                .when()
                .post(URL + "/auth/refresh?refresh-token="+refreshToken)
                .then().statusCode(200);
    }

    public Header getHeader() {
        return new Header("Authorization", "Bearer " + token);
    }

    @BeforeMethod()
    public void setUp() {
        getToken();
        getRefreshToken();
        getValidateToken();
    }
}
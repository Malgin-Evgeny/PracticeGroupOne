package api.testBase.token;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import io.restassured.http.Header;

import static io.restassured.RestAssured.given;

public class MyToken  {
    public static String URL = "https://backend.dev.learn.maxima.school";
    private static String token;

    private static String getAuthorizationHeader() {
        if (token == null) {
            getToken();
        }
        return "Bearer " + token;
    }

    public static Header getHeader() {
        return new Header("Authorization", getAuthorizationHeader());
    }

    private static void getToken() {
        Register register = new Register("aqa_01", "783891");
        Response response = given()
                .contentType(ContentType.JSON)
                .body(register)
                .when()
                .post(URL+"/auth/login")
                .then()
                .extract()
                .response();
        SuccessReg successReg = response.as(SuccessReg.class);
        token = successReg.getAccessToken().getToken();
    }

    @BeforeClass
    public void setUp() {
        getToken();
    }
}
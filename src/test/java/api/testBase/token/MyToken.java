package api.testBase.token;

import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;
import static api.testBase.Specifications.*;

public class MyToken {
    public static String URL = "https://backend.dev.learn.maxima.school";
    private static String token;

    private static void getToken() {
        Register register = new Register("aqa_01", "783891");
        Response response = given()
                .spec(requestSpec(URL))
                .body(register)
                .when()
                .post("/auth/login")
                .then()
                .spec(responseSpecOK200())
                .extract()
                .response();
        SuccessReg successReg = response.as(SuccessReg.class);
        token = successReg.getAccessToken().getToken();
    }

    public static Header getHeader() {
        return new Header("Authorization", "Bearer " + token);
    }

    @BeforeMethod
    public void setUp() {
        installSpecification(requestSpec(URL));
        getToken();
    }
}
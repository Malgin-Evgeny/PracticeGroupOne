package api.tests;

import api.testBase.token.MyToken;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static api.testBase.inBodyClasses.ArchiveBody.getRequestArchiveBody;
import static api.testBase.inBodyClasses.ChangeUserVoidClass.getRequestBody;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersRestControllerTest extends MyToken {

    @Test
    public void getUsersRestControllerTest() {
        given().header(getHeader())
                .get(URL + "/users")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void putUserChangeTest() {
        given()
                .header(getHeader())
                .body(getRequestBody())
                .header("Content-Type", "application/json")
                .put(URL + "/users")
                .then()
                .statusCode(200);

        given()
                .header(getHeader())
                .when()
                .get(URL + "/users/315")
                .then()
                .statusCode(200)
                .body("id", equalTo(315))
                .body("firstName", equalTo("Петр"));
    }

    @Test
    public void putUserResetPasswordTest() {
        given().header(getHeader())
                .put(URL + "/users/315/reset-password")
                .then()
                .assertThat()
                .statusCode(200)
                .body("$", hasKey("login"))
                .body("$", hasKey("password"))
                .body("login", Matchers.not(emptyString()))
                .body("password", Matchers.not(emptyString()));
    }

    @Test
    public void postUserUnbanTest() {
        given()
                .header(getHeader())
                .post(URL + "/users/315/unban")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void postUserBanTest() {
        given()
                .header(getHeader())
                .post(URL + "/users/315/ban")
                .then()
                .statusCode(200);
    }

    @Test
    public void postUserArchiveTest() {
        given()
                .header(getHeader())
                .body(getRequestArchiveBody())
                .header("Content-Type", "application/json")
                .post(URL + "/users/315/archive")
                .then()
                .statusCode(200);
    }
    @Test
    public void postUserChangeActiveTest() {
        given()
                .header(getHeader())
                .body("{\n" +
                        "  \"ids\": [\n" +
                        "    1,\n" +
                        "    2,\n" +
                        "    3\n" +
                        "  ]\n" +
                        "}")
                .header("Content-Type", "application/json")
                .post(URL + "/users/change-active")
                .then().assertThat().statusCode(200);

    }
    @Test
    public void getInfoForUserID() {
        given()
                .header(getHeader())
                .get(URL + "/users/315")
                .then()
                .statusCode(200)
                .body("id", equalTo(315))
                .body("firstName", equalTo("Петр"))
                .log().all();
    }

}
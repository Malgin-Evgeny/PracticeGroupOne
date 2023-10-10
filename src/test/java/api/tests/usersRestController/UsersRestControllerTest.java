package api.tests.usersRestController;

import api.testBase.token.MyToken;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static api.testBase.changeUserPackage.ChangeUserVoidClass.getRequestBody;
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
                .body("firstName",equalTo("Петр"));
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
                .body("password", Matchers.not(emptyString()))
                .log().all();
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
}

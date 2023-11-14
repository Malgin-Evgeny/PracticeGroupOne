package api.tests;

import api.testBase.BaseMethod;
import api.testBase.inBodyClasses.ArchiveBody;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static api.helper.Specifications.installSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersRestControllerTest extends BaseMethod {
    ArchiveBody archiveBody = new ArchiveBody();

    @Test
    public void getUsersRestControllerTest() {
        specGivenHeaderGetThenAssert200(URL,200,"/users");
    }

    @Test
    public void putUserResetPasswordTest() {
        installSpec(URL,200);
        given().header(getHeader())
                .put("/users/315/reset-password")
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
        installSpec(URL,200);
        given()
                .header(getHeader())
                .post("/users/315/unban")
                .then()
                .log().all();
    }

    @Test
    public void postUserBanTest() {
        installSpec(URL,200);
        given()
                .header(getHeader())
                .post(URL + "/users/315/ban")
                .then();
    }

    @Test
    public void postUserArchiveTest() {
        installSpec(URL,200);
        given()
                .header(getHeader())
                .body(archiveBody.getRequestArchiveBody())
                .post("/users/315/archive")
                .then();
    }

    @Test
    public void getInfoForUserID() {
        installSpec(URL,200);
        given()
                .header(getHeader())
                .get("/users/315")
                .then()
                .body("id", equalTo(315))
                .body("firstName", equalTo("Петр"))
                .log().all();
    }

    @Test
    public void getSearchListAllTeachers() {
        installSpec(URL,200);
        given()
                .header(getHeader())
                .get("/users/teachers/info")
                .then()
                .log().all();
    }

    @Test
    public void getSearchForTeachersId() {
        installSpec(URL,200);
        given()
                .header(getHeader())
                .get("/users/teachers/317")
                .then()
                .body("id", equalTo(317))
                .log().all();
    }
}
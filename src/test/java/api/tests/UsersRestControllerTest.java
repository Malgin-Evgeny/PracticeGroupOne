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
        getRequest(URL,200,"/users",200);
    }

    @Test
    public void putUserResetPasswordTest() {
        putRequest(URL,200, archiveBody,"/users/315/reset-password",200);
    }

    @Test
    public void postUserUnbanTest() {
        postRequest(URL,200,archiveBody,"/users/",315,"/unban",200);
    }

    @Test
    public void postUserBanTest() {
        postRequest(URL,200,archiveBody,"/users/",315,"/ban",200);
    }

    @Test
    public void postUserArchiveTest() {
        postRequest(URL,200,archiveBody.getRequestArchiveBody(),"/users/",315,"/archive",200);
    }

    @Test
    public void getInfoForUserID() {
        getRequest(URL,200,"/users/315",200);
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
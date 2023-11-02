package api.tests;

import api.helper.Specifications;
import api.testBase.inBodyClasses.ArchiveBody;
import api.testBase.inBodyClasses.ChangeUserVoidClass;
import api.testBase.token.MyToken;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersRestControllerTest extends MyToken {
    ArchiveBody archiveBody = new ArchiveBody();
    ChangeUserVoidClass changeUserVoidClass = new ChangeUserVoidClass();

    @Test
    public void getUsersRestControllerTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(200));
        given().header(getHeader())
                .get("/users")
                .then();
    }

    @Test
    public void putUserChangeTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(200));
        given()
                .header(getHeader())
                .body(changeUserVoidClass.getRequestBody())
                .put("/users")
                .then();
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(200));
        given()
                .header(getHeader())
                .when()
                .get("/users/315")
                .then()
                .body("id", equalTo(315))
                .body("firstName", equalTo("Петр"));
    }

    @Test
    public void putUserResetPasswordTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(200));
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
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(200));
        given()
                .header(getHeader())
                .post("/users/315/unban")
                .then()
                .log().all();
    }

    @Test
    public void postUserBanTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(200));
        given()
                .header(getHeader())
                .post(URL + "/users/315/ban")
                .then();
    }

    @Test
    public void postUserArchiveTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(200));
        given()
                .header(getHeader())
                .body(archiveBody.getRequestArchiveBody())
                .post("/users/315/archive")
                .then();
    }

    @Test
    public void getInfoForUserID() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(200));
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
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(200));
        given()
                .header(getHeader())
                .get("/users/teachers/info")
                .then()
                .log().all();
    }

    @Test
    public void getSearchForTeachersId() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(200));
        given()
                .header(getHeader())
                .get("/users/teachers/317")
                .then()
                .body("id", equalTo(317))
                .log().all();
    }
}
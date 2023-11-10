package api.tests;

import api.testBase.BaseMethod;
import api.testBase.inBodyClasses.Course;
import io.restassured.response.Response;
import lombok.Getter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import static api.helper.Specifications.installSpec;
import static io.restassured.RestAssured.given;


public class CoursesRestControllerTests extends BaseMethod {
    Course course = new Course("1XBET", "Описание того, чему посвящен ку2рс",
            52, 327, "2023-11-03", "2024-11-03", 0, 0, 0, "LIVE");
    @Getter
    private Integer courseId;

    @BeforeMethod
    public void postCreateCourseTest() {
        Response response = given().header(getHeader())
                .body(course)
                .post("/courses");
        courseId = response.jsonPath().getInt("id");
        response.then().log().all();
    }

    @Test
    public void getCourseTest() {
        installSpec(URL, 200);
        given().header(getHeader())
                .get("/courses/" + courseId)
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void putCourseTest() {
        installSpec(URL, 200);
        given().header(getHeader())
                .body(course)
                .put("/courses/" + courseId)
                .then().log().all()
    }
}
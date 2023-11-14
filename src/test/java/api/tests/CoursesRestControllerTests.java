package api.tests;

import api.testBase.BaseMethod;
import api.testBase.inBodyClasses.Course;
import io.restassured.response.Response;
import lombok.Getter;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static api.helper.Specifications.installSpec;
import static io.restassured.RestAssured.given;


public class CoursesRestControllerTests extends BaseMethod {
    Course course = new Course("1XBET", "Описание того, чему посвящен ку2рс",
            52, 327, "2023-11-03", "2024-11-03", 0, 0, 0, "LIVE");
    @Getter
    private Integer courseId;

    @BeforeMethod
    public void postCreateCourseTest() {
        installSpec(URL,200);
        Response response = given().header(getHeader())
                .body(course)
                .post("/courses");
        courseId = response.jsonPath().getInt("id");
        response.then().log().all();
    }
    @AfterClass
    public void deleteCourse(){
        deleteCourseMethod();
    }

    @Test
    public void getCourseTest() {
        getRequest(URL,200,"/courses/" + courseId,200);
    }

    @Test
    public void putCourseTest() {
        putRequest(URL,200,course,"/courses/" + courseId,200);
    }
}
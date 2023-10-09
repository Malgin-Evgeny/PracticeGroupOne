package api.tests.usersRestController;

import api.testBase.token.MyToken;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.util.function.Predicate.not;
import static org.hamcrest.Matchers.*;

public class UsersRestControllerTest extends MyToken {


    @Test
    public void getUsersRestControllerTest() {
        given().header(getHeader())
                .when()
                .get(URL + "/users")
                .then().log().all();
    }

    @Test
    public void postUserRestControllerTest(){
        given().header(getHeader())
                .when()
                .put(URL+"/users/315/reset-password")
                .then()
                .assertThat()
                .body("$", hasKey("login"))
                .body("$", hasKey("password"))
                .body("login", Matchers.not(emptyString()))
                .body("password",Matchers.not(emptyString()))
                .log().all();
    }
}

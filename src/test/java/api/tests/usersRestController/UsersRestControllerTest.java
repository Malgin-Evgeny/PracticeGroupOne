package api.tests.usersRestController;

import api.testBase.token.MyToken;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UsersRestControllerTest extends MyToken{
    @Test
    public void getUsersRestControllerTest() {
        given().header(getHeader())
                .when()
                .get(URL+"/users")
                .then()
                .assertThat().statusCode(200);
    }
}

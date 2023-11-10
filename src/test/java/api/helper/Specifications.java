package api.helper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    private static RequestSpecification requestSpec (String url){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    private static ResponseSpecification responseSpecUnique(int status){
       return new ResponseSpecBuilder()
               .expectStatusCode(status)
               .build();
    }

    private static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
    public static void installSpec (String URL, int status){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(status));
    }
}

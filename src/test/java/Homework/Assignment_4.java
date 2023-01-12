package Homework;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Assignment_4 extends HerOkuAppBaseUrl {

    /*
           Given
               https://restful-booker.herokuapp.com/booking?firstname=Brandon&lastname=Wilson
           When
               User sends get request to the URL
           Then
               Status code is 200
           And
               Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"

    */
    @Test
    public void get04() {
//        Given
//        https://restful-booker.herokuapp.com/booking?firstname=Brandon&lastname=Wilson

        spec.pathParam("first","booking").
                queryParams("firstname","Brandon","lastname","Wilson");

//        When
//        User sends get request to the URL
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

//        Then
//        Status code is 200
        Assert.assertEquals(200,response.getStatusCode());

//        And
//        Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"
        Assert.assertTrue(response.asString().contains("bookingid"));


    }

}

package Homework;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Assignment_1 {
       /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void get01(){
        String url = "https://reqres.in/api/users/3";

        //Set expected data

        //Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

        //Do Assertion
        response.then().assertThat().statusCode(200).contentType("application/JSON").statusLine("HTTP/1.1 200 OK");

        System.out.println("response.statusCode() = " +response.statusCode());
        System.out.println("response.contentType() = " +response.contentType());
        System.out.println("response.statusLine() = " +response.statusLine());





    }

}

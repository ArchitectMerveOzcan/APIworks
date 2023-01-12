package Homework;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Assignment_2 {

    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty

     */
    @Test
    public void get002(){
        //Set URL
        String url = "https://reqres.in/api/users/23";

        //Set the expected data

        //Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

        assertEquals(404, response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found", response.statusLine());
        assertEquals(0, response.asString().replaceAll("[^A-Za-z0-9]", "").length());
        assertEquals("cloudflare", response.getHeader("Server"));




    }
    /*
            assertEquals(404, response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        assertEquals("cloudflare",response.getHeader("Server"));
        assertEquals(0, response.asString().replaceAll("[^A-Za-z0-9]", "").length());
        //or
        assertEquals(0,response.as(HashMap.class).size());
     */





}

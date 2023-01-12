package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class Get06 extends HerOkuAppBaseUrl {
    /*
   Given
       https://restful-booker.herokuapp.com/booking/
   When
       User send a GET request to the URL
   Then
       HTTP Status Code should be 200
   And
       Response content type is “application/json”
   And
       Response body should be like;
         {
           "firstname": "Susan",
           "lastname": "Jones",
           "totalprice": 696,
           "depositpaid": true,
           "bookingdates": {
               "checkin": "2021-07-11",
               "checkout": "2022-05-01"
           },
           "additionalneeds": "Breakfast"
           }
*/
    @Test
    public void get06() {
        //Set the url
        spec.pathParams("first","booking", "second", 2);

        //Set expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("Jim"),
                        "lastname", equalTo("Jackson"),
                        "totalprice",equalTo(478),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2020-07-01"),
                        "bookingdates.checkout",equalTo("2022-08-22"));

        //2nd Way: We will use JsonPath Class
        JsonPath jsonPath = response.jsonPath();

        //Hard Assertion
        assertEquals("Jim",jsonPath.getString("firstname"));
        assertEquals("Jackson",jsonPath.getString("lastname"));
        assertEquals(478,jsonPath.getInt("totalprice"));
        assertEquals(true,jsonPath.getBoolean("depositpaid"));
        assertEquals("2020-07-01",jsonPath.getString("bookingdates.checkin"));
        assertEquals("2022-08-22",jsonPath.getString("bookingdates.checkout"));


        //Soft Assertion
        //To do Soft Assertion follow this 3 steps
        //1st: Create SoftAsser Object
        SoftAssert softAssert = new SoftAssert();

        //2nd: Do Assertion
        softAssert.assertEquals(jsonPath.getString("firstname"), "Jim", "firstname did not match");//3rd parameter is for failure message
        softAssert.assertEquals(jsonPath.getString("lastname"), "Jackson", "lastname did not match");
        softAssert.assertEquals(jsonPath.getInt("totalprice"), 478, "totalprice did not match");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkin"), "2020-07-01", "checkin did not match");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkout"), "2022-08-22", "checkout did not match");

        //3rd: Use assetAll() method
        softAssert.assertAll();





    }

}

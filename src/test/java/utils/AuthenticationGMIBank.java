package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationGMIBank {
    public static void main(String[] args) {
        System.out.println(generateToken());
    }
    public static String generateToken(){
        Map<String,Object> gmi = new HashMap<>();
        gmi.put("password","John.123");
        gmi.put("rememberMe",true);
        gmi.put("username", "john_doe");

        Response response = given().
                contentType(ContentType.JSON).
                body(gmi).
                when().
                post("https://www.gmibank.com/api/authenticate");

        return response.jsonPath().getString("id_token");

//eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huX2RvZSIsImF1dGgiOiJST0xFX0FETUlOIiwiZXhwIjoxNjcyNDY1Mzk0fQ.GlePmJ96xBtOeT42-F3VWKFd80NgSRgKuoKT1wTtqXEFSfx7v05vzlvRhjbvvf9spwmm6QaqfGFXMD44DXljCw

    }
}

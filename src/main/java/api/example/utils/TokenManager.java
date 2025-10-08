package api.example.utils;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class TokenManager {
    public static String token;
    public TokenManager tokenManager;

    public static String getToken(){
        if (token== null){
            token=genateToken();
        }
        return token;
    }

    public static String genateToken(){
        System.out.println("Set Up Token");
        String requestBody ="{\r\n" + //
                        "    \"username\" : \"admin\",\r\n" + //
                        "    \"password\" : \"password123\"\r\n" + //
                        "}";
        Response response=
                given() 
                    .baseUri("https://restful-booker.herokuapp.com/auth")
                    .header("Content-Type", "application/json")
                    .header("accept", "application/json")
                    .body(requestBody)
                .when()
                    .post();
        token    = response.jsonPath().getString("token");
        return token;
    }


}

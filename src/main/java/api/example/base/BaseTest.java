package api.example.base;

import static io.restassured.RestAssured.given;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import api.example.utils.Helper;
import api.example.utils.TokenManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
    public static String token, baseURI;
    @BeforeSuite 
    public void BeforeSuite(){
        System.out.println("Ini Before Suite");
        token = TokenManager.getToken();
        baseURI = Helper.getKey("BASE_URI");
    }
    
    @BeforeMethod
    public void setupRequestSpesification(){
      System.out.println("Set Up Request Spesification"); 
      RestAssured.requestSpecification = given() 
                        .baseUri(baseURI)
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .header( "Cookie", "token=" + token);
                
    }

    @AfterMethod
    public void afterMethod(){
    System.out.println("After Method");
     if (RestAssured.requestSpecification != null) {
            RestAssured.requestSpecification = null;
        }
    }
   

    

}

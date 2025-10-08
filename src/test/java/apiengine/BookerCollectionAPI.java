package apiengine;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;

import api.example.base.BaseTest;
import api.example.utils.TokenManager;
import io.restassured.response.Response;

public class BookerCollectionAPI extends BaseTest{
   

    public BookerCollectionAPI(){
       
    }

    public static <T> Response createBookingToCollectionAPI(T payload){
         Response response = given() 
                .baseUri(baseURI)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                    .post("/booking");
         return response;
    }

    public static <T> Response updateBookingCollectionAPI(T payload,int idBooking){
         Response response = given()
                        .body(payload)
                        .log().all() 
                    .when() 
                        .put("/booking/"+idBooking);
        return response;
    }

    public static <T> Response partialUpdateBookingCollectionAPI(T payload, int idBooking){
           Response response = given()
                        .body(payload)
                        .log().all()
                    .when()
                        .patch("/booking/"+idBooking);
        return response;
    }

    public static Response deleteBookingCollectionAPI(int idBooking){
        Response response= given()
        .when()
            .delete("/booking/"+idBooking);
        return response;
    }
}

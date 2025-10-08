package scanario.getbooking;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PositiveCaseGetBooking {
    //1. Request dengan id valid
    @Test
    public void get_booking_valid(){
        System.out.println("Request dengan id valid");
        given()
            .baseUri("https://restful-booker.herokuapp.com/booking/4")
        .when()
            .get()
        .then()
            .statusCode(200)    
            .log().all();
            
    }
    //Valid ID dengan header Accept: application/json
    @Test
    public void get_booking__header_valid(){
        System.out.println("Request dengan id valid");
        given()
            .baseUri("https://restful-booker.herokuapp.com/booking/4")
            .header("accept", "application/json")
        .when()
            .get()
        .then()
            .statusCode(200)    
            .log().all();
            
    }

    //Valid ID paling kecil 
    @Test
    public void get_booking__header_lowestId(){
        System.out.println("Request dengan id valid");
        given()
            .baseUri("https://restful-booker.herokuapp.com/booking/2")
            .header("accept", "application/json")
        .when()
            .get()
        .then()
            .statusCode(200)    
            .log().all();
            
    }
}

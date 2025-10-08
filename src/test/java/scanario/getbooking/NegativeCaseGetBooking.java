package scanario.getbooking;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class NegativeCaseGetBooking {
//1. Request dengan 
    @Test
    public void get_booking_valid(){
        System.out.println("Request dengan id valid");
        given()
            .baseUri("https://restful-booker.herokuapp.com/booking/2")
        .when()
            .post()
        .then()
            .statusCode(404)    
            .log().all();
            
    }
    @Test
    public void get_booking__header_valid(){
        System.out.println("Request dengan id valid");
        given()
            .baseUri("https://restful-booker.herokuapp.com/book/2")
            .header("accept", "application/json")
        .when()
            .get()
        .then()
            .statusCode(404)    
            .log().all();
            
    }
    @Test
    public void get_booking_id_invalid(){
        System.out.println("Request dengan id valid");
        given()
            .baseUri("https://restful-booker.herokuapp.com/booking/300000000000000000000000")
            .header("accept", "application/json")
        .when()
            .get()
        .then()
            .statusCode(404)    
            .log().all();
            
    }
    
}

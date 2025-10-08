package scanario.getbookingids;
import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PositiveCaseGetBookingIds {

    //Get All Booking IDs
    @Test
    public void get_booking_ids (){
        System.out.println("Get All Booking IDs");
            given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
            .when()
                 .get()
             .then()
                .statusCode(200)
                .log().all();

    }

    //Get First Name John 
    @Test
    public void get_booking_ids_firsname (){
        System.out.println("Get First Name John ");
            given()
                .baseUri("https://restful-booker.herokuapp.com/booking?firstname=John")
            .when()
                 .get()
             .then()
                .statusCode(200)
                .log().all();

    }

    //Get Last Name Smith 
     @Test
    public void get_booking_ids_lastname (){
        System.out.println("Get First Name John ");
            given()
                .baseUri("https://restful-booker.herokuapp.com/booking?lastname=Smith")
            .when()
                 .get()
             .then()
                .statusCode(200)
                .log().all();

    }
    
}

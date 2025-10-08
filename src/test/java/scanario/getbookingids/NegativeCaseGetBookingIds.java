package scanario.getbookingids;
import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class NegativeCaseGetBookingIds {
    //Request dengan parameter tidak dikenal
    @Test
    public void get_booking_ids_parameter_unknow(){
         System.out.println("Request dengan parameter tidak dikenal");
            given()
                .baseUri("https://restful-booker.herokuapp.com//booking?unknown=123")
            .when()
                 .get()
             .then()
                .statusCode(404)
                .log().all();

    }

    //Request dengan parameter valid tapi format salah (/booking?checkin=abcd)
    @Test
    public void get_booking_ids_wrong_format(){
        System.out.println("Request dengan parameter valid tapi format salah (/booking?checkin=abcd)");
            given()
                .baseUri("https://restful-booker.herokuapp.com//booking?checkin=abcd")

            .when()
                 .get()
             .then()
                .statusCode(404)    
                .log().all();
    }

    // Request pakai method salah
    @Test
    public void get_booking_ids_wrong_method(){
        System.out.println("Request pakai method salah");
            given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
            .when()
                 .post()
             .then()
                .statusCode(500)    
                .log().all();
    }
}

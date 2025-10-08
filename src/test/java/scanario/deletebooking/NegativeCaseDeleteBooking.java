package scanario.deletebooking;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.example.base.BaseTest;
import apiengine.BookerCollectionAPI;
import io.restassured.response.Response;

public class NegativeCaseDeleteBooking extends BaseTest{
    String token;
    int idBooking;
    
    // public BookerCollectionAPI bookerCollectionAPI;
    // @BeforeClass
    // public void signin(){
    //     System.out.println("Sign In");
    //     String requestBody ="{\r\n" + //
    //                     "    \"username\" : \"admin\",\r\n" + //
    //                     "    \"password\" : \"password123\"\r\n" + //
    //                     "}";
    //     Response response=
    //             given()
    //                 .baseUri("https://restful-booker.herokuapp.com/auth")
    //                 .header("Content-Type", "application/json")
    //                 .header("accept", "application/json")
    //                 .body(requestBody)
    //             .when()
    //                 .post();
    //     token = response.jsonPath().getString("token");
    //     bookerCollectionAPI = new BookerCollectionAPI();
    // }

    //Create Booking 
    @Test
    public void create_booking (){
         String requestBody = "{\r\n" + //
                "    \"firstname\" : \"Jim\",\r\n" + //
                "    \"lastname\" : \"Brown\",\r\n" + //
                "    \"totalprice\" : 111,\r\n" + //
                "    \"depositpaid\" : true,\r\n" + //
                "    \"bookingdates\" : {\r\n" + //
                "        \"checkin\" : \"2018-01-01\",\r\n" + //
                "        \"checkout\" : \"2019-01-01\"\r\n" + //
                "    },\r\n" + //
                "    \"additionalneeds\" : \"Breakfast\"\r\n" + //
                "}";
        Response response = BookerCollectionAPI.createBookingToCollectionAPI(requestBody);
        System.out.println(response.asPrettyString());
        idBooking=response.jsonPath().get("bookingid");
        Assert.assertEquals(response.statusCode(), 200, "Status code should be 200");
        System.out.println("Response"+response.asPrettyString());
        Assert.assertTrue(response.jsonPath().get("booking.firstname").equals("Jim"),"First Name is Jim");
        Assert.assertTrue(response.jsonPath().get("booking.lastname").equals("Brown"),"Last Name is Brown");
    }

    //Delete Booking Invalid ID
     @Test (dependsOnMethods = {"create_booking"},priority = 1)
    public void delete_booking_invalid_id(){
        System.out.println("Delete Booking Invalid ID");
        Response response = BookerCollectionAPI.deleteBookingCollectionAPI(352529368);
        System.out.println(response.asPrettyString());
         Assert.assertEquals(response.statusCode(), 405, "Status code should be 405");
    }

    // Delete Booking Invalid Token
    //  @Test (dependsOnMethods = {"create_booking"})
    // public void delete_booking_invalid_token(){
    //     System.out.println("Delete Booking Invalid Token");
    //     Response response 
    //     //Response response = bookerCollectionAPI.deleteBookingCollectionAPI("235435346543fdadsf", idBooking);
    //     System.out.println(response.asPrettyString());
    //      Assert.assertEquals(response.statusCode(), 403, "Status code should be 403");
    // }

    //Delete Booking header null
      @Test (dependsOnMethods = {"create_booking"})
    public void delete_booking_header_null(){
        System.out.println("Delete Booking Invalid ID");
        Response response= given()
            .baseUri("https://restful-booker.herokuapp.com/booking/"+idBooking)
            //.header("Content-Type", "application/json")
            //.header( "Cookie", "token= " + token)
        .when()
            .delete();
         Assert.assertEquals(response.statusCode(), 201, "Status code should be 201");
    }


}

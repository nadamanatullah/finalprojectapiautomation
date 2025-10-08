package scanario.partialupdatebooking;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import api.example.base.BaseTest;
import api.example.model.request.RequestCreateBooks;
import api.example.model.request.RequestPartialUpdateBooking;
import api.example.model.response.ResponseCreateBooks;
import api.example.utils.Helper;
import apiengine.BookerCollectionAPI;
import io.restassured.response.Response;

public class NegativeCasePartialUpdateBooking extends BaseTest {
    String token;
    int idBooking;

    public BookerCollectionAPI bookerCollectionAPI;

    //Create Booking 
    @Test
    public void create_booking ()throws JsonMappingException, JsonProcessingException{
          System.out.println(("1. Create Booking dengan isi semua field dengan data valid")); 
        RequestCreateBooks requestCreateBooks = Helper.findByUseCase("create_book_collection_data.json", "create_book_collection_data1",RequestCreateBooks.class);
        System.out.println("response:"+ requestCreateBooks);
        Response response = BookerCollectionAPI.createBookingToCollectionAPI(requestCreateBooks);
        System.out.println("response: "+ response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200, "Status code should be 200");
        System.out.println("Response"+response.asPrettyString());
        
        ResponseCreateBooks responseCreateBooks = Helper.convertResponseToObject(response, ResponseCreateBooks.class);
        idBooking = responseCreateBooks.bookingid;
        System.out.println(responseCreateBooks.booking.firstname);
        System.out.println(responseCreateBooks.booking.lastname);
        System.out.println(responseCreateBooks.booking.totalprice);
        System.out.println(responseCreateBooks.booking.depositpaid);
        System.out.println(responseCreateBooks.booking.bookingdates.checkin);
        System.out.println(responseCreateBooks.booking.bookingdates.checkout);
        System.out.println(responseCreateBooks.booking.additionalneeds);
    }

    //Partial Update total price dengan string 

    @Test (dependsOnMethods = {"create_booking"})
    public void partial_update_invalid_field(){
         System.out.println("Partial Update total price dengan string");
           RequestPartialUpdateBooking requestPartialUpdateBooking = Helper.findByUseCase("partial_update_booking_collection_data.json", "partial_update_booking_data4",RequestPartialUpdateBooking.class);
            System.out.println("response:"+ requestPartialUpdateBooking);
            Response response = BookerCollectionAPI.partialUpdateBookingCollectionAPI(requestPartialUpdateBooking,idBooking);
            System.out.println("response: "+ response.asPrettyString());
            Assert.assertEquals(response.statusCode(),200, "Status code should be 200");
            System.out.println("Response"+response.asPrettyString());
    }

    // Partial Update Invalid Token
    // @Test (dependsOnMethods = {"create_booking"})
    // public void partial_update_invalid_token(){
    //         System.out.println("Partial Update Invalid Token");
    //         String requestBody = "{\r\n" + //
    //             "    \"totalprice\" : 1000000,\r\n" + //
    //             "    \"depositpaid\" : false\r\n" + //
    //             "}";
    //         Response response = bookerCollectionAPI.partialUpdateBookingCollectionAPI(requestBody, "141243355", idBooking);
    //         System.out.println(response.asPrettyString());
    //         System.out.println("Response"+response.asPrettyString());
    //         Assert.assertEquals(response.statusCode(),403,  "Status code should be 403");
    // }
    
    // Partial Update Id Tidak Valid
    @Test (dependsOnMethods = {"create_booking"})
    public void partial_update_booking_invalid_id(){
        System.out.println("Partial Update Id Tidak Valid");
       RequestPartialUpdateBooking requestPartialUpdateBooking = Helper.findByUseCase("partial_update_booking_collection_data.json", "partial_update_booking_data1",RequestPartialUpdateBooking.class);
            System.out.println("response:"+ requestPartialUpdateBooking);
            Response response = BookerCollectionAPI.partialUpdateBookingCollectionAPI(requestPartialUpdateBooking,13123432);
            System.out.println("response: "+ response.asPrettyString());
            Assert.assertEquals(response.statusCode(), 405, "Status code should be 405");
            System.out.println("Response"+response.asPrettyString());
    }
}

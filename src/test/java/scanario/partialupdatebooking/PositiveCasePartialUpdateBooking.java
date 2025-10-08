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
import api.example.model.request.RequestUpdateBooks;
import api.example.model.response.ResponseCreateBooks;
import api.example.utils.Helper;
import apiengine.BookerCollectionAPI;
import io.restassured.response.Response;

public class PositiveCasePartialUpdateBooking extends BaseTest{
    String token;
    int idBooking;

    public BookerCollectionAPI bookerCollectionAPI;

    //Create Booking 
    @Test
    public void create_booking ()throws JsonMappingException, JsonProcessingException{
        System.out.println(("1. Create Booking ")); 
        RequestCreateBooks requestCreateBooks = Helper.findByUseCase("create_book_collection_data.json", "create_book_collection_data1",RequestCreateBooks.class);
        System.out.println("response:"+ requestCreateBooks);
        Response response = BookerCollectionAPI.createBookingToCollectionAPI(requestCreateBooks);
        
        Assert.assertEquals(response.statusCode(), 200, "Status code should be 200");
        System.out.println("Response"+response.asPrettyString());
        System.out.println(response.asPrettyString());
   
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
    //Partial Update Just First Name
    @Test (dependsOnMethods = {"create_booking"},priority = 1)
    public void partial_update_booking_firstlastname(){
            System.out.println("Partial Update Just First Name");

            RequestPartialUpdateBooking requestPartialUpdateBooking = Helper.findByUseCase("partial_update_booking_collection_data.json", "partial_update_booking_data1",RequestPartialUpdateBooking.class);
            System.out.println("response:"+ requestPartialUpdateBooking);
            Response response = BookerCollectionAPI.partialUpdateBookingCollectionAPI(requestPartialUpdateBooking,idBooking);
            System.out.println("response: "+ response.asPrettyString());
            Assert.assertEquals(response.statusCode(), 200, "Status code should be 200");
            System.out.println("Response"+response.asPrettyString());
    }

    //Partial Update Total Price & Deposite Paid
    @Test (dependsOnMethods = {"create_booking"},priority = 2)
    public void partial_update_booking_price_deposite(){
            System.out.println("Partial Update Total Price & Deposite Paid");
            RequestPartialUpdateBooking requestPartialUpdateBooking = Helper.findByUseCase("partial_update_booking_collection_data.json", "partial_update_booking_data2",RequestPartialUpdateBooking.class);
            System.out.println("response:"+ requestPartialUpdateBooking);
            Response response = BookerCollectionAPI.partialUpdateBookingCollectionAPI(requestPartialUpdateBooking,idBooking);
            System.out.println("response: "+ response.asPrettyString());
            Assert.assertEquals(response.statusCode(), 200, "Status code should be 200");
            System.out.println("Response"+response.asPrettyString());
    }


    //Partial Update Total Price = 0
    @Test (dependsOnMethods = {"create_booking"},priority = 3)
    public void partial_update_booking_price(){
            System.out.println("Partial Update Total Price = 0");
            RequestPartialUpdateBooking requestPartialUpdateBooking = Helper.findByUseCase("partial_update_booking_collection_data.json", "partial_update_booking_data3",RequestPartialUpdateBooking.class);
            System.out.println("response:"+ requestPartialUpdateBooking);
            Response response = BookerCollectionAPI.partialUpdateBookingCollectionAPI(requestPartialUpdateBooking,idBooking);
            System.out.println("response: "+ response.asPrettyString());
            Assert.assertEquals(response.statusCode(), 200, "Status code should be 200");
            System.out.println("Response"+response.asPrettyString());
    }

    
}

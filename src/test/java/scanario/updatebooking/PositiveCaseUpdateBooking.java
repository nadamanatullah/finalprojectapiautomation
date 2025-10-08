package scanario.updatebooking;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import api.example.base.BaseTest;
import api.example.model.request.RequestCreateBooks;
import api.example.model.request.RequestUpdateBooks;
import api.example.model.response.ResponseCreateBooks;
import api.example.utils.Helper;
import apiengine.BookerCollectionAPI;
import io.restassured.response.Response;

public class PositiveCaseUpdateBooking extends BaseTest {
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

    // Update All Field data valid
    @Test (dependsOnMethods = {"create_booking"})
    public void update_booking_valid()throws JsonMappingException, JsonProcessingException{
        System.out.println("Update All Field data valid");

        RequestUpdateBooks requestUpdateBooks = Helper.findByUseCase("update_book_collection_data.json", "update_book_collection_data1",RequestUpdateBooks.class);
        System.out.println("response:"+ requestUpdateBooks);
        Response response = BookerCollectionAPI.updateBookingCollectionAPI(requestUpdateBooks,idBooking);
        System.out.println("response: "+ response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200, "Status code should be 200");
        System.out.println("Response"+response.asPrettyString());
    
    }

    //Update First Name & Last Name
    @Test (dependsOnMethods = {"create_booking"},priority = 2)
    public void update_booking_firstlastname(){
            System.out.println("Update First Name & Last Name");
            RequestUpdateBooks requestUpdateBooks = Helper.findByUseCase("update_book_collection_data.json", "update_book_collection_data2",RequestUpdateBooks.class);
            //RequestUpdateBooks requestUpdateBooks = Helper.findByUseCase("update_book_collection_data.json", "update_book_collection_data1",RequestCreateBooks.class,idBooking);
            System.out.println("response:"+ requestUpdateBooks);
            Response response = BookerCollectionAPI.updateBookingCollectionAPI(requestUpdateBooks,idBooking);
            System.out.println("response: "+ response.asPrettyString());
            Assert.assertEquals(response.statusCode(), 200, "Status code should be 200");
            System.out.println("Response"+response.asPrettyString());
            //System.out.println(response.asPrettyString());
          

    }

    // //Update Check In dan Check Out
    @Test (priority = 3)
    public void update_booking_checkinout(){
        System.out.println("Update Check In dan Check Out");
        RequestUpdateBooks requestUpdateBooks = Helper.findByUseCase("update_book_collection_data.json", "update_book_collection_data3",RequestUpdateBooks.class);
            //RequestUpdateBooks requestUpdateBooks = Helper.findByUseCase("update_book_collection_data.json", "update_book_collection_data1",RequestCreateBooks.class,idBooking);
        System.out.println("response:"+ requestUpdateBooks);
        Response response = BookerCollectionAPI.updateBookingCollectionAPI(requestUpdateBooks,idBooking);
        System.out.println("response: "+ response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200, "Status code should be 200");
        System.out.println("Response"+response.asPrettyString());
        //System.out.println(response.asPrettyString());

    }
}

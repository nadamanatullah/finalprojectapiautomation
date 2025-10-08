package scanario.deletebooking;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.example.base.BaseTest;
import api.example.model.request.RequestCreateBooks;
import api.example.model.response.ResponseCreateBooks;
import api.example.utils.Helper;
import apiengine.BookerCollectionAPI;
import io.restassured.response.Response;

public class PositiveCaseDeleteBooking extends BaseTest {
    String token;
    int idBooking;

    public BookerCollectionAPI bookerCollectionAPI;
    
    //Create Booking 
    @BeforeMethod
    public void create_booking (){
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

    //Delete Booking ID Valid
     @Test 
    public void delete_booking(){
        System.out.println("Delete Booking ID Valid");
        Response response = BookerCollectionAPI.deleteBookingCollectionAPI(idBooking);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 201, "Status code should be 201");
    }

    //Delete Booking Token Valid 
    @Test 
    public void delete_booking_token_Valid(){
        System.out.println("Delete Booking Token Valid");
        Response response = BookerCollectionAPI.deleteBookingCollectionAPI(idBooking);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 201, "Status code should be 201");
    }

    //Delete Booking header Valid 
    @Test 
    public void delete_booking_header_Valid(){
        System.out.println("Delete Booking Token Valid");
        Response response = BookerCollectionAPI.deleteBookingCollectionAPI(idBooking);
        System.out.println(response.asPrettyString());
         Assert.assertEquals(response.statusCode(), 201, "Status code should be 201");
    }

}

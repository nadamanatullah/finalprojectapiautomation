package scanario.updatebooking;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.example.base.BaseTest;
import api.example.model.request.RequestCreateBooks;
import api.example.model.request.RequestUpdateBooks;
import api.example.model.response.ResponseCreateBooks;
import api.example.utils.Helper;
import apiengine.BookerCollectionAPI;
import io.restassured.response.Response;

public class NegativeCaseUpdateBooking extends BaseTest {
     String token;
    int idBooking;

    public BookerCollectionAPI bookerCollectionAPI;
    
    //Create Booking 
    @Test
    public void create_booking (){
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

    //1. Update dengan id tidak valid
    @Test (dependsOnMethods = {"create_booking"})
    public void update_booking_invalid_id(){
            System.out.println("Update dengan id tidak valid");
            RequestUpdateBooks requestUpdateBooks = Helper.findByUseCase("update_book_collection_data.json", "update_book_collection_data1",RequestUpdateBooks.class);
            System.out.println("response:"+ requestUpdateBooks);
            Response response = BookerCollectionAPI.updateBookingCollectionAPI(requestUpdateBooks,1324325345);
            System.out.println(response.asPrettyString());
            System.out.println("Response"+response.asPrettyString());
            Assert.assertEquals(response.statusCode(),405,  "Status code should be 405");    
    }


    //Update First Name Null
    @Test (dependsOnMethods = {"create_booking"})
    public void update_booking_firstname_null(){
        System.out.println("Update First Name Null");
        RequestUpdateBooks requestUpdateBooks = Helper.findByUseCase("update_book_collection_data.json", "update_book_collection_data4",RequestUpdateBooks.class);
        System.out.println("response:"+ requestUpdateBooks);
        Response response = BookerCollectionAPI.updateBookingCollectionAPI(requestUpdateBooks,idBooking);
        System.out.println(response.asPrettyString());
        System.out.println("Response"+response.asPrettyString());
        Assert.assertEquals(response.statusCode(),400,  "Status code should be 400"); 
    }
        
    

}

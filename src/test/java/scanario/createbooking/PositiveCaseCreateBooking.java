package scanario.createbooking;

import static io.restassured.RestAssured.given;

import java.lang.runtime.ObjectMethods;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.example.base.BaseTest;
import api.example.model.request.RequestCreateBooks;
import api.example.model.response.ResponseCreateBooks;
import api.example.utils.Helper;
import apiengine.BookerCollectionAPI;
import groovyjarjarpicocli.CommandLine.Help;
import io.restassured.response.Response;

public class PositiveCaseCreateBooking extends BaseTest {
   public BookerCollectionAPI bookerCollectionAPI;
    
    // @BeforeMethod

    // public void setUp(){
    //     bookerCollectionAPI = new BookerCollectionAPI();
    // }

    // Create Booking dengan isi semua field dengan data valid
    @Test (priority = 1)
    public void create_booking_data_valid() throws JsonMappingException, JsonProcessingException {
        System.out.println(("1. Create Booking dengan isi semua field dengan data valid")); 
        RequestCreateBooks requestCreateBooks = Helper.findByUseCase("create_book_collection_data.json", "create_book_collection_data1",RequestCreateBooks.class);
        System.out.println("response:"+ requestCreateBooks);
        Response response = BookerCollectionAPI.createBookingToCollectionAPI(requestCreateBooks);
        System.out.println("response: "+ response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200, "Status code should be 200");
        System.out.println("Response"+response.asPrettyString());
        System.out.println(response.asPrettyString());
        //ObjectMapper objectMapper = new ObjectMapper();
        
        ResponseCreateBooks responseCreateBooks = Helper.convertResponseToObject(response, ResponseCreateBooks.class);
        System.out.println(responseCreateBooks.booking.firstname);
        System.out.println(responseCreateBooks.booking.lastname);
        System.out.println(responseCreateBooks.booking.totalprice);
        System.out.println(responseCreateBooks.booking.depositpaid);
        System.out.println(responseCreateBooks.booking.bookingdates.checkin);
        System.out.println(responseCreateBooks.booking.bookingdates.checkout);
        System.out.println(responseCreateBooks.booking.additionalneeds);
        
    }

    //Create Booking dengan depositpaid false
    @Test (priority = 2)
    public void create_booking_change_depositpaid() throws JsonMappingException, JsonProcessingException{
        System.out.println(("Create Booking dengan depositpaid false"));
        RequestCreateBooks requestCreateBooks = Helper.findByUseCase("create_book_collection_data.json", "create_book_collection_data2",RequestCreateBooks.class);
        System.out.println("response:"+ requestCreateBooks);
        Response response = BookerCollectionAPI.createBookingToCollectionAPI(requestCreateBooks);
        System.out.println("response: "+ response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200, "Status code should be 200");
        System.out.println("Response"+response.asPrettyString());
        System.out.println(response.asPrettyString());
        //ObjectMapper objectMapper = new ObjectMapper();
        
        ResponseCreateBooks responseCreateBooks = Helper.convertResponseToObject(response, ResponseCreateBooks.class);
        System.out.println(responseCreateBooks.booking.firstname);
        System.out.println(responseCreateBooks.booking.lastname);
        System.out.println(responseCreateBooks.booking.totalprice);
        System.out.println(responseCreateBooks.booking.depositpaid);
        System.out.println(responseCreateBooks.booking.bookingdates.checkin);
        System.out.println(responseCreateBooks.booking.bookingdates.checkout);
        System.out.println(responseCreateBooks.booking.additionalneeds);
    }

    //Create Booking dengan additional needs dikosongkan
    @Test (priority = 3)
    public void create_booking_additionalneed(){
        System.out.println(("Create Booking dengan depositpaid false"));
        RequestCreateBooks requestCreateBooks = Helper.findByUseCase("create_book_collection_data.json", "create_book_collection_data3",RequestCreateBooks.class);
        System.out.println("response:"+ requestCreateBooks);
        //ResponseCreateBooks expectResponseCreateBooks = Helper.findExpectedByUseCase("create_book_collection_data.json", "create_book_collection_data3",ResponseCreateBooks.class);
        Response response = BookerCollectionAPI.createBookingToCollectionAPI(requestCreateBooks);
        System.out.println("response: "+ response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200, "Status code should be 200");
        System.out.println("Response"+response.asPrettyString());
        System.out.println(response.asPrettyString());
        //ObjectMapper objectMapper = new ObjectMapper();
        
        ResponseCreateBooks responseCreateBooks = Helper.convertResponseToObject(response, ResponseCreateBooks.class);
        //Assert.assertEquals(responseCreateBooks.booking.firstname.equals(expectResponseCreateBooks.booking.firstname),"First Name is "+expectResponseCreateBooks.booking.firstname);
         System.out.println(responseCreateBooks.booking.firstname);
        System.out.println(responseCreateBooks.booking.lastname);
        System.out.println(responseCreateBooks.booking.totalprice);
        System.out.println(responseCreateBooks.booking.depositpaid);
        System.out.println(responseCreateBooks.booking.bookingdates.checkin);
        System.out.println(responseCreateBooks.booking.bookingdates.checkout);
        
                
    }
}

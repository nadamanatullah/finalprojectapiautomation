package scanario.integration;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.example.base.BaseTest;
import api.example.model.request.RequestCreateBooks;
import api.example.model.request.RequestPartialUpdateBooking;
import api.example.model.request.RequestUpdateBooks;
import api.example.model.response.ResponseCreateBooks;
import api.example.utils.Helper;
import apiengine.BookerCollectionAPI;
import io.restassured.response.Response;

public class PositiveCaseIntegrationCase1 extends BaseTest{
     String token;
    int idBooking;
    
    public BookerCollectionAPI bookerCollectionAPI;

    
    //Create Valid Data > Update Valid Data > Delete Valid DataCreate Booking 
    @Test
    public void integration_test1 (){
       

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


        System.out.println("Update All Field data valid");

        RequestUpdateBooks requestUpdateBooks = Helper.findByUseCase("update_book_collection_data.json", "update_book_collection_data1",RequestUpdateBooks.class);
        System.out.println("response:"+ requestUpdateBooks);
        Response updateResponse = BookerCollectionAPI.updateBookingCollectionAPI(requestUpdateBooks,idBooking);
        System.out.println("response: "+ updateResponse.asPrettyString());
        Assert.assertEquals(updateResponse.statusCode(), 200, "Status code should be 200");
        System.out.println("Response"+updateResponse.asPrettyString());
          

            System.out.println("Delete Booking ID Valid");
            Response deleteResponse = BookerCollectionAPI.deleteBookingCollectionAPI(idBooking);
            System.out.println(deleteResponse.asPrettyString());
            Assert.assertEquals(deleteResponse.statusCode(), 201, "Status code should be 201");

    }

    //Create > Partial Update > Delete
    @Test 
    public void integration_test2(){
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

        System.out.println("Update Partial Data");
       RequestPartialUpdateBooking requestPartialUpdateBooking = Helper.findByUseCase("partial_update_booking_collection_data.json", "partial_update_booking_data1",RequestPartialUpdateBooking.class);
            System.out.println("response:"+ requestPartialUpdateBooking);
            Response partialResponse = BookerCollectionAPI.partialUpdateBookingCollectionAPI(requestPartialUpdateBooking,idBooking);
            System.out.println("response: "+ partialResponse.asPrettyString());
            Assert.assertEquals(partialResponse.statusCode(), 200, "Status code should be 200");
            System.out.println("Response"+partialResponse.asPrettyString());

        System.out.println("Delete Booking ID Valid");
        Response deleteResponse = BookerCollectionAPI.deleteBookingCollectionAPI(idBooking);
        System.out.println(deleteResponse.asPrettyString());
        Assert.assertEquals(deleteResponse.statusCode(), 201, "Status code should be 201");

    }


   


}

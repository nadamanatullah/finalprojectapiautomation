package convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.example.model.request.RequestCreateBooks;
import api.example.model.request.RequestPartialUpdateBooking;
import api.example.model.request.RequestUpdateBooks;

public class ConvertData {
    public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
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
        System.out.println(requestBody); 
        ObjectMapper objectMapper = new ObjectMapper();
        RequestCreateBooks requestCreateBooker = objectMapper.readValue(requestBody, RequestCreateBooks.class);
        System.out.println("-----Convert Json to Object-----");   
        System.out.println(requestCreateBooker.firstname);
        System.out.println(requestCreateBooker.lastname);
        System.out.println(requestCreateBooker.totalprice);
        System.out.println(requestCreateBooker.depositpaid);
        System.out.println(requestCreateBooker.bookingdates.checkin);
        System.out.println(requestCreateBooker.bookingdates.checkout);
        System.out.println(requestCreateBooker.additionalneeds); 
        
        RequestUpdateBooks requestUpdateBooker = objectMapper.readValue(requestBody, RequestUpdateBooks.class);
        System.out.println("-----Convert Json to Object-----");   
        System.out.println(requestUpdateBooker.firstname);
        System.out.println(requestUpdateBooker.lastname);
        System.out.println(requestUpdateBooker.totalprice);
        System.out.println(requestUpdateBooker.depositpaid);
        System.out.println(requestUpdateBooker.bookingdates.checkin);
        System.out.println(requestUpdateBooker.bookingdates.checkout);
        System.out.println(requestUpdateBooker.additionalneeds); 


        RequestPartialUpdateBooking requestPartialUpdateBooking = objectMapper.readValue(requestBody, RequestPartialUpdateBooking.class);
        System.out.println(requestPartialUpdateBooking.firstname);
        System.out.println(requestPartialUpdateBooking.totalprice);
        System.out.println(requestPartialUpdateBooking.depositpaid);
        System.out.println(requestPartialUpdateBooking.totalprice2);
    }
}

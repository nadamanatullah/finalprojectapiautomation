package api.example.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseCreateBooks {
     // "{\r\n" + //
    //                     "    \"firstname\" : \"Jim\",\r\n" + //
    //                     "    \"lastname\" : \"Brown\",\r\n" + //
    //                     "    \"totalprice\" : 111,\r\n" + //
    //                     "    \"depositpaid\" : true,\r\n" + //
    //                     "    \"bookingdates\" : {\r\n" + //
    //                     "        \"checkin\" : \"2018-01-01\",\r\n" + //
    //                     "        \"checkout\" : \"2019-01-01\"\r\n" + //
    //                     "    },\r\n" + //
    //                     "    \"additionalneeds\" : \"Breakfast\"\r\n" + //
    //                     "}";

   @JsonProperty("bookingid")
     public int bookingid;

    @JsonProperty("booking")
     public Booking booking;

    public static class Booking {
         @JsonProperty("firstname")
         public String firstname;

         @JsonProperty("lastname")
         public String lastname;

         @JsonProperty("totalprice")
         public int totalprice;

         @JsonProperty("depositpaid")
         public boolean depositpaid;

         @JsonProperty("additionalneeds")
         public String additionalneeds;

         @JsonProperty("bookingdates")
         public BookingDates bookingdates;
     }

    public static class BookingDates {
         @JsonProperty("checkin")
         public String checkin;

         @JsonProperty("checkout")
         public String checkout;

     }

}

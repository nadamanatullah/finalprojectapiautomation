package api.example.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestCreateBooks {
    // "firstname" : "Jim",
    // "lastname" : "Brown",
    // "totalprice" : 111,
    // "depositpaid" : true,
    // "bookingdates" : {
    //     "checkin" : "2018-01-01",
    //     "checkout" : "2019-01-01"
    // },
    // "additionalneeds" : "Breakfast"

    @JsonProperty("firstname")
    public String firstname;
    
     @JsonProperty("lastname")
    public String lastname;

    @JsonProperty ("totalprice")
    public int totalprice;

    @JsonProperty ("depositpaid")
    public boolean depositpaid;

    @JsonProperty("bookingdates")
    public bookingDates bookingdates;

    public static class bookingDates{
        @JsonProperty("checkin")
        public String checkin;

        @JsonProperty ("checkout")
        public String checkout;
    }
    @JsonProperty("additionalneeds")
    public String additionalneeds;
}

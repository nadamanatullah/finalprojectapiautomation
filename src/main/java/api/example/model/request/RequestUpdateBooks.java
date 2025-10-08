package api.example.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestUpdateBooks {

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

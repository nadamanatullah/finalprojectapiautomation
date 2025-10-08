package api.example.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestPartialUpdateBooking {
    @JsonProperty("firstname")
    public String firstname;

     @JsonProperty ("totalprice")
    public int totalprice;

    @JsonProperty ("depositpaid")
    public boolean depositpaid;

    @JsonProperty("totalprice2")
    public String totalprice2;
    
    
}

package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {

     /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Adamz" and last name is "Dear"
     */

    @Test
    public void get01(){

        //1. step : set the url
        spec.pathParam("first","booking")
                .queryParams("firstname","Aaron",
        "lastname","Chen");

        //2. step : set the expected data

        //3. step : send the request and get the response
        Response response =given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //4. step : do assertion
        response.then().assertThat().statusCode(200);
        assertTrue(response.asString().contains("bookingid"));

    }
}

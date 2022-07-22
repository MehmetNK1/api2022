package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingPojo;
import test_data.JsonPlaceHolderTestData;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get15ObjectMapper extends HerOkuAppBaseUrl {

    /*
    Given
	            https://restful-booker.herokuapp.com/booking/2
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
                    {
                        "firstname": "Oliver",
                        "lastname": "Smith",
                        "totalprice": 100,
                        "depositpaid": true,
                        "bookingdates": {
                            "checkin": "2022-07-18",
                            "checkout": "2022-07-19"
                        },
                        "additionalneeds": "Breakfast"
                    }
     */

    @Test
    public void get01 (){

        //1. Step: Set the Url
        spec.pathParams("first","booking","second",22);

        //2. Step: Set the expected Data
        String expectedData = "{\n" +
                "                        \"firstname\": \"Oliver\",\n" +
                "                        \"lastname\": \"Smith\",\n" +
                "                        \"totalprice\": 100,\n" +
                "                        \"depositpaid\": true,\n" +
                "                        \"bookingdates\": {\n" +
                "                            \"checkin\": \"2022-07-18\",\n" +
                "                            \"checkout\": \"2022-07-19\"\n" +
                "                        },\n" +
                "                        \"additionalneeds\": \"Breakfast\"\n" +
                "                    }";

        BookingPojo expectedDataPojo = JsonUtil.convertJsonToJavaObject(expectedData,BookingPojo.class);

        //3. Step: Send the GET Request and get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4. Step: Do Assertion
        BookingPojo actualDataPojo = JsonUtil.convertJsonToJavaObject(response.asString(), BookingPojo.class);

        //Hard Assertion
//        assertEquals(200, response.getStatusCode());
//        assertEquals(expectedDataPojo.getFirstname(),actualDataPojo.getFirstname());
//        assertEquals(expectedDataPojo.getLastname(),actualDataPojo.getLastname());
//        assertEquals(expectedDataPojo.getTotalprice(),actualDataPojo.getTotalprice());
//        assertEquals(expectedDataPojo.isDepositpaid(),actualDataPojo.isDepositpaid());
//        assertEquals(expectedDataPojo.getAdditionalneeds(),actualDataPojo.getAdditionalneeds());
//        assertEquals(expectedDataPojo.getBookingdates().getCheckin(),actualDataPojo.getBookingdates().getCheckin());
//        assertEquals(expectedDataPojo.getBookingdates().getCheckout(),actualDataPojo.getBookingdates().getCheckout());

        //soft Assertion
        //1. adim
        SoftAssert softAssert =new SoftAssert();

        //2. adim
        softAssert.assertEquals(actualDataPojo.getFirstname(),expectedDataPojo.getFirstname(),"uyusmadi");
        softAssert.assertEquals(actualDataPojo.getLastname(),expectedDataPojo.getLastname(),"uyusmadi");
        softAssert.assertEquals(actualDataPojo.getTotalprice(),expectedDataPojo.getTotalprice() ,"uyusmadi");
        softAssert.assertEquals(actualDataPojo.isDepositpaid(),expectedDataPojo.isDepositpaid() ,"uyusmadi");
        softAssert.assertEquals(actualDataPojo.getBookingdates().getCheckin(),expectedDataPojo.getBookingdates().getCheckin() ,"uyusmadi");
        softAssert.assertEquals(actualDataPojo.getBookingdates().getCheckout(),expectedDataPojo.getBookingdates().getCheckout() ,"uyusmadi");

        //3. adim
        softAssert.assertAll();
    }
}

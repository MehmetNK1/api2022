package get_requests;

public class Get06 {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/5
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
            {
                "firstname": "Mary",
                "lastname": "Jackson",
                "totalprice": 111,
                "depositpaid": false,
                "bookingdates": { "checkin": "2017-05-23",
                                  "checkout":"2019-07-02" }
            }
     */

    //String url="https://restful-booker.herokuapp.com/booking/5";
    //Response response=given().when().get(url);
    //response.prettyPrint();
    //response.then().assertThat().statusCode(200).contentType("application/json").
    //        body("firstname",equalTo("Mary"),
    //                "lastname",equalTo("Jackson"),
    //                "totalprice",equalTo(111),"depositpaid",equalTo(false),
    //                "bookingdates.checkin",equalTo("2017-05-23"),
    //                "bookingdates.checkout",equalTo("2019-07-02"));


}

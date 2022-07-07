package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get03 extends JsonPlaceHolderBaseUrl {


    //  Given
    //      https://jsonplaceholder.typicode.com/todos/23
    //  When
    //      User send GET Request to the URL
    //  Then
    //      HTTP Status Code should be 200
	//	And
	//	    Response format should be “application/json”
	//	And
	//	    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
	//	And
	//	    “completed” is false
	//	And
	//	    “userId” is 2


    @Test
    public void get01(){
        //1. step : Set the Url
        //String url = "https://jsonplaceholder.typicode.com/todos/23"; // onerilmiyor

        spec.pathParams("first","todos","second",23);

        //2.step : set the expected data

        //3. step : send the request and get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");

        //4. step : do assertion

        //1. yazim sekli
        response.then().assertThat().statusCode(200)
                .contentType("application/json")
                // hard assertion kullanilir - coklu body yazildigi icin
                .body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("completed",equalTo(false))
                .body("userId",equalTo(2));

        //2. yazim sekli
        response.then().assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                // soft assertion kullnilir - tek body icinde yazildigi icin
                .body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")
                ,"completed",equalTo(false)
                ,"userId",equalTo(2));

        /*
            not 1: Assertion yaparken Java calismayi durdurdugunda hata sonra kodlar calismaz.
            boylece hata sonrasi assertion lar hakkinda bilgi sahibi olanayiz
            fakat hata oncesi assertion lar gecmistir

           not 2: Eger kodumuzu hata noktasinda duracak sekilde yazarsak "hard assertion" yapmis oluruz

           Not 3: Eğer kodumuzu hata noktasında duramayacak şekilde yazarsak "soft Assertion" yapmış oluyoruz.

           Not 4: Eğer çoklu body() methodu içinde assert yaparsak "Hard Assert",
           tek body() methodu içinde assert yaparsak "Soft Assert"  yapmış oluyoruz.
        */

    }
}

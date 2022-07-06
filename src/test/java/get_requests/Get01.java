package get_requests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
                            // * yildiz tum hepsini import icin kullanildi
import static io.restassured.RestAssured.*;

public class Get01 {
   /*
    POSTMAN, manuel olarak API testi yapmak için kullanılır.
    API otomasyonda ise REST Assured Library kullanacağız
    REST API kullanmamızın sebebi hem Json hem de Xml olarak kullanılabiliyor olmasıdır.
    Otomasyon kodlarının yazımı için şu adımları izliyoruz;

    a) -->  Gereksinimleri anlama
    b) -->  Test case'leri yazma
    _______ Test case yazımı için Gherkin plugin kullanılacaktır.
    _______ Given, Then, And, But gibi keywodler kullanılacaktır.
    _______ Given (ön koşullar)
    ________ When (aksiyonlar) ->Get,Put,..
    ________ Then (dönütler, doğrulama, response gibi)
    ________ And (çoklu işlemeler için)

    c) -->  Otomasyonda test kodunun yazımı yapılacak
            1) Set the URL (URl'yi kurmak)
            2) Set the expected Data (beklenen datanın oluşturulması)   """POST, PUT PATCH"""
            3) Type code to send request (talep göndermek için kod yazma)
            4) Do Assertion (doğrulama yapma)
 */

    /*

        Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK

     */


    @Test
    public void get01(){
        // 1) Set the URL (URl'yi kurmak)
        String url = "https://restful-booker.herokuapp.com/booking/55";

        // 2) Set the expected Data (beklenen datanın oluşturulması)   """POST, PUT PATCH"""

        // 3) Type code to send request (talep göndermek için kod yazma)
        // given ve digerlrini import etme isleminde * kullandik
        Response response = given().when().get(url);

        response.prettyPrint();
        // yazdirma islemi oldu- ozel method json sinifinda kullanilan islem ama SOUT ile de olur

        // 4) Do Assertion (doğrulama yapma)
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        // Status Code nasil yazdirilir
        System.out.println("status Code : "+ response.statusCode());
        // Content type nasil yazdirilir
        System.out.println("Content type : "+ response.contentType());
        // Status Line nasil yazdirilir
        System.out.println("Status line : "+response.statusLine());
        // Header nasil yazdilir
        System.out.println(response.header("User-Agent"));
        // Headers nasil yazdilir
        System.out.println("Headers: \n "  +response.headers());
        // Time nasil yazdirlir
        System.out.println("Time : "+response.getTime());


        // response.then().assertThat().statusCode(200).contentType("application/xml").statusLine("HTTP/1.1 200 OK");
        // contentType ı xml yapınca
        // java.lang.AssertionError: 1 expectation failed.
        //Expected content-type "application/xml" doesn't match actual content-type "application/json; charset=utf-8".  hatası veriyor


    }



}

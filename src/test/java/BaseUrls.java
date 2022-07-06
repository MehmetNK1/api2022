import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrls {


    public RequestSpecification spec;

    // Before annotation i kullandigimiz medhotlar her Test metodhodundan once kullanilir
    @Before
    public void  setUp(){

        spec = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com/").build();
    }


}

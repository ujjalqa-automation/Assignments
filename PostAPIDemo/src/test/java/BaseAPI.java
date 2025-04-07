import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class BaseAPI {

	@Test
    public void createUser() {
        RestAssured.baseURI ="https://reqres.in"; // Example API
        Map<String, String> payload = new HashMap<>();
        payload.put("name", "Ujjal");
        payload.put("job", "QA Lead");
     Response response=  given()
        .body(payload)
        .when()
        .post("/api/users")
        .then()
        .extract().response();
        System.out.println("User Creation response is::"+response.asPrettyString());
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, 201, "Expected status code 201 but got " + actualStatusCode);  
    }
}

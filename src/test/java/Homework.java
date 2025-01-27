import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Homework {

// Task #1
    @DataProvider(name = "isbn")
    public Object[][] isbnPut() {
        return new Object[][]{
                {"9781449331818"},
                {"9781449337711"},
                {"9781449365035"},
                {"9781491904244"}


        };

    }

    @Test(dataProvider = "isbn")
    public void testIsbnInput(String isbn) {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";

        Response response = RestAssured

                .given()
                .queryParam("ISBN", isbn)
                .when()
                .get("/BookStore/V1/Book")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200, "GetStatusCode");

        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.jsonPath().getString("isbn"),isbn,"ISBN is relevant in response");

    }









}

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework1 {


    @Test
    public void postData() {

        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        LombokData1 userData = new LombokData1();
        userData.setUserName("tat4Test12");
        userData.setPassword("fail");
        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(userData)
                .post("/Account/v1/User")
                .then()
                .log().all()
                .extract().response();

        System.out.println(response.statusCode());
        int statusCode2 = response.getStatusCode();

        Assert.assertEquals(statusCode2, 400, "Check if status code is 400");
        String errorResponse = response.jsonPath().getString("message");
        String Responce = "Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.";
        System.out.println(errorResponse);
        Assert.assertEquals(Responce, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.", "Check error message");
    }
}
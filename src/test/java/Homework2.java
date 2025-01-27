import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework2 {



    @Test
    public void FirstApi1() {

        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        LombokData1 userData = new LombokData1();
        // ერთი იუზერნეიმის მეორედ გაშვებაზე მიწერს რომ უკვე რეგისტრირებულია, ამიტომ თუ მაგალითად ორჯერ გაუშვებ, გთხოვ ერთი სიმბოლო დაუმატო იუზერნეიმში რომ დარეფრეშდეს და 201 სტატუს კოდი შეინარჩუნოს
        userData.setUserName("tat114T2124324e1st12");
        userData.setPassword("Tata418ta1fdsfs3537@");
        Response response1 = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(userData)
                .post("/Account/v1/User")
                .then()
                .log().all()
                .extract().response();
        System.out.println(response1.statusCode());

        int statusCode1 = response1.getStatusCode();
        Assert.assertEquals(statusCode1, 201, "CheckStatusCode1");


        String resultOne = response1.jsonPath().getString("userID");
        System.out.println(resultOne);

        Assert.assertNotNull(response1.jsonPath().get("userID"), "Check if userID is visible in response body");


    }







}

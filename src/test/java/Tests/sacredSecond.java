package Tests;

import Base.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class sacredSecond extends BaseTest {
    String BaseURL = "https://devoutshade.sacredgroves.earth/api";
    String patchToken = "";
    String workbook = "C:\\Users\\hp\\IdeaProjects\\untitled6\\src\\main\\resources\\Patch_Users.xlsx";

   @BeforeClass
    public void User() {
        patchToken = super.PatchUser().jsonPath().getString("data");
    }
    @Test
    public void usersDetails() {
        String url = "https://devoutshade.sacredgroves.earth/api/sutra/cluster";

        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Authorization", "Bearer " + patchToken).
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());

    }
    @Test
    public void GiftSgcs() {
        String url = "https://devoutshade.sacredgroves.earth/api/sutra/gift";
        String requestBody ="{\"email\": \"rishikesh@frugaltestingin.com\", \"quantity\": \"1\",  \"message\": \"First Gift Ever Made\", \"date\":\"11/07/2024\",\"scenario\":\"scenario2\" }";
        System.out.println(requestBody);
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Authorization", "Bearer " + patchToken).
                header("Content-Type","application/json").
                body(requestBody).
                post(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());
        String token = response.jsonPath().getString("data");
        System.out.println(token);
    }
    @Test
    public void Cards () {
        String url = "https://devoutshade.sacredgroves.earth/api/general/cards";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
    }
    @Test
    public void giftAble () {
        String url = "https://devoutshade.sacredgroves.earth/api/sutra/giftable/1";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Authorization", "Bearer " + patchToken).
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
    }

    @Test
    public void getGiftSend() {
        String url = "https://devoutshade.sacredgroves.earth/api/sutra/gift/status";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Authorization", "Bearer " + patchToken).
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
    }
    @Test
    public void paymentSession() {
        String url = "https://devoutshade.sacredgroves.earth/api/payment/session";
        String requestBody ="{\"currency\": \"USD\", \"unit_amount\": 50,  \"name\": \"Get SGC\", \"quantity\":1,\"success_url\":\"https://www.sacredgroves.earth\",\"cancel_url\":\"https://www.sacredgroves.earth\" }";
        System.out.println(requestBody);
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Authorization", "Bearer " + patchToken).
                header("Content-Type","application/json").
                body(requestBody).
                post(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());
        String token = response.jsonPath().getString("data");
        System.out.println(token);
    }

    @Test
    public void updateUserPrivacySettings () {
        String url = "https://devoutshade.sacredgroves.earth/api/users/:type";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Authorization", "Bearer " + patchToken).
                patch(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
        String token = response.jsonPath().getString("data");
        System.out.println(token);
    }
    @Test
    public void squadClusters() {
        String url = "http://devoutshade.sacredgroves.earth/api/sutra/squad/cluster/";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Authorization", "Bearer " + patchToken).
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
    }
    @Test
    public void GetMapsAPI() {
        String url = "https://devoutshade.sacredgroves.earth/api/general/maps/RWA_MASH_00003";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
    }
    @Test
    public void getCountries() {
        String url = "https://devoutshade.sacredgroves.earth/api/general/getCountries";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
        String token = response.jsonPath().getString("data");
        System.out.println(token);
    }
    @Test
    public void getCounties() {
        String url = "https://devoutshade.sacredgroves.earth/api/general/getCities/22";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
        String token = response.jsonPath().getString("data");
        System.out.println(token);
    }
    @Test
    public void getStates() {
        String url = "https://devoutshade.sacredgroves.earth/api/general/getStates/101";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
        String token = response.jsonPath().getString("data");
        System.out.println(token);
    }
    @Test
    public void history() {
        String url = "https://devoutshade.sacredgroves.earth/api/sutra/gift/history";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Authorization", "Bearer " + patchToken).
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
        String token = response.jsonPath().getString("data");
        System.out.println(token);
    }
    @Test
    public void forestclusterdetails() {
        String url = "https://devoutshade.sacredgroves.earth/api/sutra/forest/cluster/details/";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Authorization", "Bearer " + patchToken).
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
        String token = response.jsonPath().getString("data");
        System.out.println(token);
    }
    @Test
    public void forestDetails() {
        String url = "https://devoutshade.sacredgroves.earth/api/sutra/forest/details/CAN_OCEA_00003";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Authorization", "Bearer " + patchToken).
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
        String token = response.jsonPath().getString("data");
        System.out.println(token);

    }
    @Test
    public void getCountry() {
        String url = "http://devoutshade.sacredgroves.earth/api/general/getCountry";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
        String token = response.jsonPath().getString("data");
        System.out.println(token);
    }
    @Test
    public void getState() {
        String url = "https://devoutshade.sacredgroves.earth/api/general/getState/AF";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
        String token = response.jsonPath().getString("data");
        System.out.println(token);
    }
    @Test
    public void getCity() {
        String url = "http://devoutshade.sacredgroves.earth/api/general/getCity/2589581";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
        String token = response.jsonPath().getString("data");
        System.out.println(token);
    }
    @Test
    public void transactionLedger() {
        String url = "https://devoutshade.sacredgroves.earth/api/sutra/transaction/ledger";
        String requestBody ="{\"startDate\": \"2024-01-01\", \"endDate\":\"2024-02-01\" }";
        System.out.println(requestBody);
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Authorization", "Bearer " + patchToken).
                header("Content-Type","application/json").
                body(requestBody).
                post(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());
        String token = response.jsonPath().getString("data");
        System.out.println(token);
    }

}

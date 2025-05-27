package Tests;

import Base.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Cluster_Accounting extends BaseTest {
    String BaseURL = "https://devoutshade.sacredgroves.earth/api";
    String patchToken = "";
    String workbook = "C:\\Users\\hp\\IdeaProjects\\untitled6\\src\\main\\resources\\Patch_Users.xlsx";

//    @BeforeClass
//    public void User() {
//        patchToken = super.PatchUser().jsonPath().getString("data");
//    }

    @Test
    public void clusterStatus(){
        String url ="https://devaccounting.sacredgroves.earth/api/clustermgmt/user/cluster/status";

        String requestBody ="{\"user_id\": \"4e88f847-6608-4c44-b043-be73d89122df\"}";

        Response response=given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Content-Type","application/json").
                body(requestBody).
                post(url);

        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();


        if(!(response.statusCode() == 200))
            Assert.fail("Expected status code is "+200+" but the actual status code is "+response.statusCode());
    }
    @Test
    public void giftingStatus(){
        String url ="https://devaccounting.sacredgroves.earth/api/clustermgmt/user/gifting/status";

        String requestBody ="{\"user_id\": \"4e88f847-6608-4c44-b043-be73d89122df\"}";

        Response response=given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Content-Type","application/json").
                body(requestBody).
                post(url);

        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if(!(response.statusCode() == 200))
            Assert.fail("Expected status code is "+200+" but the actual status code is "+response.statusCode());
    }
    @Test
    public void transactionLedger(){
        String url ="https://devaccounting.sacredgroves.earth/api/clustermgmt/user/transaction/ledger";

        String requestBody ="{\"userId\": \"4e88f847-6608-4c44-b043-be73d89122df\", \"startDate\": \"2024-01-01\",  \"endDate\": \"2024-06-01\"}";

        Response response=given().header("Content-Type","application/json").body(requestBody).post(url);

        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if(!(response.statusCode() == 200))
            Assert.fail("Expected status code is "+200+" but the actual status code is "+response.statusCode());
    }
    @Test
    public void CheckGiftingEligibility(){
        String url ="https://devaccounting.sacredgroves.earth/api/clustermgmt/eligible/gifting/stored/process";

        String requestBody ="{\"userId\": \"4e88f847-6608-4c44-b043-be73d89122df\", \"requestedSgc\": \"202\"}";

        Response response=given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Content-Type","application/json").
                body(requestBody).
                post(url);

        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if(!(response.statusCode() == 200))
            Assert.fail("Expected status code is "+200+" but the actual status code is "+response.statusCode());
    }

    @Test
    public void HoldingsLedger(){
        String url ="https://devaccounting.sacredgroves.earth/api/clustermgmt/user/cluster/holdings";

        String requestBody ="{\"userId\": \"4e88f847-6608-4c44-b043-be73d89122df\" ,\"forestId\": \"UNI_GIGR_00001\"}";

        Response response=given().
                contentType(ContentType.JSON).
                accept("application/json").
                contentType(ContentType.JSON).
                body(requestBody).
                post(url);

        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() ==200))
            Assert.fail("Expected status code is "+200+"but the actual status code is"+response.statusCode());
    }
}

package Tests;

import Utils.TestDataExtractor;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;



public class Sacred_Analytics {
    String workbook = new File("src/main/resources/Sacred_Analytics.xlsx").getAbsolutePath();
    @DataProvider(name = "postReq")
    public Object[][] postReq(){
        return TestDataExtractor.ExcelData(workbook,"postReq");
    }

    @Test(dataProvider = "postReq")
    public void POST(String APIname,String api,String body_key1,String body_val1,String body_key2,String body_val2,String body_key3,String body_val3,String body_key4,String body_val4,String body_key5,String body_val5,String body_key6,String body_val6,String body_key7,String body_val7,String body_key8,String body_val8,String body_key9,String body_val9,String body_key10,String body_val10,String body_key11,String body_val11){
        // "{\"" + bodyKey1 + "\": " + bodyValue1 + ", \"" + bodyKey2 + "\": " + bodyValue2 + ", \"" + bodyKey3 + "\": " + bodyValue3 + "}";
        String postBody="{\"";
        if(body_key1!="" && body_val1!="") postBody+=body_key1+"\":"+body_val1 ;
        if(body_key2!="" && body_val2!="") postBody+=",\""+body_key2+"\":"+body_val2 ;
        if(body_key3!="" && body_val3!="") postBody+=",\""+body_key3+"\":"+body_val3 ;
        if(body_key4!="" && body_val4!="") postBody+=",\""+body_key4+"\":"+body_val4 ;
        if(body_key5!="" && body_val5!="") postBody+=",\""+body_key5+"\":"+body_val5 ;
        if(body_key6!="" && body_val6!="") postBody+=",\""+body_key6+"\":"+body_val6 ;
        if(body_key7!="" && body_val7!="") postBody+=",\""+body_key7+"\":"+body_val7 ;
        if(body_key8!="" && body_val8!="") postBody+=",\""+body_key8+"\":"+body_val8 ;
        if(body_key9!="" && body_val9!="") postBody+=",\""+body_key9+"\":"+body_val9 ;
        if(body_key10!="" && body_val10!="") postBody+=",\""+body_key10+"\":"+body_val10 ;
        if(body_key11!="" && body_val11!="") postBody+=",\""+body_key11+"\":"+body_val11 ;
        postBody+="}";
        System.out.println(postBody);
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Content-Type", "application/json").
                body(postBody).post(api);
        System.out.println(response.statusCode());
        response.then().log().all();

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);

    }
    @Test
    public void Users(){
        String url ="https://devanalytics.sacredgroves.earth/api/clustermgmt/weather/details/view/";

//        System.out.println(email+password);

        String requestBody = "{\"forest_id\": \"CAN_OCEA_00003\",\"page_number\": 1 }";


        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Content-Type", "application/json").
                body(requestBody).
                post(url);

        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();


        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is "+200+" but the actual status code is "+response.statusCode());


    }
    @Test
    public void Use(){
        String url ="https://devanalytics.sacredgroves.earth/api/clustermgmt/weather/details/view/";


        String requestBody = "{\"forest_id\": \"UNI_GIGR_00001\",\"page_number\": 1 }";


        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Content-Type","application/json").
                body(requestBody).
                post(url);

        System.out.println(response.statusCode());
        response.then().log().all();
//        System.out.println(response.getBody().asString());
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);

//        if (!(response.statusCode() == 200))
//            Assert.fail("Expected status code is "+200+" but the actual status code is "+response.statusCode());


    }

    @Test
    public void Used(){
        String url ="https://devanalytics.sacredgroves.earth/api/clustermgmt/weather/details/view/";


        String requestBody = "{\"forest_id\": \"UNI_COED_00002\",\"page_number\": 1 }";

        Response response =given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Content-Type","application/json").
                body(requestBody).
                post(url);

        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();

        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is "+200+" but the actual status code is "+response.statusCode());


    }
    @Test
    public void cluster_ownership_details_by_forest(){
      String url ="https://devanalytics.sacredgroves.earth/api/clustermgmt/forest/cluster/view/by/ids/";

        String requestBody ="{\"ownership_id\": \"0067e96f-2f47-4d8f-864a-0906d54173ad\",\"page_number\": 1}";

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
    public void All_forest_details(){
        String url ="https://devanalytics.sacredgroves.earth/api/clustermgmt/forest/details/view/";

        String requestBody ="{\"page_number\": 1}";

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
    public void TotalClustersListOfGuardians(){
        String url ="https://devanalytics.sacredgroves.earth/api/clustermgmt/cluster/bulk/view/by/ids/";

        String requestBody ="{\"ownership_id\": [\"0067e96f-2f47-4d8f-864a-0906d54173ad\",\"e637f040-5b32-460f-86c5-1f8a594d7adc\"], \"page_number\": 1}";

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
    public void OwnershipDetails(){
        String url ="https://devanalytics.sacredgroves.earth/api/clustermgmt/cluster/view/by/ids/";

        String requestBody ="{\"ownership_id\": [\"0067e96f-2f47-4d8f-864a-0906d54173ad\"], \"page_number\": 1}";

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
    public void BestAQIDetails (){
        String url ="https://devanalytics.sacredgroves.earth/api/clustermgmt/global/best/aqi/details/view/";

        String responseBody ="{\"top_country\":11 }";
        Response response=given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Content-Type","application/json").
                body(responseBody).
                post(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if(!(response.statusCode() == 200))
            Assert.fail("Expected Status code is "+200+" but the actual status Code is"+response.statusCode());

    }
    @Test
    public void WorstAQIDetails (){
        String url ="https://devanalytics.sacredgroves.earth/api/clustermgmt/global/worst/aqi/details/view/";

        String responseBody ="{\"top_country\":11 }";
        Response response=given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Content-Type","application/json").
                body(responseBody).
                post(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if(!(response.statusCode() == 200))
            Assert.fail("Expected Status code is "+200+" but the actual status Code is"+response.statusCode());

    }

    @Test
    public void AvailableClusters () {
        String url = "https://devanalytics.sacredgroves.earth/api/clustermgmt/available/clusters/details/";
        Response response = given()
                .get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected Status code is " + 200 + " but the actual status Code is" + response.statusCode());
    }

    @Test
    public void GlobalIndicator () {
        String url = "https://devanalytics.sacredgroves.earth/api/clustermgmt/global/indicator/details/view/";
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

    @DataProvider(name = "TotalClustersGuard")
    public Object[][]
    TotalClustersGuard(){
        return TestDataExtractor.ExcelData(workbook,"TotalClustersGuard");
    }

    @Test(dataProvider = "TotalClustersGuard")
    public void TotalClustersGuard(String ownership_id, String Number) {
        String url = "https://devanalytics.sacredgroves.earth/api/clustermgmt/cluster/bulk/view/by/ids/";

        String requestBody = "{\"ownership_id\": \""+ownership_id+"\", \"page_number\": \""+Number+"\"}";
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
}

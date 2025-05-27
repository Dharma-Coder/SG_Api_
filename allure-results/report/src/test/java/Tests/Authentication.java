package Tests;

import Base.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Authentication extends BaseTest {
    String BaseURL = "https://devoutshade.sacredgroves.earth/api";
    String patchToken = "";
    String workbook = new File("src/main/resources/Patch_Users.xlsx").getAbsolutePath();
//    @BeforeClass
//    public void User() {
//        patchToken = super.PatchUser().jsonPath().getString("data");
//    }
   @Test
    public void SendOtp(){
    String url ="https://devoutshade.sacredgroves.earth/api/users/sendOtpV2";

    String requestBody ="{\"country_code\": \"91\",\"phone_number\": \"8850119211\",\"newUser\": \"true\" ,\"ip_address\": \"\"  }";

    Response response=
                    given().
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
    String token = response.jsonPath().getString("data");
    System.out.println(token);
       response.then().log().all();
       response.prettyPrint();

   }
    @Test
    public void VerifyOtp(){
        String url ="https://devoutshade.sacredgroves.earth/api/users/verifyOtp";

        String requestBody ="{\"country_code\": \"91\",\"phone_number\": \"8850119211\",\"newUser\": \"true\" ,\"code\": \"1234\"  }";

        Response response=given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Content-Type","application/json").body(requestBody).post(url);

        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if(!(response.statusCode() == 200))
            Assert.fail("Expected status code is "+200+" but the actual status code is "+response.statusCode());
        String token = response.jsonPath().getString("data");
        System.out.println(token);
        response.then().log().all();

    }

}

package Base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;;

import static io.restassured.RestAssured.given;

public class BaseTest {

    public Response getToken() {
        String Base_URL ="https://devoutshade.sacredgroves.earth/api/admins";
        String path ="/login";

        String requestBody = "{\"user_id\": \"Admin\", \"password\": \"Founders@1MillionAcres\"}";

        System.out.println(requestBody);

        Response response = given().contentType(ContentType.JSON).body(requestBody).post(Base_URL+path);

        System.out.println(response.statusCode());
        response.prettyPrint();
        response.then().log().all();

        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is "+200+" but the actual status code is "+response.statusCode());

        String token = response.jsonPath().getString("data");
        System.out.println(token);
        response.then().log().all();
        return response;
    }



    public Response PatchUser() {
        String Patch_URL ="https://devoutshade.sacredgroves.earth/api/users";
        String path ="/login";

        String requestBody = "{\"email_phone\": \"praveenpotla@frugaltestingin.com\", \"password\": \"Frugal@123\"}";

        System.out.println(requestBody);

        Response response = given().contentType(ContentType.JSON).body(requestBody).post(Patch_URL+path);

        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();

        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is "+200+" but the actual status code is "+response.statusCode());

        String token = response.jsonPath().getString("data");
        System.out.println(token);
        response.then().log().all();
        return response;
    }

}

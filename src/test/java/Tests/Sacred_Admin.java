package Tests;

import Base.BaseTest;
import SheetAdmin.admin_DEL;
import SheetAdmin.admin_GET;
import SheetAdmin.admin_POST;
import SheetAdmin.admin_post_Invite;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Sacred_Admin extends BaseTest {
    String TOKEN;
    String BaseURL = "https://devoutshade.sacredgroves.earth/api/admins";


    @BeforeClass
    public void Token() {
        TOKEN = super.getToken().jsonPath().getString("data");
    }

    @Test
    public void AdminLogin() {

        System.out.println(TOKEN);

    }


    @Test
    public void GetAllUsers() {
        String path = "/users";

        Response response = given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(BaseURL + path);
        System.out.println(response.statusCode());
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());

    }


    @Test(dataProvider = "adminInvite")
    public void POST_Send_Invite() {
        String path = "/invite";

        String requestBody = "{\"email\":[\"amitthakurashwani@gmail.com\" ,\"amit@outshade.com\"]}";

        System.out.println(requestBody);

        Response response = given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(BaseURL + path);
        System.out.println(response.statusCode());
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);

    }
    @Test
    public void Delete_User()
    {
        String path = "/user/{id}";
        String user_id = "586717a0-2370-4590-9882-d66335cc27fe";
        Response response = given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParams("id",user_id)
                .delete(BaseURL + path);
        System.out.println(response.statusCode());
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void GetAllUsersWithAmount() {
        String path = "/users/3/0";

        Response response = given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(BaseURL + path);
        System.out.println(response.statusCode());
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());

    }
    @Test
    public void GetParticularUserDetails() {
        String path = "/user/{id}";
        String user_id = "ae46383c-8e83-4bac-8968-2078f648db47";
        Response response = given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParams("id",user_id)
                .get(BaseURL + path);
        System.out.println(response.statusCode());
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());

    }

    @Test
    public void activities() {
        String path = "/activities";
        Response response = given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(BaseURL + path);
        System.out.println(response.statusCode());
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());

    }

    @Test
    public void Squads() {
        String path = "/squads";
        Response response = given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(BaseURL + path);
        System.out.println(response.statusCode());
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());

    }
    @Test
    public void grovepoints() {
        String path = "/grovepoints";
        Response response = given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(BaseURL + path);
        System.out.println(response.statusCode());
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());

    }
    @DataProvider(name = "getCall")
    public Object[][] getCall() {
        Object[][] getCall = admin_GET.ExcelData();
        return getCall;
    }


    @DataProvider(name = "adminPostCall")
    public Object[][] adminPostCall() {
        Object[][] adminPostCall = admin_POST.ExcelData();
        return adminPostCall;
    }

    @DataProvider(name = "adminInvite")
    public Object[][] adminInvite() {
        Object[][] POST_Send_Invite = admin_post_Invite.ExcelData();
        return POST_Send_Invite;
    }
    @DataProvider(name = "adminDelete")
    public Object[][] adminDelete() {
        Object[][] Delete_User = admin_DEL.ExcelData();
        return Delete_User;
    }

}

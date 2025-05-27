package Tests;

import Base.BaseTest;
import Utils.TestDataExtractor;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Patch_Users extends BaseTest {
    String BaseURL = "https://devoutshade.sacredgroves.earth/api";
    String patchToken = "";
    String workbook = new File("src/main/resources/Patch_Users.xlsx").getAbsolutePath();

    @BeforeClass
    public void User() {
        patchToken = super.PatchUser().jsonPath().getString("data");
    }

    @Test
    public void usersDetails() {
        String path = "/users";

        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Authorization", "Bearer " + patchToken)
                .get(BaseURL + path);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());

    }


    @DataProvider(name = "Users")
    public Object[][]
    Users() {
        return TestDataExtractor.ExcelData(workbook, "Users");
    }

    @Test(dataProvider = "Users")
    public void Users(String email, String password) {
        String url = "https://devoutshade.sacredgroves.earth/api/users/login";

//        System.out.println(email+password);

        String requestBody = "{\"email_phone\": \"" + email + "\", \"password\": \"" + password + "\"}";

        System.out.println(requestBody);

        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                contentType(ContentType.JSON).body(requestBody).post(url);

        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();

        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());


    }

    @Test
    public void GetUserDetails() {
        String url = "https://devoutshade.sacredgroves.earth/api/users/";
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
    public void GetUserType() {
        String url = "https://devoutshade.sacredgroves.earth/api/users/type";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());
    }

    @Test
    public void GetUserLevel() {
        String url = "https://devoutshade.sacredgroves.earth/api/users/level";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Content-Type", "application/json")
                .param("score", 158)
                .get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());
    }

    @Test
    public void GetUserInterests() {
        String url = "https://devoutshade.sacredgroves.earth/api/users/interests";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());
    }

    @Test
    public void GetUserActivities() {
        String url = "https://devoutshade.sacredgroves.earth/api/users/activities";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());
    }

    @Test
    public void GetAllUserData() {
        String url = "https://devoutshade.sacredgroves.earth/api/users/get-all-users";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());
    }

    @Test
    public void GetUserLevels() {
        String url = "https://devoutshade.sacredgroves.earth/api/users/getUserLevels";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());
    }

    @Test
    public void GetUserHistory() {
        String url = "https://devoutshade.sacredgroves.earth/api/users/score/history";
        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Authorization", "Bearer " + patchToken).get(url);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());

    }

    @Test
    public void GetUser() {
        String url = "https://devoutshade.sacredgroves.earth/api/users/";
        String iD = "0067e96f-2f47-4d8f-864a-0906d54173ad";

        Response response = given().
                contentType(ContentType.JSON).
                accept("application/json").
                header("Authorization", "Bearer " + patchToken)
                .get(url + iD);
        System.out.println(response.statusCode());
        response.then().log().all();
        response.prettyPrint();
        if (!(response.statusCode() == 200))
            Assert.fail("Expected status code is " + 200 + " but the actual status code is " + response.statusCode());
        String token = response.jsonPath().getString("data");
        System.out.println(token);
    }
}

package Tests;

import Base.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class SacredGroves_Sutra_APIs extends BaseTest {
    String BaseURL = "https://devoutshade.sacredgroves.earth/api";
    String patchToken = "";
    String workbook = "C:\\Users\\hp\\IdeaProjects\\untitled6\\src\\main\\resources\\Patch_Users.xlsx";

    @BeforeClass
    public void User() {
        patchToken = super.PatchUser().jsonPath().getString("data");
    }

    @Test
    public void clusterDetails() {
        String  url = "https://devoutshade.sacredgroves.earth/api/sutra/cluster/details";

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
        String token = response.jsonPath().getString("data");
        System.out.println(token);
    }
    @Test
    public void clusterTrend() {
        String  url = "https://devoutshade.sacredgroves.earth/api/sutra/forest/cluster/trend/";

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
        String token = response.jsonPath().getString("data");
        System.out.println(token);
    }
    @Test
    public void powerBi() {
        String url = "https://devoutshade.sacredgroves.earth/api/sutra/powerbi";
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
    public void mapCluster() {
        String url = "https://devoutshade.sacredgroves.earth/api/sutra/map/cluster?forestId=UNI_GIGR_00001&iframe_height=250&iframe_width=450&zoom_start=17";
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
    public void sutraMapForest() {
        String url = "https://devoutshade.sacredgroves.earth/api/sutra/map/forest?forestId=UNI_GIGR_00001&iframe_height=250&iframe_width=450&zoom_start=17";
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
}

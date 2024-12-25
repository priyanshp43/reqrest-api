package in.reqres.reqres;

import in.reqres.model.ReqResPojo;
import in.reqres.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ReqResGetTest extends TestBase {

    @Test
    public void getAllReqResInfo(){
        Response response = given()
                .when()
                .get("/users?page=2");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void getSingleReqResInfo(){
        Response response = given()
                .when()
                .get("/users/2");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void getListUsers(){
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .get("/users?page=2");
        response.prettyPrint();
        // response.then().statusCode(200);

        assertEquals(200,response.getStatusCode(),"Expected status code is 200");

        int page = response.jsonPath().getInt("page");
        assertEquals(page, 2, "Expected page is 2");

        int perPage = response.jsonPath().getInt("per_page");
        assertEquals(perPage, 6, "Expected per_page is 6");

        int dataId = response.jsonPath().getInt("data[1].id");
        assertEquals(dataId, 8, "Expected data[1].id is 8");

        String firstName = response.jsonPath().getString("data[3].first_name");
        assertEquals(firstName, "Byron", "Expected data[3].first_name is Byron");

        int dataSize = response.jsonPath().getList("data").size();
        assertEquals(dataSize, 6, "Expected list of data size is 6");

        String avatar = response.jsonPath().getString("data[4].avatar");
        assertEquals(avatar, "https://reqres.in/img/faces/11-image.jpg", "Expected data[4].avatar is correct");

        // Print confirmation
        System.out.println("All validations passed successfully.");
    }

}

package in.reqres.reqres;

import in.reqres.model.ReqResPojo;
import in.reqres.testbase.TestBase;
import in.reqres.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqResPostTest extends TestBase {

    @Test
    public void createReqRes(){
        String email = TestUtils.getRandomValue() + "uviip@gmail.com";
        ReqResPojo reqResPojo = new ReqResPojo();
        reqResPojo.setFirst_name("Niyati");
        reqResPojo.setJob("Tester");
        reqResPojo.setId(726);
        reqResPojo.setEmail(email);
        reqResPojo.setLast_name("Patel");
        reqResPojo.setAvatar("https://reqres.in/img/faces/8-image.jpg");

        Response response = given().log().all()
                //.header("Content-Type", "application/json")
                .when()
                .body(reqResPojo)
                .post("/users");
        response.prettyPrint();
        response.then().statusCode(201);
    }
    @Test
    public void PostLoginSuccess(){
        String email = TestUtils.getRandomValue() + "uviip@gmail.com";
        ReqResPojo reqResPojo = new ReqResPojo();
        reqResPojo.setEmail("eve.holt@reqres.in");
        reqResPojo.setPassword("cityslicka");

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                //.when()
                .body(reqResPojo)
                .post("/login");
        response.prettyPrint();
        response.then().statusCode(200);


    }
}

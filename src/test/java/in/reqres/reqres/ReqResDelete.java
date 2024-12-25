package in.reqres.reqres;

import in.reqres.testbase.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqResDelete extends TestBase {
    @Test
    public void ReqResDelete(){
        given().log().all()
                .when()
                .delete("/users/2")
                .then().log().all()
                .statusCode(204);

    }

}

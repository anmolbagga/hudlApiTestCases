package hudlApiTest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDeleteEventHttpDelete {
	@BeforeTest
	public void setup(){
		
		RestAssured.baseURI = "https://www.hudl.com/api/v2";
		RestAssured.basePath = "/teams/320073/seasons/737668/entries";
	}

	@Test
	public void testDelete(){
		given()
		.when()
		.delete("/9564734")
		.then()
		.statusCode(204);
	}
}




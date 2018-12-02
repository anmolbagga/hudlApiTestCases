package hudlApiTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCreateEventHttpPost {

	String InitialbaseURI = "https://www.hudl.com/api/v2/teams";

	@Test
	/*
	 * expected response 200 Successful response received
	 */
	public void CreateEventSuccessful(String url , int seasonId, int teamId)
	{ 
	 RestAssured.baseURI = InitialbaseURI;
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
	 request.body(requestParams.toJSONString());
	 Response response = request.post("/"+teamId+"/"+seasonId+"/entries");
	 
	 int statusCode = response.getStatusCode();
	 Assert.assertEquals(statusCode, "201");
	 String successCode = response.jsonPath().get("SuccessCode");
	 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}

	

}

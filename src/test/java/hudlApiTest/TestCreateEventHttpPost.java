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
	 Assert.assertEquals(statusCode, "200");
	 String successCode = response.jsonPath().get("SuccessCode");
	 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}
	
	@Test
	/*
	 * expected response 403 when wrong team id is passed
	 */
	public void CreateEventUnSuccessful(String url , int seasonId, int teamId)
	{ 
	 RestAssured.baseURI = InitialbaseURI;
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
	 request.body(requestParams.toJSONString());
	 Response response = request.post("/"+teamId+"/"+seasonId+"/entries");
	 
	 int statusCode = response.getStatusCode();
	 Assert.assertEquals(statusCode, "403");
	 String successCode = response.jsonPath().get("message");
	 Assert.assertEquals( "Internal Server Error", successCode, "code is 403 when wrong team is passed");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	/*
	 * expected response 500 when wrong paramin body is passed for example time 30:00 hours
	 */
	public void CreateEventUnSuccessfulCheck500InternalServerError(String url , int seasonId, int teamId)
	{ 
	 RestAssured.baseURI = InitialbaseURI;
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("time", "30:00am"); // Cast
	 request.body(requestParams.toJSONString());
	 Response response = request.post("/"+teamId+"/"+seasonId+"/entries");
	 
	 int statusCode = response.getStatusCode();
	 Assert.assertEquals(statusCode, "500");
	 String successCode = response.jsonPath().get("message");
	 Assert.assertEquals( "Internal Server Error", successCode, "code is 500 when wrong param in body is passed");
	}

	

}

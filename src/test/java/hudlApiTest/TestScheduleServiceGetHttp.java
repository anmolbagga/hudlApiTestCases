package hudlApiTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestScheduleServiceGetHttp {

	String InitialbaseURI = "https://www.hudl.com/api/v2/";

	@Test
	/*
	 * expected response 200 Successful response recieved
	 */
	public void GetScheduleServiceTest(String url, int teamID) {
		// Specify the base URL to the RESTful web service
		// use the param url to create the full service URL
		RestAssured.baseURI = InitialbaseURI + url;

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method
		// URL.
		// This will return the Response from the server. Store the response in a
		// variable.
		Response response = httpRequest.request(Method.GET, "/" + teamID);

		// Now let us print the body of the message to see what response
		// we have received from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		Assert.assertTrue(response.getStatusCode() == 200);
	}

	@Test
	/*
	 * expected response 403 when wrong url is used
	 */
	public void GetScheduleServiceTestWrongUrl(String url, int teamID) {
		// Specify the base URL to the RESTful web service
		// use the param url to create the full service URL
		RestAssured.baseURI = InitialbaseURI + url + "wrong url";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method
		// URL.
		// This will return the Response from the server. Store the response in a
		// variable.
		Response response = httpRequest.request(Method.GET, "/" + teamID);

		// Now let us print the body of the message to see what response
		// we have received from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		Assert.assertTrue(response.getStatusCode() == 403);
	}

	@Test
	/*
	 * expected response 404 when team id is not sent
	 */
	public void GetScheduleServiceTestTeamIdNtSent(String url, int teamID) {
		// Specify the base URL to the RESTful web service
		// use the param url to create the full service URL
		RestAssured.baseURI = InitialbaseURI + url + "wrong url";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method
		// URL.
		// This will return the Response from the server. Store the response in a
		// variable.
		Response response = httpRequest.request(Method.GET, "/" + teamID);

		// Now let us print the body of the message to see what response
		// we have received from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		Assert.assertTrue(response.getStatusCode() == 404);
	}

}

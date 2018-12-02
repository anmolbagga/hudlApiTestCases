package hudlApiTest;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestEditEventHttpPut {
	@BeforeTest
	public void setup(){
		
		RestAssured.baseURI = "https://www.hudl.com/api/v2";
		RestAssured.basePath = "/teams";
	}

	@Test
	public void testDelete(){
		String body = "{\"gameType\":1,\"isNew\":false,\"teamId\":\"320073\",\"seasonId\":\"737668\",\"gameId\":\"10723294\",\"opponentId\":161139,\"opponentSchoolAbbreviation\":\"SDCC\",\"time\":\"12-10-2018 16:00:00\",\"hasScore\":false,\"isHome\":null,\"isTie\":false,\"opponent\":\"San Diego Community College\",\"opponentAccountStatus\":2,\"convertTimeToLocal\":true,\"teamName\":\"Boys' Soccer\",\"schoolName\":\"San Diego Community College\",\"schoolCity\":\"San Diego\",\"schoolState\":\"CA\",\"timeUtc\":\"2018-12-10T16:00:00.000Z\",\"entryDate\":\"12/10/2018\",\"entryTime\":\"16:00\",\"practices\":[],\"isSelected\":true,\"originalOpponent\":\"San Diego City\",\"originalOpponentId\":\"161139\",\"schoolId\":0,\"lastSearchQuery\":\"San Diego Community College\",\"location\":2,\"score1\":\"\",\"score2\":\"\",\"changedOpponent\":true,\"isUsingCommunitySearch\":true}";
		
		given()
		.contentType("application/json")
		.body(body)
		.when()
		.put("/320073/seasons/737668/entries")
		.then()
		.statusCode(200);
	}
}




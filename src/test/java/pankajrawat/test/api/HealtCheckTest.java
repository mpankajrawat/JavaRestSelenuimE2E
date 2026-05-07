package pankajrawat.test.api;

import org.testng.annotations.Test;

import pankajrawat.testUtils.api.BaseApiTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class HealtCheckTest extends BaseApiTest{
	
	@Test
	public void healthCheck() {
		
		given().
		when().spec(spec).
			get("ping").
		then().
			assertThat().statusCode(201);
	}

}

package pankajrawat.test.api;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pankajrawat.testUtils.api.BaseApiTest;

public class CreateBookingTest extends BaseApiTest {

	@Test
	public void createBookingTest() {
		
		Response response = createBooking();
		
Assert.assertEquals(response.getStatusCode(), 200);
		
		String firstName = response.jsonPath().getString("firstname");
		Assert.assertEquals(firstName, "Eric");
		
		String lastname = response.jsonPath().getString("firstname");
		Assert.assertEquals(lastname, "Eric");
		
		int totalprice = response.jsonPath().getInt("firstname");
		Assert.assertEquals(totalprice, "Eric");
		
		boolean depositpaid = response.jsonPath().getBoolean("firstname");
		Assert.assertEquals(depositpaid, "Eric");
		
		String bookingdates = response.jsonPath().getString("bookingdates.checkin");
		Assert.assertEquals(bookingdates, "Eric");
		

	}

	
}

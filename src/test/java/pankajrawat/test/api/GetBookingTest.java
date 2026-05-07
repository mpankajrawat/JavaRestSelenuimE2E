package pankajrawat.test.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pankajrawat.testUtils.api.BaseApiTest;

public class GetBookingTest extends BaseApiTest{

	@Test
	public void getBookingByIdTest() {
		
		Response response = RestAssured.given(spec).get("booking/1");
		response.prettyPrint();
		
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

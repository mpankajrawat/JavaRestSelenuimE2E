package pankajrawat.test.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pankajrawat.testUtils.api.BaseApiTest;

public class DeleteBookingTest extends BaseApiTest {

	@Test
	public void deleteBookingTest() {
		
		Response createResponse = createBooking();
		int bookingId = createResponse.jsonPath().getInt("bookingid");
		
		Response deleteBookingResponse = RestAssured.given(spec).auth().preemptive().basic("admin", "password123").contentType(ContentType.JSON).
											delete("booking/"+bookingId);
		
		int statusCode = deleteBookingResponse.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		
		
	}
}

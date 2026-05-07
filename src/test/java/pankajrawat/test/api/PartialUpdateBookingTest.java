package pankajrawat.test.api;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pankajrawat.testUtils.api.BaseApiTest;

public class PartialUpdateBookingTest extends BaseApiTest {

	@Test
	public void partialUpdateBookingTest() {
		
		Response createBookingResponse =  createBooking();
		int id = createBookingResponse.jsonPath().getInt("bookingid");
		
		JSONObject body = new JSONObject();
		body.put("firstname", "Updated");
		body.put("totalprice", 500);
		
		Response updateBookingTestResponse = RestAssured.
									given(spec).auth().preemptive().basic("admin", "password123").contentType(ContentType.JSON).body(body.toString()).
									patch("booking/"+id);
		
		updateBookingTestResponse.prettyPrint();
		
		String firstname = updateBookingTestResponse.jsonPath().getString("firstname");
		
		int totalprice = updateBookingTestResponse.jsonPath().getInt("totalprice");
		
		Assert.assertEquals(firstname, "Updated");
		Assert.assertEquals(totalprice, 500);
		
		
	}
}

package pankajrawat.test.api;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pankajrawat.testUtils.api.BaseApiTest;

public class UpdateBookingTest extends BaseApiTest {

	@Test
	public void updateBookingTest() {
		
		Response createBookingResponse = createBooking();
		
		int bookingId = createBookingResponse.jsonPath().getInt("bookingid");
		
		JSONObject body = new JSONObject();
		body.put("firstname", "pankaj");
		body.put("lastname", "rawat");
		body.put("totalprice", "120");
		body.put("depositpaid", true);
		body.put("additionalneeds", "nothing");
		
		JSONObject bookingdates = new JSONObject();
		bookingdates.put("checkin", "2010-10-10");
		bookingdates.put("checkout", "2011-11-11");
		
		body.put("bookingdates", bookingdates);
		
		Response updateBookingResponse = RestAssured.
				given(spec).auth().preemptive().basic("admin", "password123").
					contentType(ContentType.JSON).body(body.toString()).
				put("booking/"+bookingId);
		updateBookingResponse.prettyPrint();
		
		String firstName = updateBookingResponse.jsonPath().getString("firstname");
		Assert.assertEquals(firstName, "pankaj");
		
		String lastname = updateBookingResponse.jsonPath().getString("lastname");
		Assert.assertEquals(lastname, "rawat");
		
		int totalprice = updateBookingResponse.jsonPath().getInt("totalprice");
		Assert.assertEquals(totalprice, 120);
		
		boolean depositpaid = updateBookingResponse.jsonPath().getBoolean("depositpaid");
		Assert.assertEquals(depositpaid, true);
		
		String bookingdate = updateBookingResponse.jsonPath().getString("bookingdates.checkin");
		Assert.assertEquals(bookingdate, "2010-10-10");
	}

}

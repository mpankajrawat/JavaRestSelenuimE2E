package pankajrawat.test.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pankajrawat.testUtils.api.BaseApiTest;

public class GetAllBookingIdsTests extends BaseApiTest{

	@Test
	public void getAllBookingIdsWithoutFilter() {
		Response response = RestAssured.given(spec).get("https://restful-booker.herokuapp.com/booking");
		response.print();
		
		List<Integer> IdsList = new ArrayList<>();
		IdsList = response.jsonPath().getList("bookingid");
		
		Assert.assertEquals(response.getStatusCode(), 200, "Expected status code: 200. Actual status code: "+response.getStatusCode());
		Assert.assertFalse(IdsList.isEmpty(),"Booking IDs list received is empty.");
		System.out.println(IdsList);
	}
}

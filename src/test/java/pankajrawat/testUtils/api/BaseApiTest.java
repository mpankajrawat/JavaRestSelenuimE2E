package pankajrawat.testUtils.api;

import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pankajrawat.testUtils.BaseTest;

public class BaseApiTest extends BaseTest{
	
	protected RequestSpecification spec;
	
	@BeforeMethod
	protected void setUp() {
		spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com/").build();
	}

	protected Response createBooking() {
		JSONObject body = new JSONObject();
		body.put("firstname", "pankaj");
		body.put("lastname", "rawat");
		body.put("totalprice", "1234");
		body.put("depositpaid", "0000");
		body.put("additionalneeds", "breakfast");
		
		JSONObject bookingdates = new JSONObject();
		bookingdates.put("checkin", "2018-01-01");
		bookingdates.put("checkout", "2019-01-01");
		
		body.put("bookingdates", bookingdates);
		
		Response response = RestAssured.given(spec).contentType(ContentType.JSON).body(body.toString()).
				post("booking");
		response.prettyPrint();
		return response;
	}
}

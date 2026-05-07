package pankajrawat.test.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import pankajrawat.api.pojoClasses.DummyReqPojo;
import pankajrawat.api.pojoClasses.DummyResPojo;
import pankajrawat.api.specFiles.DummyReqSpecBuilder;
import pankajrawat.api.specFiles.DummyResSpecBuilder;

public class DumyPostReqTest {

	@Test
	public void dummyTest() {
		
		DummyReqPojo reqBody = new DummyReqPojo();
		reqBody.setBody("Learning API");
		reqBody.setTitle("Test");
		reqBody.setUserId(1);
		
		Response res = given().spec(DummyReqSpecBuilder.getRequestSpec()).log().all().body(reqBody)
				.when().post("/posts");
		
		res.then().spec(DummyResSpecBuilder.getResponseSpec()).log().all();
		
		DummyResPojo respBody = res.as(DummyResPojo.class);
		
//		Commenting these as the response only returns ID sometimes
		Assert.assertEquals(respBody.getTitle(), "Test"); 
		Assert.assertEquals(respBody.getBody(), "Learning API");
		Assert.assertEquals(respBody.getUserId(), 1);
		Assert.assertEquals(respBody.getId(), 101);
	}
}

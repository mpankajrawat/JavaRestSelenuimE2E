package pankajrawat.api.specFiles;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class DummyReqSpecBuilder {

	public static RequestSpecification getRequestSpec() {
		
		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").setContentType(ContentType.JSON).build();
		
		return reqSpec;
	}
}

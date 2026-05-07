package pankajrawat.api.specFiles;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class DummyResSpecBuilder {
	
	public static ResponseSpecification getResponseSpec() {
		ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(201).build();
		
		return resSpec;
		
	}

}

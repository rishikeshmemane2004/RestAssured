package com.student.requests;

import static io.restassured.RestAssured.given;

import com.student.specs.SpecificationFactory;
import com.student.tests.TestBase;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestClient extends TestBase{

	public Response doGetRequest(String requestPath)
	{
		return given()
			    .when()
		        .get("/list");
	}
	
	public Response doPostRequest(String uri, Object body)
	{
		return given()
				.contentType(ContentType.JSON)
				.spec(SpecificationFactory.logPayloadResponseInfo())
				.when()
				.body(body)
				.post(uri);	
	}
	
	public Response doDeleteResponse(String res)
	{
		return given()
				.when()
				.delete(res);		
	}
	public Response doPatchResponse(String res, Object body)
	{
		return given()
				.contentType(ContentType.JSON)
				.when()
				.body(body)
				.patch(res);		
	}
}

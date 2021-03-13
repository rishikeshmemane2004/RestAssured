package com.student.requests;

import static io.restassured.RestAssured.given;

import java.util.List;

import com.student.pojo.StudentClass;
import com.student.tests.TestBase;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class RequestFactory extends TestBase{

	RestClient restClient = new RestClient();
	
	@Step("Getting all the student information from the database")
	public Response getAllStudents()
	{
		Response response = restClient.doGetRequest("/list");
		return response;
	}
	
	@Step("Creating a new student : {0}, {1}, {2}, {3}, {4}")
	public Response createNewStudent(String url, String firstName,
			String lastName, String email, String programme, List<String> courses)
	{
		StudentClass body = new StudentClass();
		body.setFirstName(firstName);
		body.setLastName(lastName);
		body.setEmail(email);
		body.setProgramme(programme);
		return restClient.doPostRequest(url, body);
	}
	
	@Step("Deleting student : {0}")
	public Response deleteStudent(String studentId)
	{	
		return restClient.doDeleteResponse(studentId);
	}
	
	@Step("get student by Id : {0}")
	public Response getStudentById(String studentId)
	{
		return restClient.doGetRequest("/" + studentId);
	}
	
	
}

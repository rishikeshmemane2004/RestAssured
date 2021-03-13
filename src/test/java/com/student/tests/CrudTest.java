package com.student.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.github.javafaker.Faker;
import com.student.requests.RequestFactory;
import com.student.specs.SpecificationFactory;
import com.student.tags.Regression;
import com.student.tags.Smoke;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.Tag;


public class CrudTest extends TestBase{

	RequestFactory request = new RequestFactory();
	
	@Category(Smoke.class)
	@Description("This class has all CRUD (LIST) operations")
	@Epic("This is EPIC for : Stundet's operation")
	@Feature("This is a FEATURE of student list operation")
	@Story("This story talks about  listing of students")
	@Test
//	@Ignore
	public void getAllStudents()
	{
		request.getAllStudents()
				.then()
					.spec(SpecificationFactory.getGenericResponseSpec())
					.log().all()
					.statusCode(200);
	}
	
	@Category(Regression.class)
	@Description("This class has all CRUD (CREATE) operations")
	@Epic("This is EPIC for : Stundet's CREATE operation")
	@Feature("This is a FEATURE of CREATE NEW STUDENT operation")
	@Story("This story talks about  creating new student entry")
	@Test()
	@Tag("Regression, Smoke")
	public void createNewStudent()
	{
		/*String firstName    = "John";
		String lastName     = "Smith";
		String email        = "john@gmail.com";
		String programme    = "Computer Science";
		List<String> courses = new ArrayList<String>();
		courses.add("C++");
		courses.add("Java");*/
		// using Faker library create data
		Faker fakerData = new Faker();
		
		String firstName    = fakerData.name().firstName();
		String lastName     = fakerData.name().lastName();
		String email        = fakerData.internet().emailAddress();
		String programme    = "Mechanical";
		List<String> courses = new ArrayList<String>();
		courses.add("Groovy");
		courses.add("Python");
		
		request.createNewStudent("", firstName, lastName, email,
				programme, courses)
		.then()
		.spec(SpecificationFactory.getGenericResponseSpec())
		.statusCode(201);	
	}
	
}

package demo;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExmaples1 extends DataForTest{
	

	//@Test(dataProvider = "DataForPost")
	public void test_post(String firstname, String lastname, int subjectId) {
		
		JSONObject request = new JSONObject();
		
		request.put("firstname", firstname);
		request.put("lastname", lastname);
		request.put("subjectId", subjectId);
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}
	
	
	//@Test(dataProvider = "DeleteData")
	public void test_1_delete(int userId) {
		
		baseURI = "http://localhost:3000/";
		
		when().
			delete("/users/"+userId).
		then().
			statusCode(200);
	}
	
	@Parameters({"userId"})
	@Test
	public void test_1_delete2(int userId) {

		System.out.println("Value for userId is : " + userId);
		baseURI = "http://localhost:3000/";

		when().
		delete("/users/"+userId).
		then().
		statusCode(200);
	}
	
	
}

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Examples {

	@Test
	public void test_get() {
		
		baseURI = "http://localhost:3000/";
		
		given().
			//.get("/users").
			param("name", "Automation").
			get("/subjects").
		then().
			statusCode(200). 
			log().all();
	}
	
	
	@Test
	public void test_post() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstname", "Ramón");
		request.put("lastname", "Valdéz");
		request.put("subjectId", 1);
		
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
	
	@Test
	public void test_patch() {
		
		JSONObject request = new JSONObject();
		
		request.put("lastname", "Cordero");
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			patch("/users/4").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void test_put() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstname", "Martin");
		request.put("lastname", "Campos");
		request.put("subjectId", 1);
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			put("/users/4").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void test_1_delete() {
		
		baseURI = "http://localhost:3000/";
		
		when().
			delete("/users/5").
		then().
			statusCode(200);
	}
}

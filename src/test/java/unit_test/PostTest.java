package unit_test;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostTest {

	@Test(enabled = false )
	public void postTestStringBody() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body("{\"id\": 7,\"firstName\": \"Harshal\",\"lastName\": \"Gibbs\",\"DOB\": \"04/02/1980\",\"deptId\": 90}")
		.basePath("/students")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}
	
	@Test(enabled = false)
	public void postTestFileBody() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(new File("src/test/resources/students.json"))
		.basePath("/students")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}
	
	@Test(enabled = false)
	public void postTestFileBodyInputStream() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(getClass().getClassLoader().getResourceAsStream("st1.json"))
		.basePath("/students")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}
	
	@Test(enabled = false)
	public void postTestByteBody() {
		try {
			RestAssured.given()
			.baseUri("http://localhost:3000")
			.contentType(ContentType.JSON)
			.body(getClass().getClassLoader().getResourceAsStream("st2.json").readAllBytes())
			.basePath("/students")
			.when()
			.log().all()
			.post()
			.then()
			.log().all()
			.statusCode(201);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(enabled = false)
	public void postTestMapBody() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 11);
		map.put("firstName", "Araf");
		map.put("lastName", "Rahman");
		map.put("DOB", "05/05/1997");
		map.put("deptId", 160);
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(map)
		.basePath("/students")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}

}

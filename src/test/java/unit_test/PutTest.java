package unit_test;


import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutTest {
	@Test(enabled = false)
	public void putTest() {
		Map<String, Object> map = new HashMap<>();
		
		map.put("firstName", "Naym");
		map.put("lastName", "Akram");
		map.put("DOB", "08/01/1944");
		map.put("deptId", 180);
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(map) 
		.basePath("/students/11")
		.log().all()
		.put()
		.then()
		.log().all()
		.statusCode(200);
		
	}

}

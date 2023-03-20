package unit_test;



import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GetTest {
	@Test(enabled = false)
	public void getStudentsPrettyPrint() {
		RestAssured.get("http://localhost:3000/students").prettyPrint();
	}

	@Test(enabled = false)
	public void getStudentsVer() {
		Response response = RestAssured.get("http://localhost:3000/students");
		System.out.println("\n" + response.asPrettyString());
	}
	
	@Test(enabled = false)
	public void getStudentsResponseCodeValidation() {
		RestAssured.get("http://localhost:3000/students")
		.then()
		.statusCode(200);
	}
	
	@Test(enabled = false)
	public void getStudentsResponseCodeNegativeValidation() {
		RestAssured.get("http://localhost:3000/students")
		.then()
		.statusCode(404);
	}
	
	
	@Test(enabled = false)
	public void getStudentsLog() {
		RestAssured.given()
		.log().all()
		.get("http://localhost:3000/students")
		.then()
		.log().all()
		.statusCode(200);
	}
	
	@Test(enabled = false)
	public void getStudentsResponseValidation() {
		RestAssured.given()
		.log().all()
		.get("http://localhost:3000/students/4")
		.then()
		.log().all()
		.statusCode(200)
		.and()
		.body("id", equalTo(4))
		.body("firstName", equalTo("Mohammed"))
		.body("lastName", equalTo("Shafqat"));
		
	}
	@Test(enabled = false)
	public void getStudentsBaseUriPath() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/students/1")
		.log().all()
		.get()
		.then()
		.log().all()
		.statusCode(200);
	}
	
}

package functionalTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endPoints.Students;

public class PostStudentsTest {
	
	Students students;
	
	@BeforeMethod
	public void init() {
		students = new Students();
		students.init();
	}
	@Test(enabled = true)
	public void postStudents() {
		students.postStudents();
		
		students.validateStatusCode(201);
		students.validatePayloadObject("firstName", "Nyma");
		students.validate_w_JsonPath("deptId", 125);
	}

}

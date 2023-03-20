package functionalTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endPoints.Students;

public class PutStudentsTest {
	
	Students students;
	
	
	@BeforeMethod
	public void init() {
		students = new Students();
		students.init();
	}
	
	@Test(enabled = true)
	public void putStudentsByObject() {
		students.putStudents(12);
		students.validatePayloadObject("firstName", "Zakia");
		students.validateStatusCode(200);
	}
}

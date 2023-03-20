package functionalTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endPoints.Students;

public class DeleteStudentsTest {
		
	Students students;
	
	@BeforeMethod
	public void init() {
		students = new Students();
		students.init();
	}
	
	@Test(enabled = true)
	public void deleteStudents() {
		students.deleteStudents(12);
		students.validateStatusCode(200);
	}
}

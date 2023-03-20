package functionalTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import endPoints.Students;

public class GetStudentsTest {
	Students students;

	@BeforeMethod
	public void initTest() {
		students = new Students();
		students.init();
	}
	@Test(enabled = false)
	public void validation() {
		students.getStudents();
		students.validateStatusCode(200);
	}
	@Test(enabled = false)
	public void getStudentById() {
		students.getEachStudent(4);
		students.validateStatusCode(200);
		students.validatePayloadObject("lastName", "Shafqat");
		students.validatePayloadObject("deptId", 50);
		students.validate_w_JsonPath("id", 4);
	}
	@Test(enabled = true)
	public void responseValidation() {
		students.getEachStudent(4);
		System.out.println(students.getResponse().getBody().jsonPath().getString("DOB"));
	}
}

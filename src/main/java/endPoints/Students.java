package endPoints;



import java.io.File;


import utils.RestSpecifications;

public class Students extends RestSpecifications {
	private final String ENDPOINT = "/students";
	private final String fileName = "st3.json";
	
	
	public void getStudents() {
		getCall(ENDPOINT);
	}
	
	public void getEachStudent( int studentId) {
		getCall(ENDPOINT +"/"+ studentId);
	}
	
	public void postStudents() {
		setBody(getClass().getClassLoader().getResourceAsStream(fileName));
		setContentTypeAsJson();
		postCall(ENDPOINT);
	}
	
	public void putStudents(Object value) {
		setBody(new File("src/test/resources/st4.json"));
		setContentTypeAsJson();
		putCall(ENDPOINT+"/"+ value);
	}
	 
	public void deleteStudents(Object value) {
		deleteCall(ENDPOINT +"/"+ value);
	}
	
}



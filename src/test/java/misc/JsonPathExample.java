package misc;

import java.io.InputStream;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathExample {
	
	JsonPath jsonPath;
	
	@BeforeMethod
	public void init() {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample_complex.json");
		jsonPath =new JsonPath(inputStream);
	}
	
	@Test(enabled = false)
	public void jsonPathGetMap() {
		System.out.println(jsonPath.getMap("items"));
	}
	
	@Test(enabled = false)
	public void jsonPathGetList() {
		System.out.println(jsonPath.getList("items.item"));
	}
	
	@Test(enabled = false)
	public void jsonPathGetDouble() {
		System.out.println(jsonPath.getDouble("items.item[0].ppu"));
	}
	
	@Test
	public void jsonPathWildCard() {
		System.out.println(jsonPath.getList("items..ppu"));
	}
}

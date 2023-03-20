package utils;

import java.io.InputStream;
import java.util.Properties;
import reporting.Logs;

public class TestConfig {

	private TestConfig() {
	}

	private Properties initProperties() {
		Properties properties = null;
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream("environment.properties");
			properties = new Properties();
			properties.load(is);
		} catch (Exception e) {
			Logs.log("Environment values not found");
		}
		return properties;
	}

	public static String getUrl() {
		TestConfig config = new TestConfig();
		return config.initProperties().getProperty(Env.url.name());
	}

	enum Env {
		url
	}

}

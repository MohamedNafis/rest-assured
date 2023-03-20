package misc;

import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;

public class Misc {
	
	@Test
	public void base64Convertion(){
		String userPass = "user:pass";
		String afterEncodingString = Base64.encodeBase64String(userPass.getBytes());
		for(byte b : userPass.getBytes()) {
			System.out.println(b);
		}
		System.out.println(afterEncodingString);
		byte[] afterDecode = Base64.decodeBase64("dXNlcjpwYXNz".getBytes());
		System.out.println(new String(afterDecode));
	}

}

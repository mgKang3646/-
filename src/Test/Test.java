package Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Test {
	
	public static void main(String[] args) throws IOException {
		
		byte[] bytes = new byte[3];
		System.in.read(bytes);
		
		String result = new String(bytes);
		
		System.out.println(result);
		
	}

}

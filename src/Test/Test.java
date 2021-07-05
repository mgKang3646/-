package Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Test {
	
	public static void main(String[] args) throws IOException {
		
		int data = System.in.read();
		System.out.println(data);
		
		String stringData = "안녕";
		System.out.println(stringData);
		
		byte[] bytes = stringData.getBytes();
		
		for(byte value : bytes) {
			System.out.println(value);
		}
		
	}

}

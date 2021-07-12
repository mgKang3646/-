package boj2908;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;
		
		stz = new StringTokenizer(br.readLine()," ");
		
		String a = stz.nextToken();
		String b = stz.nextToken();
		
		String reverseA = reverseValue(a);
		String reverseB = reverseValue(b);
		
		if(Integer.parseInt(reverseA) >= Integer.parseInt(reverseB)) {
			bw.write(reverseA);
		}else {
			bw.write(reverseB);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static String reverseValue(String value) {
		
		int data = Integer.parseInt(value);
		String result = "";
		
		while(data > 0) {
			int decimal = data % 10;
			result += decimal;
			data /= 10;
		}
		
		return result;
	}

}

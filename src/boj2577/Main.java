package boj2577;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;

public class Main {
	// String을 이용한 풀이
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		String result = String.valueOf(A*B*C);
		
		StringReader sr = new StringReader(result);
		char[] resultArr = new char[9];
		int[] countArr = new int[10];
		
		int readCount = sr.read(resultArr);
		
		for(int i =0; i<readCount;i++) {
			countArr[Character.getNumericValue(resultArr[i])]++;
		}
		
		for(int i=0; i<countArr.length;i++) {
			bw.write(countArr[i]+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

}

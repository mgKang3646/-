package boj3052;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		// true, false로 중복 체크
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] numArr = new boolean[42];
		int count = 0;
		for(int i=0; i<10; i++) {
			numArr[Integer.parseInt(br.readLine())%42] = true;
		}
		
		for( boolean value : numArr) {
			if(value) {
				count++;
			}
		}
		
		bw.write(count+"");
		bw.flush();
		bw.close();
		br.close();

	}

}

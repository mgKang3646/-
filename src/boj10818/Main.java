package boj10818;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;
		int count = Integer.parseInt(br.readLine());
		String data = br.readLine();
		stz = new StringTokenizer(data," ");
		
		int value = Integer.parseInt(stz.nextToken());
		int max = value;
		int min = value;
		
		for(int i =0; i<count-1; i++) {
			value = Integer.parseInt(stz.nextToken());
			
			if(value > max ) { // 비교연산자의 피연산자는 초기화 상태여야 함
				max = value;
			}else {
				if(value < min) {
					min = value;
				}	
			}
		}
		
		bw.write(min+" "+max); 
		bw.flush();
		br.close();
		bw.close();
		
	}
}

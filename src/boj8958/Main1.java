package boj8958;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 다른 사람 풀이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int size = Integer.parseInt(br.readLine());
		
		for(int i =0; i<size;i++) {
			int score = 0;
			int sum = 0;
			
			for( byte value : br.readLine().getBytes()) {
				if(value == 'O') {
					sum += ++score;
				}else {
					score = 0;
				}
			}
			bw.write(sum+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}

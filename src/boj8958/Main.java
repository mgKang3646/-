package boj8958;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		// 나의 풀이 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		String ox = null;
		int count = 0;
		
		while( count < num ) {
			count++;
			ox = br.readLine();
			int score = 0;
			int sum = 0;
			
			for(int i=0; i<ox.length(); i++) {
				if(ox.charAt(i) == 'O') {
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

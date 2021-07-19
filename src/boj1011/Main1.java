package boj1011;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1 {
	// 문제가 잘못된 듯 함
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;
		
		int testcase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testcase; i++) {
			stz = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(stz.nextToken());
			int y = Integer.parseInt(stz.nextToken());
			
			int distance = y - x;
			
			int n =(int)Math.round(Math.sqrt(distance));
			
			if( distance <= n*n) {
				bw.write(2*n-1+"\n");
			}else {
				bw.write(2*n+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

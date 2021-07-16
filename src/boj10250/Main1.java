package boj10250;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stz;
		
		stz = new StringTokenizer(br.readLine()," ");
		int testcase = Integer.parseInt(stz.nextToken());
		
		for(int i=0; i<testcase; i++) {
			stz = new StringTokenizer(br.readLine()," ");
			int H = Integer.parseInt(stz.nextToken());
			int W = Integer.parseInt(stz.nextToken());
			int N = Integer.parseInt(stz.nextToken());
			
			int layer = N%H;
			int number = N/H+1;

			if(N%H == 0) {
				layer = H;
				number -= 1;
			}
			
			bw.write( ( layer*100 + number ) +"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}

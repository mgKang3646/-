package boj1011;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;
		
		int testcase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testcase; i++) {
			stz = new StringTokenizer(br.readLine());
			
			double x = Double.parseDouble(stz.nextToken());
			double y = Double.parseDouble(stz.nextToken());
			
			double distance = y - x;
			double n = Math.round(Math.sqrt(distance));
			
			if( distance <= Math.pow(n, 2)) {
				bw.write((int)(2*n-1)+"\n");
			}else {
				bw.write((int)(2*n)+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

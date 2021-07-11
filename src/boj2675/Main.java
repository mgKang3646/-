package boj2675;

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
		int testcase = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < testcase; i++) {
			
			stz = new StringTokenizer(br.readLine()," ");
			int length = Integer.parseInt(stz.nextToken());
			String data = stz.nextToken();
			
			for(int z=0; z<data.length();z++) {
				for(int j=0; j<length; j++) {
					bw.write(data.charAt(z));
				}
			}
			
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

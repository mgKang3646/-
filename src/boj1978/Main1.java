package boj1978;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;
		
		int size = Integer.parseInt(br.readLine());
		stz = new StringTokenizer(br.readLine());
		int count = size;
		
		for(int i=0; i<size;i++) {
			int value = Integer.parseInt(stz.nextToken());
			
			if(value != 1) {
				for(int j=2; j*j <= value; j++) {
					if(value % j == 0) {
						count--;
						break;
					}
				}
			}else {
				count--;
			}
			
			
		}
		
		bw.write(count+"\n");
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}

package boj2675;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testcase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i< testcase; i++) {
			String[] str = br.readLine().split(" ");
			int size = Integer.parseInt(str[0]);
			String data = str[1];
			
			for(int j=0; j<data.length();j++) {
				for(int z=0; z<size;z++) {
					bw.write(data.charAt(j));
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

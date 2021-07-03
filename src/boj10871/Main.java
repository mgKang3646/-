package boj10871;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String data = br.readLine();
		StringTokenizer stz = new StringTokenizer(data," ");
		
		int n = Integer.parseInt(stz.nextToken());
		int x = Integer.parseInt(stz.nextToken());
		
		String numArray = br.readLine();
		stz = new StringTokenizer(numArray," ");
		String value;
		
		for(int i=0; i<n;i++) {
			value = stz.nextToken();
			if(Integer.parseInt(value) < x) {
				bw.write(value+" ");
			}
		}
		bw.flush();
		bw.close();
		br.close();

	}

}

package boj2908;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// API 이용한 풀이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;
		
		stz = new StringTokenizer(br.readLine()," ");
		
		String a = stz.nextToken();
		String b = stz.nextToken();
		
		int reverseA = Integer.parseInt(new StringBuilder().append(a).reverse().toString());
		int reverseB = Integer.parseInt(new StringBuilder().append(b).reverse().toString());
		
		bw.write((reverseA >= reverseB ? reverseA : reverseB)+"");
		bw.flush();
		bw.close();
		br.close();
	}

}

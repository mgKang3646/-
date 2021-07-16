package boj2869;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;
		
		stz = new StringTokenizer(br.readLine()," ");
		
		int A = Integer.parseInt(stz.nextToken());
		int B = Integer.parseInt(stz.nextToken());
		int V = Integer.parseInt(stz.nextToken());
		
		int distance = V - A;
		int dif = A - B;
		int days = (int)Math.ceil((double)distance/dif) + 1;
		
		
		bw.write(days+"");
		bw.flush();
		bw.close();
		br.close();
	}
}

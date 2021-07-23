package boj3009;

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
		int x1 = Integer.parseInt(stz.nextToken());
		int y1 = Integer.parseInt(stz.nextToken());
		
		stz = new StringTokenizer(br.readLine()," ");
		int x2 = Integer.parseInt(stz.nextToken());
		int y2 = Integer.parseInt(stz.nextToken());
		
		stz = new StringTokenizer(br.readLine()," ");
		int x3 = Integer.parseInt(stz.nextToken());
		int y3 = Integer.parseInt(stz.nextToken());
		
		
		int x4 = (x3 == x1) ? x2 : (x3 == x2) ? x1 : x3;
		int y4 = (y3 == y1) ? y2 : (y3 == y2) ? y1 : y3;
		
		bw.write(x4+" "+y4);
		bw.flush();
		bw.close();
		br.close();
		
	}
}

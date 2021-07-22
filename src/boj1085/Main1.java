package boj1085;

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
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(stz.nextToken());
		int y = Integer.parseInt(stz.nextToken());
		int w = Integer.parseInt(stz.nextToken());
		int h = Integer.parseInt(stz.nextToken());
		
		int xMin = Math.min(x, w-x);
		int yMin = Math.min(y, h-y);
		
		bw.write(Math.min(xMin, yMin)+"");
		bw.flush();
		bw.close();
		br.close();
	}

}

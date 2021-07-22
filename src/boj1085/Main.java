package boj1085;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	// 수학에 알고리즘을 맞추지 말고, 알고리즘에 수학을 곁들여라.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(stz.nextToken());
		int y = Integer.parseInt(stz.nextToken());
		int w = Integer.parseInt(stz.nextToken());
		int h = Integer.parseInt(stz.nextToken());
		
		if(x > w/2) {
			if(y > h/2) {
				bw.write(getMinDistance(w-x,h-y)+"");
			}else {
				bw.write(getMinDistance(w-x,y)+"");
			}
		}else {
			if(y > h/2) {
				bw.write(getMinDistance(x,h-y) +"");
			}else {
				bw.write(getMinDistance(x,y)+"");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int getMinDistance(int wide, int height) {
		return wide > height ? height : wide;
	}

}

package boj1002;

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
		
		for(int i =0 ; i< testcase;i++) {
			stz = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(stz.nextToken());
			int y1 = Integer.parseInt(stz.nextToken());
			int r1 = Integer.parseInt(stz.nextToken());
			int x2 = Integer.parseInt(stz.nextToken());
			int y2 = Integer.parseInt(stz.nextToken());
			int r2 = Integer.parseInt(stz.nextToken());
			
			bw.write(countMeanNumber(x1,y1,r1,x2,y2,r2)+"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int countMeanNumber(int x1, int y1, int r1, int x2, int y2, int r2) {
		
		double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		
		if(distance != 0) { // 두 점이 일치하지 않은 경우
			// 위치의 개수 : 2
			if ((r1+r2) > distance && Math.abs(r1-r2) < distance ) {
					return 2;
			}		
			// 위치의 개수 : 0
			else if ((r1+r2) < distance || Math.abs(r1-r2) > distance) {
					return 0;
			}
			// 위치의 개수 : 1
			else {
				return 1;
			}
		}else { // 두 점이 일치하는 경우
			if(r1 != r2 ) {
				return 0;
			}else {
				return -1;
			}	
		}
	}
	
}

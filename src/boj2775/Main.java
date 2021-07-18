package boj2775;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] apart = new int[15][15];
		
		for(int i=0; i<15; i++) {
			apart[0][i] = i; 
			apart[i][0] = i;
			apart[i][1] = 1;
		}
		
		int layer = 0; // 층
		int roomNum = 0; // 호실
		
		for(layer = 1; layer<apart.length; layer++) {
			for(roomNum=2; roomNum<apart[layer].length;roomNum++) {
				apart[layer][roomNum] = apart[layer][roomNum-1] + apart[layer-1][roomNum];		
			}
		}
		
		int testcase = sc.nextInt();
		
		for(int i=0; i<testcase; i++) {
			layer = sc.nextInt();
			roomNum = sc.nextInt();
			System.out.println(apart[layer][roomNum]);
		}
	}

}

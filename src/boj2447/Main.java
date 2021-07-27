package boj2447;

import java.util.Scanner;

public class Main {

	public static int[][] arr;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n][n];
		
		pattern(n,0,0);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] == 1) {
					sb.append("*");
				}else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}
	
	public static void pattern(int n, int coordX, int coordY) {
		if(n==3) {
			for(int i=0; i<9; i++) {
				if(i!=4) {
					arr[coordX+i/3][coordY+n/3*i%3] = 1;
				}else {
					arr[coordX+i/3][coordY+n/3*i%3] = 0;
				}
			}
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(i != 4) {
				pattern( n/3, coordX + n/3*(i/3), coordY + n/3*(i%3));
			}else {
				fillEmpty(n/3, coordX + n/3*(i/3), coordY + n/3*(i%3));
			}
		}
	}
	
	public static void fillEmpty(int n,int coordX, int coordY) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[coordX+i][coordY+j] = 0;
			}
		}
	}
	
}
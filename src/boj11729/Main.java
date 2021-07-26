package boj11729;

import java.util.Scanner;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sb.append(countHanoi(n)).append("\n");
		hanoi(n,1,2,3);
		System.out.println(sb.toString());
		
	}

	public static void hanoi(int n, int start, int middle, int end) {
		if(n==1) {
			sb.append(start+" "+end).append("\n");
			return;
		}
		
		hanoi(n-1,start,end,middle);
		sb.append(start+ " " +end).append("\n");
		hanoi(n-1,middle,start,end);
	}
	
	public static int countHanoi(int n) {
		if(n==1) {
			return 1;
		}else {
			return 2*countHanoi(n-1)+1;
		}
	}
}

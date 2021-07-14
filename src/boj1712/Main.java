package boj1712;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if( C > B ) {
			int breakEvenPoint = A / (C - B) + 1;
			System.out.println(breakEvenPoint);
		}
		
		else {
			System.out.println(-1);
		}	
	}
}

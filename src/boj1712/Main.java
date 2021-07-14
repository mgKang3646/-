package boj1712;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int breakEvenPoint = A / (C - B) + 1;
		
		if(breakEvenPoint > 0) {
			System.out.println(breakEvenPoint);
		}else {
			System.out.println(-1);
		}
	}
}

package boj2581;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int sum = 0;
		int min = 10001;
		boolean isPrime = true;

		for(int i = N; i <= M; i++) {
			if(i != 1 && i != 0) {
				for(int j=2; j*j <= i; j++) {
					if(i%j == 0) {
						isPrime = false;
						break;
					}
				}
				if(isPrime) {
					sum += i;
					if( i < min ) {
						min = i;
					}
				}	
				isPrime = true;
			}
		}
		
		if(sum == 0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}

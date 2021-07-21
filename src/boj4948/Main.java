package boj4948;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean[] prime;
		
		
		while(true) {
			int n = sc.nextInt();
			
			if(n < 1) {
				break;
			}
			
			prime= new boolean[2*n+1];
			initializePrimeArray(prime);
			
			int primeCount = 0;
			for(int i = n + 1; i < prime.length; i++) {
				if(!prime[i]) {
					primeCount++;
				}
			}
			
			System.out.println(primeCount);
		}
	}
	
	public static void initializePrimeArray(boolean[] prime) {
		
		prime[0] = true;
		prime[1] = true;
		
		for( int i = 2; i*i < prime.length; i++) {
			if(prime[i]) continue;
			for(int j = i*i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}

}

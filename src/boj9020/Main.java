package boj9020;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean[] prime = new boolean[10001];
		initializePrimeArray(prime);
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int testcase = sc.nextInt();
		
		for(int i = 0; i< testcase; i++) {
			
			int evenNumber = sc.nextInt();
			String result = "";
			
			for( int j = 2; j <= evenNumber - j; j++) {
				if(prime[j])continue;
				if(!prime[evenNumber - j]) {
					result = j + " " + (evenNumber - j);
				}
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void initializePrimeArray(boolean[] prime) {
		
		prime[0] = true;
		prime[1] = true;
		
		for(int i=2; i*i<prime.length; i++) {
			if(prime[i])continue;
			for(int j=i*i; j<prime.length;j+=i) {
				prime[j] = true;
			}
		}
	}

}

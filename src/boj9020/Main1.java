package boj9020;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		boolean[] prime = new boolean[10001];
		initializePrimeArray(prime);
		
		int testcase = sc.nextInt();
		
		for(int i = 0; i< testcase; i++) {
			int evenNumber = sc.nextInt();
			int small = evenNumber / 2;
			int big = evenNumber / 2;
			
			String result = "";
			
			while(true) { //반드시 합이 하나는 나오니깐 무한루프 돌려도 된다.
				if(prime[small]== false && prime[big] == false) {
					result = small + " " + big;
					break;
				}
				small--;
				big++;
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

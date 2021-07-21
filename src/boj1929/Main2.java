package boj1929;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		boolean[] prime = new boolean[N+1];
		
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i*i < prime.length; i++) {
			if(prime[i]) continue;
			for(int j = i*i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
		
		for(int i = M; i<=N; i++) {
			if(!prime[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}

}

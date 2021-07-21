package boj1929;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		//StringBuilder 사용 : 성능 개선을 위해 문자열을 붙어서 출력
			
			Scanner sc = new Scanner(System.in);
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			
			boolean isPrime = true;
			
			
			if(N == 1) {
				N += 1;
			}
			else if (N == 0) {
				N += 2;
			}
				
			for(int i = N; i <= M; i++) {
					for(int j = 2; j*j <= i; j++) {
						if( i%j == 0 ) {
							isPrime = false;
							break;
						}
					}
					
					if(isPrime) {
						sb.append(i).append("\n");
					}
					isPrime = true;
			}
			
			System.out.println(sb);

		}

	}

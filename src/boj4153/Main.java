package boj4153;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		while(true) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			
			if(x==0) break; //제약조건은 반복문 앞에 놓기
			
			int sum = x*x + y*y + z*z;
			int max = Math.max(x, y);
			max = Math.max(max, z);
			
			if(max*max == (sum - max*max)) System.out.println("right");
			else System.out.println("wrong");
		}
		sc.close();
	}
}

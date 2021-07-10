package boj11720;

import java.util.Scanner;

public class Main1 {
	// 아스키코드 활용
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int length = sc.nextInt();
		String data = sc.next();
		int sum = 0;
		for(int i =0; i< length; i++) {
			sum += data.charAt(i)-'0';
		}
		
		System.out.println(sum);

	}

}

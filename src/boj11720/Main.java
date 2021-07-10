package boj11720;

import java.util.Scanner;

public class Main {
	// Character.getNumericValue() 사용
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int length = sc.nextInt();
		String data = sc.next();
		int sum = 0;
		
		for(int i = 0; i<length; i++) {
			sum += Character.getNumericValue(data.charAt(i));
		}
		System.out.println(sum);
	}

}

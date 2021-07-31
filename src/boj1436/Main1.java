package boj1436;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		int value = 665;
		
		while(count < n) {
			value++;
			if(String.valueOf(value).contains("666")) {
				count++;
			}
		}
		System.out.println(value);
	}
	
}



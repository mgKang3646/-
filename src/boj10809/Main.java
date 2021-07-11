package boj10809;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String data = sc.next();
		
		for(char c ='a'; c <= 'z'; c++) {
			int value = data.indexOf(c);
			System.out.print(value+ " ");	
		}
	}
}

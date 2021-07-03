package boj1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		ArrayList<Integer> result = returnValue(b);
		
		for( int num : result) {
			System.out.println(a*num);
		}
		
		System.out.println(a*b);
	}
	
	public static ArrayList<Integer> returnValue(int decimal) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int value;
		
		int i = 100;
		
		do {
			value = decimal/i;
			numbers.add(0,value);

			decimal -= value*i;
			i = i/10;

		}while(i >= 1);
		
		return numbers;
		
	}

}

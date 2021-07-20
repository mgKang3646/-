package boj11653;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		boolean[] primeNumber = new boolean[value+1];
	
		primeNumber[0] = true;
		primeNumber[1] = true;
		
		for(int i=2; i < primeNumber.length; i++) {
			if(!primeNumber[i]) {
				int count = 2;
				while(i*count < primeNumber.length) {
					primeNumber[i*count++] = true;
				}
			}
		}
		
		for(int i = 2; i<primeNumber.length;i++) {
			if( value < i) {
				break;
			}
			if(!primeNumber[i]) {
				if(value % i == 0) {
					System.out.println(i);
					value /= i;
					i--;
				}
			}
		}
	}
}

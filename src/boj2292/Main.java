package boj2292;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int value = sc.nextInt();
		int i = 0;
		
		while(true) {
			
			if( value <= 3*i*i-3*i+ 1 ) {
				if( value >= 3*i*i -9*i + 7 ) {
					System.out.println(i);
					break;
				}
			}
			i++;
		}	
	}
}

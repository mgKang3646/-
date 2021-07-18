package boj2839;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int goal = sc.nextInt();
		
		int maxNumFor3kg = goal / 3;
		int numFor5kg = 0;
		int min = 5000/3;
		
		
		for(int i=0; i <= maxNumFor3kg; i++) {
			if(( goal - 3*i ) % 5 == 0) {
				numFor5kg = ( goal - 3*i ) / 5;
				if( ( i + numFor5kg ) < min ) {
					min = i + numFor5kg;
				}
			}
		}
		
		if(min == 5000/3) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
}

package boj2562;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] num = new int[9];
		
		// 첫 데이터 삽입
		num[0] = sc.nextInt();
		int max = num[0];
		int maxIndex = 0;
		
		for(int i=1; i<9; i++) { 
			num[i] = sc.nextInt();
			
			if(num[i] > max) {
				max = num[i];
				maxIndex = i;
			}
		}
		
		System.out.printf(max+"\n"+(maxIndex+1));
	
	}

}

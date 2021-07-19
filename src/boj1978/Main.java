package boj1978;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean[] primeNumber = new boolean[1001];
		
		primeNumber[0] = true;
		primeNumber[1] = true;
		
		for(int i=2;i<primeNumber.length;i++) {
			if(!primeNumber[i]) {
				int j = 2;
				while( primeNumber.length > j*i) {
					primeNumber[j*i] = true;
					j++;
				}
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;
		for(int i=0; i<num;i++)	{
			int value = sc.nextInt();
			if(!primeNumber[value]) count++;
		}
		
		System.out.println(count);
	}

}

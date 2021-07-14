package boj2292;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		int pivot = 1;
		int i = 1;
		
		while(value > pivot) {
			i++;
			pivot = pivot + 6*(i-1);
		}
		System.out.println(i);
	}

}

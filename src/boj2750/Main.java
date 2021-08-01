package boj2750;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		for(int i =0; i<size; i++) {
			arr[i] = sc.nextInt();
		}

		for(int i=0; i<size;i++) {
			for(int j=i+1;j<size;j++) {
				if(arr[j] < arr[i]) {
					int tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
					j=i;
				}
			}
			System.out.println(arr[i]);
		}
	}
}

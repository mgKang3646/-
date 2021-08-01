package boj2750;

import java.util.Scanner;

public class Main3 {
	
	private static int[] arr;
	private static Scanner sc;
	
	public static void main(String[] args) {
		createArr();
		doSort();
		print();
	}
	
	public static void createArr() {
		makeArr();
		setArr();
	}
	
	public static void doSort() {
		for(int i=0; i<arr.length-1;i++) {
			int lastSwap = arr.length-1;
			for(int j=arr.length-1; j>i; j--) {
				if(arr[j] < arr[j-1]) {
					swap(j);
					lastSwap = j-1;
				}
			}
			i = lastSwap;
		}
	}
	
	public static void print() {
		for( int value : arr) {
			System.out.println(value);
		}
	}
	
	public static void makeArr() {
		sc = new Scanner(System.in);
		int size = sc.nextInt();
		arr = new int[size];
	}

	public static void setArr() {
		for(int i=0; i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
	}
	
	public static void swap(int j) {
		int tmp = arr[j];
		arr[j] = arr[j-1];
		arr[j-1] =tmp;
	}
}

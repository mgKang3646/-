package boj1427;

import java.util.Scanner;
//버블정렬
public class Main {

	public static String input;
	public static int[] arr;
	public static StringBuilder sb;
	
	public static void main(String[] args) {
		setInputData();
		createArr();
		initializeArr();
		doBubbleSort();
		printArr();
		
	}
	
	public static void setInputData() {
		Scanner sc = new Scanner(System.in);
		input = sc.next();
	}
	
	public static void createArr() {
		arr = new int[input.length()];
	}
	
	public static void initializeArr() {
		for(int i =0; i< arr.length; i++) {
			arr[i] = input.charAt(i) - '0';
		}
	}
	
	public static void doBubbleSort() {
		for(int i =0; i<arr.length-1;i++) {
			int lastExchangeNum = 0;
			int lastExchangeIndex = 0;
			for(int j = arr.length-1; j > i; j--) {
				if(arr[j] > arr[j-1]) {
					swap(j);
					lastExchangeNum++;
					lastExchangeIndex = j-1;
				}
			}
			if(lastExchangeNum == 0) break;
			else i = lastExchangeIndex; 
		}
	}
	
	public static void swap(int value) {
		int tmp = arr[value];
		arr[value] = arr[value-1];
		arr[value-1] = tmp;
	}
	
	public static void printArr() {
		sb = new StringBuilder();
		for( int value : arr) {
			sb.append(value);
		}
		System.out.println(sb.toString());
	}
}

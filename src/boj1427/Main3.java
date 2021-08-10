package boj1427;

import java.util.Scanner;

//카운팅정렬
public class Main3 {

	public static String input;
	public static StringBuilder sb;
	
	public static int[] arr;
	
	public static void main(String[] args) {
		setInputData();
		createArr();
		initializeArr();
		doCountingSort();
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
	
	public static void doCountingSort(){
		int[] countingArr = new int[getMaxValue()+1];
		
		for(int value : arr) {
			countingArr[value]++;
		}
		
		int arrPointer = 0;
		
		for(int i=countingArr.length-1; i >= 0; i--) {
			if(countingArr[i] == 0) continue;
			for( int j = 0; j < countingArr[i]; j++) {
				arr[arrPointer++] = i;
			}
		}
	}
	
	public static int getMaxValue() {
		int max = 0;
		for(int value : arr) {
			if( value > max ) max = value;
		}
		return max;
	}
	
	public static void printArr() {
		sb = new StringBuilder();
		for( int value : arr) {
			sb.append(value);
		}
		System.out.println(sb.toString());
	}
}

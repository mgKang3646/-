package boj1427;

import java.util.Scanner;

//병합정렬
public class Main2 {

	public static String input;
	public static int[] arr;
	public static StringBuilder sb;
	
	public static void main(String[] args) {
		setInputData();
		createArr();
		initializeArr();
		doMergeSort(0,arr.length-1);
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
	
	public static void doMergeSort(int left, int right) {
		if(left < right) {
			int center = ( left + right )/2;
			
			doMergeSort(left, center);
			doMergeSort(center+1, right);
			
			applyMerge(left,right);
		}
	}
	
	public static void applyMerge(int left, int right) {
		int[] leftArr = new int[right-left+1];
		int center = ( right + left )/2;
		int leftSize = 0;
		int leftPointer = 0;
		int rightPointer = center + 1;
		int arrPointer = left;
		
		for(int i=left; i<=center; i++) {
			leftArr[leftSize++] = arr[i];
		}
		
		for(arrPointer = left; arrPointer <= right; arrPointer++) {
			if(leftPointer < leftSize && rightPointer <= right) {
				arr[arrPointer] = leftArr[leftPointer] > arr[rightPointer] ? leftArr[leftPointer++] : arr[rightPointer++];
			}else {
				break;
			}
		}
		
		while(leftPointer < leftSize) {
			arr[arrPointer++] = leftArr[leftPointer++];
		}
	}
	
	public static void printArr() {
		sb = new StringBuilder();
		for( int value : arr) {
			sb.append(value);
		}
		System.out.println(sb.toString());
	}
}

package boj1427;

import java.util.Scanner;
import java.util.Stack;
//퀵정렬
public class Main1 {

	public static String input;
	public static int[] arr;
	public static StringBuilder sb;
	
	public static void main(String[] args) {
		setInputData();
		createArr();
		initializeArr();
		doQuickSort(0,arr.length-1);
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
	
	public static void doQuickSort(int left, int right) {
		Stack<Integer> leftStack = new Stack<Integer>();
		Stack<Integer> rightStack = new Stack<Integer>();
		
		leftStack.push(left);
		rightStack.push(right);
		
		while(!leftStack.isEmpty()) {
			int leftPointer = left = leftStack.pop();
			int rightPointer = right = rightStack.pop();
			int pivot = arr[(left+right)/2];
			
			while(leftPointer <= rightPointer) {
				while( arr[leftPointer] > pivot ) leftPointer++;
				while( arr[rightPointer] < pivot ) rightPointer--;
				
				if(leftPointer <= rightPointer) {
					swap(leftPointer++,rightPointer--);
				}
			}
			
			if( left < rightPointer ) {
				leftStack.push(left);
				rightStack.push(rightPointer);
			}
			
			if( leftPointer < right ) {
				leftStack.push(leftPointer);
				rightStack.push(right);
			}
		}
	}
	
	public static void swap(int leftPointer, int rightPointer) {
		int tmp = arr[leftPointer];
		arr[leftPointer] = arr[rightPointer];
		arr[rightPointer] = tmp;
	}
	
	public static void printArr() {
		sb = new StringBuilder();
		for( int value : arr) {
			sb.append(value);
		}
		System.out.println(sb.toString());
	}
}

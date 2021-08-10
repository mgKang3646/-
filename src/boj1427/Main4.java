package boj1427;

import java.util.Scanner;

//힙정렬
public class Main4 {

	public static String input;
	public static StringBuilder sb;
	
	public static int[] arr;
	
	public static void main(String[] args) {
		setInputData();
		createArr();
		initializeArr();
		doHeapSort();
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
	
	public static void doHeapSort(){
		
		int lastChildIndex = arr.length-1;
		int lastParentIndex = ( lastChildIndex - 1)/2;
		
		for(int i = lastParentIndex; i>=0; i--) {
			makeHeap(i,lastChildIndex);
		}
		
		for(int i = arr.length-1; i>0; i--) {
			swap(0,i);
			makeHeap(0,i-1);
		}	
	}
	
	public static void makeHeap(int pivotIndex, int lastChildIndex) {
		int parentValue = arr[pivotIndex];
		int parentIndex = pivotIndex;
		int childIndex = 0;
		
		for(parentIndex = pivotIndex; parentIndex < (lastChildIndex + 1)/2; parentIndex = childIndex) {
			int leftChildIndex = 2*parentIndex + 1;
			int rightChildIndex = leftChildIndex + 1;
			
			if(rightChildIndex > lastChildIndex) childIndex = leftChildIndex;
			else childIndex = arr[leftChildIndex] < arr[rightChildIndex] ? leftChildIndex : rightChildIndex;
			
			if( parentValue < arr[childIndex] ) break;
			else arr[parentIndex] = arr[childIndex];
		}
		arr[parentIndex] = parentValue;
	}
	
	public static void swap(int root, int lastIndex) {
		int tmp = arr[root];
		arr[root] = arr[lastIndex];
		arr[lastIndex] = tmp;
	}
	
	public static void printArr() {
		sb = new StringBuilder();
		for( int value : arr) {
			sb.append(value);
		}
		System.out.println(sb.toString());
	}
}

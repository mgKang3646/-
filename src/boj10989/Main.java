package boj10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 버블정렬
public class Main {
	
	private static int[] arr;
	private static BufferedReader br;
	public static void main(String[] args) throws NumberFormatException, IOException {
		makeArr();
		initializeArr();
		doBubbleSort();
		printArr();
	}
	
	public static void makeArr() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		arr = new int[size];
	}
	
	public static void initializeArr() throws NumberFormatException, IOException {
		for(int i=0; i<arr.length;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	}
	
	public static void doBubbleSort() {
		for(int i=0; i<=arr.length-1;i++) {
			int exchangeNum = 0;
			int lastPosition = 0;
			
			for(int j=arr.length-1; j > i; j--) {
				if(arr[j] < arr[j-1]) {
					swap(j);
					exchangeNum++;
					lastPosition = j-1;
				}
			}
			if(exchangeNum == 0)break;
			i = lastPosition;
		}	
	}
	
	public static void swap(int value) {
		int tmp = arr[value];
		arr[value] = arr[value-1];
		arr[value-1] = tmp;
	}
	
	public static void printArr() {
		for(int value : arr) {
			System.out.println(value);
		}
	}
}

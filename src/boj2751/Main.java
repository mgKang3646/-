package boj2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		arr = new int[size];
		
		for(int i=0; i<size;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		doSort();
		print();
	
	}
	
	public static void doSort() {
		for(int i=0; i<arr.length-1;i++) {
			int lastSwap = arr.length-1;
			int exNum = 0;
			for(int j=arr.length-1; j>i;j--) {
				if(arr[j] < arr[j-1]) {
					swap(j);
					exNum++;
					lastSwap = j-1;
				}
			}
			if(exNum==0) break;
			i = lastSwap;
		}
	}
	
	public static void swap(int value) {
		int tmp = arr[value];
		arr[value] = arr[value-1];
		arr[value-1] = tmp;
	}
	
	public static void print() {
		for( int value : arr) {
			System.out.println(value);
		}
	}
	

}

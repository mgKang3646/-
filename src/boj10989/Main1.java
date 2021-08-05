package boj10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 퀵 정렬
public class Main1 {
	
	private static int[] arr;
	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		setObjects();
		makeArr();
		initializeArr();
		doQuickSort(0,arr.length-1);
		printArr();
		closeBufferedIO();

	}
	
	public static void setObjects() {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
	}
	
	public static void makeArr() throws NumberFormatException, IOException {
		int size = Integer.parseInt(br.readLine());
		arr = new int[size];
	}
	
	public static void initializeArr() throws NumberFormatException, IOException {
		for(int i=0; i<arr.length;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	}
	
	public static void doQuickSort(int left, int right) {
		int pLeft = left;
		int pRight = right;
		int pivot = arr[(left+right)/2];
		
		while( pLeft <= pRight) {
			while(arr[pLeft] < pivot ) pLeft++;
			while(arr[pRight] > pivot ) pRight--;
			
			if(pLeft <= pRight) swap(pLeft++,pRight--);
		}
		
		if( left < pRight ) doQuickSort(left,pRight);
		if( pLeft < right ) doQuickSort(pLeft,right);
	}
		
	public static void swap(int pLeft, int pRight) {
		int tmp = arr[pLeft];
		arr[pLeft] = arr[pRight];
		arr[pRight] = tmp;
	}
	
	public static void printArr() throws IOException {
		for(int value : arr) {
			sb.append(value).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void closeBufferedIO() throws IOException {
		bw.close();
		br.close();
	}
	
}

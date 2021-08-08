package boj2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main5 {
	//힙정렬
	
	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringBuilder sb;
	
	private static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		createObjects();
		createArr();
		initializeArr();
		doHeapSort();
		printArr();
		closeIO();

	}
	
	public static void createObjects() {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
	}
	
	public static void createArr() throws NumberFormatException, IOException {
		int size = Integer.parseInt(br.readLine());
		arr = new int[size];
	}
	
	public static void initializeArr() throws NumberFormatException, IOException {
		for ( int i = 0; i< arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	}
	
	public static void doHeapSort() {
		int lastIndex = arr.length - 1;
		int lastParent = ( lastIndex - 1 ) / 2;
		
		for( int i = lastParent; i >= 0; i--) {
			doHeap(i,lastIndex);
		}
		
		for( int i = lastIndex; i>0; i--) {
			swap(0,i);
			doHeap(0,i-1);
		}
	}
	
	public static void doHeap(int value, int lastIndex) {
		int pivot = arr[value];
		int parent;
		int child = 0;
		
		for( parent = value; parent <= (double)(lastIndex - 1)/2; parent = child) {
			int leftChild = 2*parent + 1;
			int rightChild = leftChild + 1;
			
			if( rightChild > lastIndex) child = leftChild;
			else {
				child = arr[leftChild] > arr[rightChild] ? leftChild : rightChild;
			}
			
			if(pivot >= arr[child])break;
			else {
				arr[parent] = arr[child];
			}
		}
		arr[parent] = pivot;
	}
	
	public static void swap(int value1, int value2) {
		int tmp = arr[value1];
		arr[value1] = arr[value2];
		arr[value2] = tmp;
	}
	
	public static void printArr() throws IOException {
		for(int value : arr) {
			sb.append(value).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void closeIO() throws IOException {
		bw.close();
		br.close();
	}
	
}

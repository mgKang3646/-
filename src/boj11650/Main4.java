package boj11650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main4 {
	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringBuilder sb;
	private static StringTokenizer stz;
	
	private static int[][] arr;
	
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
		arr = new int[size][2];
	}
	
	public static void initializeArr() throws IOException {
		for(int i=0; i<arr.length;i++) {
			stz = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(stz.nextToken());
			arr[i][1] = Integer.parseInt(stz.nextToken());
		}
	}
	
	public static void doHeapSort() {
		
		int lastChildIndex = arr.length - 1;
		int lastParentIndex = ( lastChildIndex - 1 )/2;
		
		for(int i = lastParentIndex; i >= 0; i--) {
			makeHeap(i,lastChildIndex);
		}
		
		for(int i = arr.length-1; i > 0; i--) {
			swap(0,i);
			makeHeap(0,i-1);
		}
	}
	
	public static void makeHeap(int pivotIndex, int lastChildIndex) {
		int pivotX = arr[pivotIndex][0];
		int pivotY = arr[pivotIndex][1];
		int childIndex = 0;
		int parentIndex = 0;
		
		for(parentIndex = pivotIndex; parentIndex < (lastChildIndex + 1)/2; parentIndex = childIndex) {
			
			int leftChildIndex = 2*parentIndex + 1;
			int rightChildIndex = leftChildIndex + 1;
			
			if(rightChildIndex > lastChildIndex) childIndex = leftChildIndex;
			else {
				if(arr[leftChildIndex][0] > arr[rightChildIndex][0]) childIndex = leftChildIndex;
				else if(arr[leftChildIndex][0] == arr[rightChildIndex][0]) {
					childIndex = arr[leftChildIndex][1] > arr[rightChildIndex][1] ? leftChildIndex : rightChildIndex;
				}
				else childIndex = rightChildIndex;
			}
			
			if(pivotX > arr[childIndex][0]) break;
			else if(arr[childIndex][0] == pivotX ) {
				if( pivotY > arr[childIndex][1]) break;
			}
			
			arr[parentIndex][0] = arr[childIndex][0];
			arr[parentIndex][1] = arr[childIndex][1];
		
		}
		
		arr[parentIndex][0] = pivotX;
		arr[parentIndex][1] = pivotY;
		
	}
	
	public static void swap(int root, int index) {
		int tmpX = arr[root][0];
		int tmpY = arr[root][1];
		
		arr[root][0] = arr[index][0];
		arr[root][1] = arr[index][1];
		
		arr[index][0] = tmpX;
		arr[index][1] = tmpY;
	}
	
	public static void printArr() throws IOException {
		for(int i =0; i < arr.length; i++) {
			sb.append(arr[i][0]+" "+arr[i][1]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void closeIO() throws IOException {
		br.close();
		bw.close();
	}

}

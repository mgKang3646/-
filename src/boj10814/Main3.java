package boj10814;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main3 {
	
	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringBuilder sb;
	private static StringTokenizer stz;
	private static int[][] arr;
	private static String[] nameArr;
	
	public static void main(String[] args) throws IOException {
		initializeIO();
		makeArr();
		initializeArr();
		doHeapSort();
		printArr();
		closeIO();
	}
	
	public static void initializeIO() {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	public static void makeArr() throws IOException {
		stz = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(stz.nextToken());
		arr = new int[size][2];
		nameArr = new String[size];
	}
	
	public static void initializeArr() throws IOException {
		for(int i=0; i<arr.length; i++) {
			stz = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(stz.nextToken());
			arr[i][1] = i;
			nameArr[i] = stz.nextToken();
		}
	}
	
	public static void doHeapSort() {
		int lastChildIndex = arr.length - 1;
		int lastParentIndex = (lastChildIndex-1)/2;
		
		for(int i = lastParentIndex; i >=0; i--) {
			makeHeap(i,lastChildIndex);
		}
		
		for(int i = arr.length-1; i>0; i--) {
			swap(i);
			makeHeap(0,i-1);
		}
	}
	
	public static void makeHeap(int pivotIndex, int lastChildIndex) {
		int pivotAge = arr[pivotIndex][0];
		int pivotEnroll = arr[pivotIndex][1];
		int parentIndex = pivotIndex;
		int childIndex = 0;
		
		for(parentIndex = pivotIndex; parentIndex < (lastChildIndex + 1)/2; parentIndex = childIndex) {
			int leftChildIndex = 2*parentIndex +1;
			int rightChildIndex = leftChildIndex + 1;
			
			if(rightChildIndex > lastChildIndex) childIndex = leftChildIndex;
			else {
				if(arr[leftChildIndex][0] > arr[rightChildIndex][0]) childIndex = leftChildIndex;
				else if(arr[leftChildIndex][0] == arr[rightChildIndex][0]) {
					if(arr[leftChildIndex][1] > arr[rightChildIndex][1]) childIndex = leftChildIndex;
					else childIndex = rightChildIndex;
				}
				else childIndex = rightChildIndex;
			}
			
			if(pivotAge > arr[childIndex][0]) break;
			else if(pivotAge == arr[childIndex][0]) {
				if(pivotEnroll > arr[childIndex][1]) break;
				else {
					arr[parentIndex][0] = arr[childIndex][0];
					arr[parentIndex][1] = arr[childIndex][1];
				}
			}
			else {
				arr[parentIndex][0] = arr[childIndex][0];
				arr[parentIndex][1] = arr[childIndex][1];
			}
		}
		arr[parentIndex][0] = pivotAge;
		arr[parentIndex][1] = pivotEnroll;
	}
	
	public static void swap(int index) {
		int tmpAge = arr[index][0];
		int tmpEnroll = arr[index][1];
		arr[index][0] = arr[0][0];
		arr[index][1] = arr[0][1];
		arr[0][0] = tmpAge;
		arr[0][1] = tmpEnroll;
	}
	
	
	
	public static void printArr() throws IOException {
		sb = new StringBuilder();
		for(int i =0; i<arr.length; i++) {
			sb.append(arr[i][0]).append(" ").append(nameArr[arr[i][1]]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void closeIO() throws IOException {
		bw.close();
		br.close();
	}
}

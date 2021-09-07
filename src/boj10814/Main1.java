package boj10814;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1 {
	
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
		doQuickSort(0,arr.length-1);
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
	
	public static void doQuickSort(int leftIndex, int rightIndex) {
		int leftPointer = leftIndex;
		int rightPointer = rightIndex;
		int center = (leftIndex + rightIndex)/2;
		int pivot = arr[center][0];
		int pivotEnroll = arr[center][1];
		
		while(leftPointer <= rightPointer) {
			while(arr[leftPointer][0] <= pivot) {
				if(arr[leftPointer][0] == pivot) {
					if(arr[leftPointer][1] < pivotEnroll) leftPointer++;
					else break;
				}
				else leftPointer++;
			}
			while(arr[rightPointer][0] >= pivot) {
				if(arr[rightPointer][0] == pivot) {
					if(arr[rightPointer][1] > pivotEnroll ) rightPointer--;
					else break;
				}
				else rightPointer--;
			}
			
			if(leftPointer <= rightPointer) swap(leftPointer++, rightPointer--);
		}
		
		if(leftIndex < rightPointer) doQuickSort(leftIndex,rightPointer);
		if(leftPointer < rightIndex) doQuickSort(leftPointer,rightIndex);
		
	}
	
	public static void swap(int leftPointer, int rightPointer) {
		int tmpAge = arr[leftPointer][0];
		int tmpEnroll = arr[leftPointer][1];
		arr[leftPointer][0] = arr[rightPointer][0];
		arr[leftPointer][1] = arr[rightPointer][1];
		arr[rightPointer][0] = tmpAge;
		arr[rightPointer][1] = tmpEnroll;
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

package boj11650;

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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		createObjects();
		createArr();
		initializeArr();
		doQuickSort(0,arr.length-1);
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
	
	public static void doQuickSort(int left, int right) {
		
		int leftPointer = left;
		int rightPointer = right;
		int pivotX = arr[(left+right)/2][0];
		int pivotY = arr[(left+right)/2][1];
		
		do {
			
			while(arr[leftPointer][0] <= pivotX ) {
				if(arr[leftPointer][0] == pivotX) {
					if(arr[leftPointer][1] < pivotY) leftPointer++;
					else break;
				}else {
					leftPointer++;
				}
			}
			
			while(arr[rightPointer][0] >= pivotX ) {
				if(arr[rightPointer][0] == pivotX) {
					if(arr[rightPointer][1] > pivotY) rightPointer--;
					else break;
				}else {
					rightPointer--;
				}
			}
			
			if(leftPointer <= rightPointer) {
				swap(leftPointer++, rightPointer--);
			}
			
		}while(leftPointer <= rightPointer);
		
		if(left < rightPointer) doQuickSort(left,rightPointer);
		if(leftPointer < right) doQuickSort(leftPointer,right);
	}
	
	public static void swap(int leftPointer, int rightPointer) {
		int tmpX = arr[leftPointer][0];
		int tmpY = arr[leftPointer][1];
		
		arr[leftPointer][0] = arr[rightPointer][0];
		arr[leftPointer][1] = arr[rightPointer][1];
		arr[rightPointer][0] = tmpX;
		arr[rightPointer][1] = tmpY;
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

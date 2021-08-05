package boj10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 병합 정렬
public class Main2 {

	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringBuilder sb;
	
	private static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		createObjects();
		makeArr();
		initializeArr();
		doMergeSort(0,arr.length-1);
		printArr();
		closeBufferedIO();
	}
	
	public static void createObjects() {
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
	
	public static void doMergeSort(int left, int right) throws IOException {
		
		if(left < right) {
			int center = (left + right)/2;
			// 선 분할
			doMergeSort(left,center);
			doMergeSort(center+1,right);
			
			// 후 병합 알고리즘 적용
			applyMergeSort(left,right);
			
		}
	}
	
	public static void applyMergeSort(int left, int right) {
		
		int[] leftArr = new int[right - left +1];
		int center = (left+right)/2;
		int leftArrSize = 0;
		
		int arrPointer = left;
		int rightPointer = center+1;
		int leftPointer = 0;
		
		for(int i=left; i<=center;i++) {
			leftArr[leftArrSize++] = arr[i];
		}
		
		for(arrPointer = left; arrPointer <= right; arrPointer++) {
			if(leftPointer < leftArrSize && rightPointer <= right) {
				arr[arrPointer] = leftArr[leftPointer] < arr[rightPointer] ? leftArr[leftPointer++] : arr[rightPointer++];
			}else {
				break;
			}
		}
		
		while(leftPointer < leftArrSize) {
			arr[arrPointer++] = leftArr[leftPointer++];
		}
	}
	
	public static void printArr() throws IOException {
		sb = new StringBuilder();
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

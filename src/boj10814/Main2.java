package boj10814;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {
	
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
		doMergeSort(0,arr.length-1);
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
	
	public static void doMergeSort(int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int center = (leftIndex + rightIndex)/2;
			doMergeSort(leftIndex,center);
			doMergeSort(center+1,rightIndex);
			
			doMerge(leftIndex,rightIndex);
		}
	}
	
	public static void doMerge(int leftIndex, int rightIndex) {
		int[][] leftArr = new int[(rightIndex - leftIndex +1)][2];
		int center = (leftIndex + rightIndex)/2;
		int leftArrSize = 0; 
		int leftPointer = 0;
		int rightPointer = center+1;
		int arrPointer = leftIndex;
		
		for(int i = leftIndex; i <= center;i++) {
			leftArr[leftArrSize][0] = arr[i][0];
			leftArr[leftArrSize++][1] = arr[i][1];
		}
		
		for(arrPointer = leftIndex; arrPointer <= rightIndex; arrPointer++) {
			if(leftPointer < leftArrSize && rightPointer <= rightIndex) {
				if(leftArr[leftPointer][0] < arr[rightPointer][0]) {
					arr[arrPointer][0] = leftArr[leftPointer][0];
					arr[arrPointer][1] = leftArr[leftPointer++][1];
				}
				
				else if(leftArr[leftPointer][0] == arr[rightPointer][0]) {
					if(leftArr[leftPointer][1] < arr[rightPointer][1]) {
						arr[arrPointer][0] = leftArr[leftPointer][0];
						arr[arrPointer][1] = leftArr[leftPointer++][1];
					}
					else {
						arr[arrPointer][0] = arr[rightPointer][0];
						arr[arrPointer][1] = arr[rightPointer++][1];
					}
				}
				else {
					arr[arrPointer][0] = arr[rightPointer][0];
					arr[arrPointer][1] = arr[rightPointer++][1];
				}
			}
			else break;
		}
		
		while(leftPointer < leftArrSize) {
			arr[arrPointer][0] = leftArr[leftPointer][0];
			arr[arrPointer++][1] = leftArr[leftPointer++][1];
		}
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

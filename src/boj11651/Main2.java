package boj11651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//병합정렬
public class Main2 {

	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringBuilder sb;
	private static StringTokenizer stz;
	
	private static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		createObjects();
		makeArr();
		initializeArr();
		doMergeSort(0,arr.length-1);
		printArr();
		closeIO();
	}
	
	public static void createObjects() {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
	}

	public static void makeArr() throws NumberFormatException, IOException {
		int size = Integer.parseInt(br.readLine());
		arr = new int[size][2];
	}
	
	public static void initializeArr() throws IOException {
		for(int i=0; i<arr.length; i++) {
			stz = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(stz.nextToken());
			arr[i][1] = Integer.parseInt(stz.nextToken());
		}
	}
	
	public static void doMergeSort(int left, int right) {
		if(left < right) {
			int center = (left + right)/2;
			doMergeSort(left,center);
			doMergeSort(center+1,right);
			
			applyMerge(left,right);
			
		}
	}
	
	public static void applyMerge(int left, int right) {
		int center = (left + right)/2;
		int[][] leftArr = new int[right - left +1][2];
		
		int arrPointer = 0;
		int leftPointer = 0;
		int rightPointer = center + 1;
		int leftSize = 0;
		
		for(int i = left; i<=center; i++) {
			leftArr[leftSize][0] = arr[i][0];
			leftArr[leftSize++][1] = arr[i][1];
		}
		
		for(arrPointer = left; arrPointer <= right; arrPointer ++) {
			if(leftPointer < leftSize && rightPointer <= right) {
				if(leftArr[leftPointer][1] < arr[rightPointer][1]) {
					arr[arrPointer][0] = leftArr[leftPointer][0];
					arr[arrPointer][1] = leftArr[leftPointer++][1];
				}
				else if (leftArr[leftPointer][1]  == arr[rightPointer][1]) {
					if(leftArr[leftPointer][0] < arr[rightPointer][0]) {
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
		
		while(leftPointer < leftSize) {
			arr[arrPointer][0]= leftArr[leftPointer][0];
			arr[arrPointer++][1] = leftArr[leftPointer++][1];
		}
		
	}
	
	public static void printArr() throws IOException {
		for(int i=0; i<arr.length;i++) {
			sb.append(arr[i][0]+ " " + arr[i][1]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void closeIO() throws IOException {
		bw.close();
		br.close();
	}
}

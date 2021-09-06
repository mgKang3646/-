package boj1181;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main2 {
	private static BufferedReader bufferedReader;
	private static BufferedWriter bufferedWriter;
	private static StringBuilder sb;
	private static StringTokenizer stz;
	private static int size;
	private static String[] arr;

	public static void main(String[] args) throws IOException {
		initializeIO();
		getSize();
		initializeArr();
		doMergeSort(0,arr.length-1);
		printArr();
		closeIO();
	}
	
	public static void initializeIO() {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	public static void getSize() throws IOException {
			stz = new StringTokenizer(bufferedReader.readLine());
			size = Integer.parseInt(stz.nextToken());
	}
	
	public static void initializeArr() throws IOException {
		HashSet<String> hs = new HashSet<String>();
		for(int i=0; i < size; i++) {
			stz = new StringTokenizer(bufferedReader.readLine());
			hs.add(stz.nextToken());
		}
		
		Iterator<String> iterator = hs.iterator();
		arr = new String[hs.size()];
		int i = 0;
		
		while(iterator.hasNext()) {
			arr[i++] = iterator.next();
		}
	}
	
	public static void doMergeSort(int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int center = (leftIndex + rightIndex)/2;
			doMergeSort(leftIndex,center);
			doMergeSort(center+1,rightIndex);
			
			doMerge(leftIndex, rightIndex);
		}
	}
	
	public static void doMerge(int leftIndex, int rightIndex) {
		String[] leftArr = new String[rightIndex - leftIndex +1];
		int center = (leftIndex + rightIndex)/2;
		int leftArrSize = 0;
		int leftArrPointer = 0;
		int rightArrPointer = center + 1;
		int arrPointer = leftIndex;
		
		for(int i = leftIndex; i<=center; i++ ) {
			leftArr[leftArrSize++] = arr[i];
		}
		
		for(arrPointer = leftIndex; arrPointer <= rightIndex; arrPointer++) {
			if(leftArrPointer < leftArrSize && rightArrPointer <= rightIndex) {
				if(leftArr[leftArrPointer].length() < arr[rightArrPointer].length()) arr[arrPointer] = leftArr[leftArrPointer++];
				else if(leftArr[leftArrPointer].length() == arr[rightArrPointer].length()) {
					if(isSmaller(leftArr[leftArrPointer],arr[rightArrPointer])) arr[arrPointer] = leftArr[leftArrPointer++];
					else arr[arrPointer] = arr[rightArrPointer++];
				}
				else arr[arrPointer] = arr[rightArrPointer++];
			}else break;
		}
		
		while(leftArrPointer < leftArrSize) {
			arr[arrPointer++] = leftArr[leftArrPointer++];
		}
	}
	
	public static boolean isSmaller(String value1, String value2) {
		for(int i =0; i < value1.length(); i++) {
			if(value1.charAt(i) < value2.charAt(i)) return true;
			else if(value1.charAt(i) > value2.charAt(i)) return false;
		}
		return false;
	}
	
	public static void printArr() throws IOException {
		sb = new StringBuilder();
		for(String value : arr) {
			sb.append(value).append("\n");
		}
		bufferedWriter.write(sb.toString());
		bufferedWriter.flush();
	}
	
	public static void closeIO() throws IOException {
		bufferedReader.close();
		bufferedWriter.close();
	}
}

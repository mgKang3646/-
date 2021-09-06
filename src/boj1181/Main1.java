package boj1181;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main1 {
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
		doQuickSort(0,arr.length-1);
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
	
	public static void doQuickSort(int leftIndex, int rightIndex) {
		int leftPointer = leftIndex;
		int rightPointer = rightIndex;
		String pivot = arr[(leftIndex + rightIndex)/2];
		
		while(leftPointer <= rightPointer) {
			while(arr[leftPointer].length() <= pivot.length()) {
				if(arr[leftPointer].length() == pivot.length()) {
					if(isSmaller(arr[leftPointer],pivot)) leftPointer++;
					else break;
				}
				else leftPointer++;
			}
			while(arr[rightPointer].length() >= pivot.length()) {
				if(arr[rightPointer].length() == pivot.length()) {
					if(isBigger(arr[rightPointer],pivot)) rightPointer--;
					else break;
				}
				else rightPointer--;
			}
			
			if(leftPointer <= rightPointer) swap(leftPointer++,rightPointer--);
		}
		
		if(leftIndex < rightPointer) doQuickSort(leftIndex,rightPointer);
		if(leftPointer < rightIndex) doQuickSort(leftPointer,rightIndex);
	}
	
	public static void swap(int leftPointer, int rightPointer) {
		String tmp = arr[leftPointer];
		arr[leftPointer] = arr[rightPointer];
		arr[rightPointer] = tmp;
	}
	
	public static boolean isSmaller(String value, String pivot) {
		for(int i =0; i < value.length(); i++) {
			if(value.charAt(i) < pivot.charAt(i)) return true;
			else if(value.charAt(i) > pivot.charAt(i)) return false;
		}
		return false;
	}
	
	public static boolean isBigger(String value, String pivot) {
		for(int i =0; i < value.length(); i++) {
			if(value.charAt(i) > pivot.charAt(i)) return true;
			else if(value.charAt(i) < pivot.charAt(i)) return false;
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

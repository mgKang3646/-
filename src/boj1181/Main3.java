package boj1181;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main3 {
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
		doHeapSort(0,arr.length-1);
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
	
	public static void doHeapSort(int leftIndex, int rightIndex) {
		int lastChildIndex = arr.length - 1;
		int lastParentIndex = (lastChildIndex -1)/2;
		
		for( int i = lastParentIndex; i >= 0; i--) {
			makeHeap(i,lastChildIndex);
		}
		
		for( int i = arr.length -1; i > 0; i--) {
			swap(i);
			makeHeap(0,i-1);
		}
	}
	
	public static void makeHeap(int pivotIndex, int lastChildIndex) {
		String pivot = arr[pivotIndex];
		int parentIndex = pivotIndex;
		int childIndex = 0;
		
		for(parentIndex = pivotIndex; parentIndex < (lastChildIndex + 1)/2; parentIndex = childIndex) {
			
			int leftChildIndex = 2*parentIndex +1;
			int rightChildIndex = leftChildIndex + 1;
			
			if(rightChildIndex > lastChildIndex) childIndex = leftChildIndex;
			else {
				if(arr[leftChildIndex].length() > arr[rightChildIndex].length()) childIndex = leftChildIndex;
				else if(arr[leftChildIndex].length() == arr[rightChildIndex].length()) {
					if(isBigger(arr[leftChildIndex],arr[rightChildIndex])) childIndex = leftChildIndex;
					else childIndex = rightChildIndex;
				}
				else childIndex = rightChildIndex;
			}
			
			if(pivot.length() > arr[childIndex].length()) break;
			else if(pivot.length() == arr[childIndex].length()) {
				if(isBigger(pivot,arr[childIndex])) break;
				else arr[parentIndex] = arr[childIndex];
			}
			else arr[parentIndex] = arr[childIndex];
		}
		arr[parentIndex] = pivot;
	}
	
	public static void swap(int index) {
		String tmp = arr[index];
		arr[index] = arr[0];
		arr[0] = tmp;
	}
	
	public static boolean isBigger(String value1, String value2) {
		for(int i =0; i < value1.length(); i++) {
			if(value1.charAt(i) > value2.charAt(i)) return true;
			else if(value1.charAt(i) < value2.charAt(i)) return false;
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

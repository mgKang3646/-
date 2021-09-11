package boj18870;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringBuilder sb;
	private static StringTokenizer stz;
	
	private static int[] originalArr;
	private static int[] sortArr;
	private static HashSet<Integer> hs;
	private static HashMap<Integer,Integer> bridge;
	
	public static void main(String[] args) throws IOException {
		initializeIO();
		makeArr();
		doQuickSort(0,sortArr.length-1);
		setHashMap();
		printArr();
		closeIO();
	}
	
	public static void initializeIO() {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	public static void makeArr() throws IOException {
		int size = getSize();
		originalArr = new int[size];
		hs = new HashSet<Integer>();
		stz = new StringTokenizer(br.readLine());
		
		for(int i=0; i<size; i++) {
			int value = Integer.parseInt(stz.nextToken());
			originalArr[i] = value;
			hs.add(value);
		}
		
		sortArr = new int[hs.size()];
		int i = 0;
		
		Iterator<Integer> iterator = hs.iterator();
		while(iterator.hasNext()) {
			int value = iterator.next();
			sortArr[i++] = value;
		}
	}
	
	public static void setHashMap() {
		bridge = new HashMap<Integer,Integer>();
		for(int i =0; i < sortArr.length; i++) {
			bridge.put(sortArr[i], i);
		}
	}
	
	public static int getSize() throws IOException {
		stz = new StringTokenizer(br.readLine());
		return Integer.parseInt(stz.nextToken());
	}
	
	public static void doQuickSort(int leftIndex, int rightIndex) {
		int leftPointer = leftIndex;
		int rightPointer = rightIndex;
		int pivot = sortArr[(leftIndex+rightIndex)/2];
		
		while(leftPointer <= rightPointer) {
			while(sortArr[leftPointer] < pivot) leftPointer++;
			while(sortArr[rightPointer] > pivot) rightPointer--;
			
			if(leftPointer <= rightPointer) swap(leftPointer++,rightPointer--);
		}
		
		if(leftIndex < rightPointer) doQuickSort(leftIndex,rightPointer);
		if(leftPointer < rightIndex) doQuickSort(leftPointer,rightIndex);
	}
	
	public static void swap(int leftPointer, int rightPointer) {
		int tmpValue = sortArr[leftPointer];
		sortArr[leftPointer] = sortArr[rightPointer];
		sortArr[rightPointer] = tmpValue;
	}
	
	
	public static void printArr() throws IOException {
		sb = new StringBuilder();
		for(int key : originalArr) {
			sb.append(bridge.get(key)+"").append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void closeIO() throws IOException {
		bw.close();
		br.close();
	}
}

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

public class Main1 {
	
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
		doMergeSort(0,sortArr.length-1);
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
	
	public static void doMergeSort(int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int center = (leftIndex + rightIndex) / 2 ;
			doMergeSort(leftIndex,center);
			doMergeSort(center+1,rightIndex);
			
			doMerge(leftIndex,rightIndex);
		}
	}
	
	public static void doMerge(int leftIndex, int rightIndex) {
		int[] leftArr = new int[rightIndex - leftIndex + 1];
		
		int center = (rightIndex + leftIndex)/2;
		int leftPointer = 0;
		int rightPointer = center + 1;
		int arrPointer = leftIndex;
		int leftArrSize = 0;
		
		for(int i = leftIndex; i <= center; i++) {
			leftArr[leftArrSize++] = sortArr[i];
		}
		
		for(arrPointer = leftIndex; arrPointer <= rightIndex; arrPointer++) {
			if(leftPointer < leftArrSize && rightPointer <= rightIndex) {
				sortArr[arrPointer] = leftArr[leftPointer] < sortArr[rightPointer] ? leftArr[leftPointer++] : sortArr[rightPointer++];
			}else break;
		}
		
		while(leftPointer < leftArrSize) {
			sortArr[arrPointer++] = leftArr[leftPointer++];
		}
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

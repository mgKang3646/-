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

public class Main2 {
	
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
		doHeapSort();
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
	
	public static void doHeapSort() {
		int lastChildIndex = sortArr.length - 1;
		int lastParentIndex = (lastChildIndex - 1)/2;
		
		for(int i = lastParentIndex; i >= 0; i--) {
			makeHeap(i,lastChildIndex);
		}
		
		for(int i = lastChildIndex; i > 0; i--) {
			swap(i);
			makeHeap(0,i-1);
		}
		
	}
	
	public static void makeHeap(int pivotIndex, int lastChildIndex) {
		int pivot = sortArr[pivotIndex];
		int parentIndex = 0;
		int childIndex = 0;
		
		for( parentIndex = pivotIndex; parentIndex < (lastChildIndex + 1)/2; parentIndex = childIndex){
			int leftChildIndex = 2*parentIndex + 1;
			int rightChildIndex = leftChildIndex + 1;
			
			if(lastChildIndex < rightChildIndex) childIndex = leftChildIndex;
			else {
				if(sortArr[leftChildIndex] > sortArr[rightChildIndex]) childIndex = leftChildIndex;
				else childIndex = rightChildIndex;
			}
			
			if(sortArr[parentIndex] > sortArr[childIndex]) break;
			else sortArr[parentIndex] = sortArr[childIndex];
		}
		sortArr[parentIndex] = pivot;
	}
	
	public static void swap(int index) {
		int tmp = sortArr[index];
		sortArr[index] = sortArr[0];
		sortArr[0] = tmp;
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

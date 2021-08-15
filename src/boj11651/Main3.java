package boj11651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//힙정렬
public class Main3 {

	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringBuilder sb;
	private static StringTokenizer stz;
	
	private static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		createObjects();
		makeArr();
		initializeArr();
		doHeapSort();
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
	
	public static void doHeapSort() {
		int lastChildIndex = arr.length -1;
		int lastParentIndex = ( lastChildIndex - 1 ) /2;
		
		for(int i = lastParentIndex; i>=0; i--) {
			makeHeap(i,lastChildIndex);
		}
		
		for(int i = arr.length-1; i > 0;i--) {
			swap(0,i);
			makeHeap(0,i-1);
		}
	}
	
	public static void makeHeap(int pivotIndex,int lastChildIndex) {
		int tmpX = arr[pivotIndex][0];
		int tmpY = arr[pivotIndex][1];
		int parentIndex = pivotIndex;
		int childIndex = 0;
		
		for(parentIndex = pivotIndex; parentIndex < (lastChildIndex + 1)/2; parentIndex = childIndex) {
			int leftChildIndex = 2*parentIndex + 1;
			int rightChildIndex = leftChildIndex + 1;
			
			if(rightChildIndex > lastChildIndex) childIndex = leftChildIndex;
			else {
				if(arr[leftChildIndex][1] > arr[rightChildIndex][1]) {
					childIndex = leftChildIndex;
				}
				else if(arr[leftChildIndex][1] == arr[rightChildIndex][1]) {
					if(arr[leftChildIndex][0] > arr[rightChildIndex][0]) {
						childIndex = leftChildIndex;
					}
					else {
						childIndex = rightChildIndex;
					}
				}else {
					childIndex = rightChildIndex;
				}
			}
			
			if(arr[childIndex][1] < tmpY ) break;
			else if(arr[childIndex][1] == tmpY) {
				if(arr[childIndex][0] < tmpX) break;
			}
			
			arr[parentIndex][0] = arr[childIndex][0];
			arr[parentIndex][1] = arr[childIndex][1];
		}
		
		arr[parentIndex][0] = tmpX;
		arr[parentIndex][1] = tmpY;
		
	}
	
	public static void swap(int root, int lastIndex) {
		int tmpX = arr[root][0];
		int tmpY = arr[root][1];
		arr[root][0] = arr[lastIndex][0];
		arr[root][1] = arr[lastIndex][1];
		arr[lastIndex][0] = tmpX;
		arr[lastIndex][1] = tmpY;
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

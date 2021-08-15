package boj11651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//퀵정렬
public class Main1 {

	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringBuilder sb;
	private static StringTokenizer stz;
	
	private static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		createObjects();
		makeArr();
		initializeArr();
		doQuickSort(0,arr.length-1);
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
	
	public static void doQuickSort(int left, int right) {
		Stack<Integer> leftStack = new Stack<Integer>();
		Stack<Integer> rightStack = new Stack<Integer>();
		
		leftStack.push(left);
		rightStack.push(right);
		
		while(!leftStack.isEmpty()) {
			int leftPointer = left = leftStack.pop();
			int rightPointer = right = rightStack.pop();
			int center = (left + right)/2;
			int pivotX = arr[center][0];
			int pivotY = arr[center][1];
			
			while(leftPointer <= rightPointer) {
				while(arr[leftPointer][1] <= pivotY) {
					if(arr[leftPointer][1] == pivotY) {
						if(arr[leftPointer][0] < pivotX) leftPointer++;
						else break;
					}
					else {
						leftPointer++;
					}
				}
				
				while(arr[rightPointer][1] >= pivotY) {
					if(arr[rightPointer][1] == pivotY) {
						if(arr[rightPointer][0] > pivotX) rightPointer--;
						else break;
					}
					else {
						rightPointer--;
					}
				}
				
				if(leftPointer <= rightPointer) swap(leftPointer++,rightPointer--);
			}
			
			if(left < rightPointer) {
				leftStack.push(left);
				rightStack.push(rightPointer);
			}
			if(leftPointer < right) {
				leftStack.push(leftPointer);
				rightStack.push(right);
			}
		}
	}
	
	public static void swap(int leftPointer,int rightPointer) {
		int tmpX = arr[leftPointer][0];
		int tmpY = arr[leftPointer][1];
		arr[leftPointer][0] = arr[rightPointer][0];
		arr[leftPointer][1] = arr[rightPointer][1];
		arr[rightPointer][0] = tmpX;
		arr[rightPointer][1] = tmpY;
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

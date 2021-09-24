package boj1874;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	public static Stack<Integer> stack = new Stack<Integer>();

	public static int[] arr;

	public static void main(String[] args) {
		makeArr();
		mainProcess();
		printResult();
	}
	
	public static void makeArr() {
		int size = sc.nextInt();
		arr = new int[size];
		
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
	}
	
	public static void mainProcess() {
		int pivot = 0;
		int nextIndex = 0;
		
		for(int i=0; i<arr.length; i = nextIndex) {
			pushProcess(pivot,arr[i]);
			nextIndex = popProcess(i);
			if(!isValid()) break;
			pivot = arr[i];
		}
	}
	
	public static void pushProcess(int start, int end) {
			for(int j= start+1; j <= end; j++) {
				stack.push(j);
				sb.append("+").append("\n");
			}
	}
	
	public static int popProcess(int startIndex) {
		int nextIndex = startIndex;
		
		while( nextIndex < arr.length && arr[nextIndex] <= arr[startIndex] ) {
			if( stack.peek() == arr[nextIndex]) {
				stack.pop();
				sb.append("-").append("\n");
				nextIndex++;
			}else {
				sb = null;
				break;
			}
		}
		return nextIndex;
	}
	
	public static boolean isValid() {
		if(sb == null) {
			sb = new StringBuilder();
			sb.append("NO");
			return false;
		}
		else return true;
	}
	
	public static void printResult() {
		System.out.println(sb.toString());
	}

}

package boj2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
	// 병합정렬 https://www.acmicpc.net/board/view/31887
	private static int[] arr;
	private static BufferedReader br;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException { 
		makeArr();
		initializeArr();
		mergeSort(0,arr.length-1);
		printArr();
	}
	
	public static void makeArr() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		arr = new int[size];
	}
	
	public static void initializeArr() throws NumberFormatException, IOException {
		for(int i=0; i<arr.length;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		suffle();
	}
	
	public static void mergeSort(int left, int right) {
		if(left < right) {
			int center = (left+right)/2;
			
			mergeSort(left,center);
			mergeSort(center+1,right);
			
			int[] buff = new int[right-left+1]; // arr.length면 만약 arr.length(N)가 졸라게 크면 계속 그만큼을 반복적으로 만들어주어야 한다. O(N^2) right-left+1 이렇게 크기를 제한하는게 중요
			int buffSize = 0;
			int buffCount = 0;
			int arrCount = left;
			int i = 0;
			
			while(arrCount <= center) {
				buff[buffSize++] = arr[arrCount++];
			}
			
			for(i=left;i<=right;i++) {
				if(buffCount < buffSize && arrCount <= right) {
					arr[i] = buff[buffCount] < arr[arrCount] ? buff[buffCount++] : arr[arrCount++];
				}else {
					break;
				}
			}
			while(buffCount < buffSize) {
				arr[i++] = buff[buffCount++];
			}
		}
	}
	
	public static void printArr() {
		sb = new StringBuilder();
		for( int value : arr ) {
			sb.append(value).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void suffle() {
		for(int i=0; i<5;i++) {
			int value1 = (int)(Math.random()*arr.length);
			int value2 = (int)(Math.random()*arr.length);
			swap(value1,value2);
		}
	}
	
	public static void swap(int pLeft, int pRight) {
		int tmp = arr[pLeft];
		arr[pLeft] = arr[pRight];
		arr[pRight] = tmp;
	}
}

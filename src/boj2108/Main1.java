package boj2108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//병합정렬
public class Main1 {
	
	private static final int MAX = 4000;
	private static BufferedReader bufferedReader;
	private static BufferedWriter bufferedWriter;
	private static StringBuilder stringBuilder;
	
	private static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		createObjects();
		createArr();
		initializeArr();
		doMergeSort(0,arr.length-1);
		printResult();
		closeIO();
	}
	
	public static void createObjects() {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		stringBuilder = new StringBuilder();
	}
	
	public static void createArr() throws NumberFormatException, IOException {
		int size = Integer.parseInt(bufferedReader.readLine());
		arr = new int[size];
	}
	
	public static void initializeArr() throws NumberFormatException, IOException {
		for(int i=0; i< arr.length;i++) {
			arr[i] = Integer.parseInt(bufferedReader.readLine());
		}
	}
	
	// 병합정렬 시작
	public static void doMergeSort(int left, int right) {
		if(left < right) {
			int center = ( left + right )/2;
			
			doMergeSort(left,center);
			doMergeSort(center+1,right);
			
			applyMerge(left, right);
		}
		
		
	}
	// 병합 알고리즘
	public static void applyMerge(int left, int right) {
		int[] leftArr = new int[right - left + 1];
		int leftSize = 0;
		int center = ( right + left )/2;
		int leftPointer = 0;
		int rightPointer = center+1;
		int arrPointer = left;
		
		for(int i = left; i<=center; i++) {
			leftArr[leftSize++] = arr[i];
		}
		
		for(arrPointer = left; arrPointer <= right; arrPointer++) {
			if( leftPointer < leftSize && rightPointer <= right ) {
				arr[arrPointer] = leftArr[leftPointer] < arr[rightPointer] ? leftArr[leftPointer++] : arr[rightPointer++];
			}else {
				break;
			}
		}
		
		while(leftPointer < leftSize) {
			arr[arrPointer++] = leftArr[leftPointer++];
		}
	}
	
	// 결과 출력
	public static void printResult() throws IOException {
		stringBuilder.append(getAvg()).append("\n"); // 평균
		stringBuilder.append(getMedian()).append("\n"); // 중간값
		stringBuilder.append(getMaxFrequencyValue()).append("\n"); //최빈값
		stringBuilder.append(getRange()).append("\n"); // 범위
		
		bufferedWriter.write(stringBuilder.toString());
		bufferedWriter.flush();
	}
	
	// 평균
	public static int getAvg() {
		double sum = 0;
		for( int value : arr) {
			sum += value;
		}
		return (int)Math.round(sum/arr.length);
	}
	
	// 중간값
	public static int getMedian() {
		return arr[arr.length/2];
	}
	
	//최빈값
	public static int getMaxFrequencyValue() {
		int[][] valueCountArr = new int[arr.length][2];
		int valueCountPointer = initializeValueCountArr(valueCountArr);
		return getMaxFrequencyValue(valueCountArr, valueCountPointer);
	}
	
	// 범위
	public static int getRange() {
		return arr[arr.length-1] - arr[0];
	}
	
	public static int initializeValueCountArr(int[][] valueCountArr) {
		int valueCountPointer = -1;
		int beforeValue = MAX + 1;
		
		for(int value : arr) {
			if( beforeValue == value ) {
				valueCountArr[valueCountPointer][1]++;
			}else {
				valueCountPointer++;
				valueCountArr[valueCountPointer][0] = value;
				valueCountArr[valueCountPointer][1]++;
				beforeValue = value;
			}
		}
		
		return valueCountPointer;
	}
	
	public static int getMaxFrequencyValue(int[][] valueCountArr, int valueCountPointer) {
		boolean second = true;
		int max = 0;
		int maxFrequencyValue = 0;
		
		for(int i = 0; i <= valueCountPointer; i++) {
			if( valueCountArr[i][1] > max ) {
				max = valueCountArr[i][1];
				maxFrequencyValue = valueCountArr[i][0];
				second = true;
			}else if(valueCountArr[i][1] == max ) {
				if(second) {
					maxFrequencyValue = valueCountArr[i][0];
					second = false;
				}
			}
		}
		
		return maxFrequencyValue;
	}
	
	public static void closeIO() throws IOException {
		bufferedWriter.close();
		bufferedReader.close();
	}
}

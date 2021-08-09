package boj2108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//버블정렬
public class Main {
	
	private static final int MAX = 4000;
	private static BufferedReader bufferedReader;
	private static BufferedWriter bufferedWriter;
	private static StringBuilder stringBuilder;
	
	private static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		createObjects();
		createArr();
		initializeArr();
		doBubbleSort();
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
	
	public static void doBubbleSort() {
		for(int i =0; i<arr.length-1;i++) {
			int exchangeNum = 0;
			int lastExchangeIndex = 0;
			for(int j = arr.length-1; j>i;j--) {
				if(arr[j] < arr[j-1]) {
					swap(j);
					exchangeNum++;
					lastExchangeIndex = j-1;
				}
			}
			if(exchangeNum == 0) break;
			i = lastExchangeIndex;
		}
	}
	
	public static void printResult() throws IOException {
		stringBuilder.append(getAvg()).append("\n");
		stringBuilder.append(getMiddleValue()).append("\n");
		stringBuilder.append(getMaxFrequencyValue()).append("\n");
		stringBuilder.append(getRange()).append("\n");
		
		bufferedWriter.write(stringBuilder.toString());
		bufferedWriter.flush();
	}
	
	public static void closeIO() throws IOException {
		bufferedWriter.close();
		bufferedReader.close();
	}
	
	public static void swap(int value) {
		int tmp = arr[value];
		arr[value] = arr[value-1];
		arr[value-1] = tmp;
	}
	
	public static int getAvg() {
		double sum = 0;
		for( int value : arr) {
			sum += value;
		}
		return (int)Math.round(sum/arr.length);
	}
	
	public static int getMiddleValue() {
		return arr[arr.length/2];
	}
	
	//최빈값
	public static int getMaxFrequencyValue() {
		int minValue = MAX+1;
		int maxValue = -MAX-1;
		int[] maxFrequencyArr = new int[2*MAX + 1];
		
		for( int value : arr ) {
			maxFrequencyArr[value+MAX]++;
			minValue = Math.min(minValue, value);
			maxValue = Math.max(maxValue, value);
		}
		
		boolean second = true;
		int maxFrequency = 0;
		int maxIndex = 0;
		
		for(int i = minValue + MAX; i <= maxValue + MAX; i++) {
			if(maxFrequencyArr[i] > maxFrequency) {
				maxFrequency = maxFrequencyArr[i];
				maxIndex = i;
				second = true;
			}else if(maxFrequencyArr[i] == maxFrequency) {
				if(second) {
					maxIndex = i;
					second = false;
				}
			}
		}
		
		return maxIndex - MAX;
	}

	public static int getRange() {
		return arr[arr.length-1] - arr[0];
	}
	
	public static void printArr() {
		for ( int value : arr) {
			System.out.print(value+" ");
		}
		System.out.println();
	}
	
}

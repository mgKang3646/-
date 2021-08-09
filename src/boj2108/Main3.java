package boj2108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//카운팅 정렬
public class Main3 {
	
	private static final int MAX = 4000;
	private static BufferedReader bufferedReader;
	private static BufferedWriter bufferedWriter;
	private static StringBuilder stringBuilder;
	
	private static int[] arr;
	private static int[] countingArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		createObjects();
		createArr();
		initializeArr();
		doCountingSort();
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
	
	public static int getMaxValue() {
		int max = 0;
		for(int value : arr) {
			int absValue = Math.abs(value);
			if( absValue > max ) {
				max = absValue;
			}
		}
		return max;
	}
	
	// 카운팅 시작
	public static void doCountingSort() {
		int countingMax = getMaxValue();
		countingArr = new int[countingMax*2+1];
		
		for( int value : arr) {
			countingArr[value+countingMax]++;
		}
		
		int arrPointer = 0;
		for( int i = 0; i< countingArr.length; i++ ) {
			for( int j = 0; j < countingArr[i]; j++) {
				arr[arrPointer++] = i - countingMax;
			}
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

package boj10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 카운팅 정렬
public class Main3 {
	
	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringBuilder sb;
	
	private static int[] inputArr;
	private static int[] countingArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		createObjects();
		makeArr();
		initializeArr();
		doCountingSort();
		printCountingArr();
		closeBuffedIO();
	}
	
	public static void createObjects() {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
	}
	
	public static void makeArr() throws NumberFormatException, IOException {
		int size = Integer.parseInt(br.readLine());
		inputArr = new int[size];
	}
	
	public static void initializeArr() throws NumberFormatException, IOException {
		for(int i =0; i< inputArr.length; i++) {
			inputArr[i] = Integer.parseInt(br.readLine());
		}
	}
	
	public static int getMaxOnInputArr() {
		int max = 0;
		for(int value : inputArr) {
			if( value > max ) {
				max = value;
			}
		}
		return max;
	}
	
	public static void doCountingSort() {
		int size = getMaxOnInputArr();
		countingArr  = new int[size+1];
		
		for(int i =0; i< inputArr.length;i++) {
			countingArr[inputArr[i]]++;
		}
	}
	
	public static void printCountingArr() throws IOException {
		for(int i=0; i<countingArr.length; i++) {
			if(countingArr[i] != 0) {
				for(int j =0; j< countingArr[i]; j++) {
					sb.append(i).append("\n");
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void closeBuffedIO() throws IOException {
		bw.close();
		br.close();
	}

}

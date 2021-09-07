package boj10814;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringBuilder sb;
	private static StringTokenizer stz;
	private static String[][] arr;
	
	public static void main(String[] args) throws IOException {
		initializeIO();
		makeArr();
		initializeArr();
		doBubbleSort();
		printArr();
		closeIO();
	}
	
	public static void initializeIO() {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	public static void makeArr() throws IOException {
		stz = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(stz.nextToken());
		arr = new String[size][2];
	}
	
	public static void initializeArr() throws IOException {
		for(int i=0; i<arr.length; i++) {
			stz = new StringTokenizer(br.readLine()," ");
			arr[i][0] = stz.nextToken();
			arr[i][1] = stz.nextToken();
		}
	}
	
	public static void doBubbleSort() {
		for(int i=0; i<arr.length-1;i++) {
			int exchangeNum = 0;
			int lastExchangeIndex = 0;
			for(int j=arr.length-1; j>0; j--) {
				if(getAge(arr[j][0]) < getAge(arr[j-1][0])) {
					swap(j);
					exchangeNum++;
					lastExchangeIndex = j-1;
				}
			}
			if(exchangeNum == 0)break;
			else i = lastExchangeIndex;
		}
	}
	
	public static int getAge(String age) {
		return Integer.parseInt(age);
	}
	
	public static void swap(int index) {
		String tmpAge = arr[index][0];
		String tmpName = arr[index][1];
		arr[index][0] = arr[index-1][0];
		arr[index][1] = arr[index-1][1];
		arr[index-1][0] = tmpAge;
		arr[index-1][1] = tmpName;
	}
	
	public static void printArr() throws IOException {
		sb = new StringBuilder();
		for(int i =0; i<arr.length; i++) {
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void closeIO() throws IOException {
		bw.close();
		br.close();
	}
}

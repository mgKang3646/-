package boj11651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//버블정령
public class Main {

	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringBuilder sb;
	private static StringTokenizer stz;
	
	private static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		createObjects();
		makeArr();
		initializeArr();
		doBubbleSort();
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
	
	public static void doBubbleSort() {
		for(int i =0; i < arr.length-1; i++) {
			int exchangeNum = 0;
			int lastExchangeIndex = 0;
			for(int j = arr.length-1; j > 0; j--) {
				if(arr[j][1] < arr[j-1][1]) {
					swap(j);
					exchangeNum++;
					lastExchangeIndex = j-1;
				}else if(arr[j][1] == arr[j-1][1]) {
					if(arr[j][0] < arr[j-1][0]) {
						swap(j);
						exchangeNum++;
						lastExchangeIndex = j-1;
					}
				}
			}
			if(exchangeNum == 0) break;
			else i = lastExchangeIndex;
		}
	}
	
	public static void swap(int index) {
		int tmpX = arr[index][0];
		int tmpY = arr[index][1];
		arr[index][0] = arr[index-1][0];
		arr[index][1] = arr[index-1][1];
		arr[index-1][0] = tmpX;
		arr[index-1][1] = tmpY;
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

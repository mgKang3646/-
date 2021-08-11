package boj11650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main3 {
	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringBuilder sb;
	private static StringTokenizer stz;
	
	private static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		createObjects();
		createArr();
		initializeArr();
		doCountingSort();
		printArr();
		closeIO();
	}
	
	public static void createObjects() {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
	}
	
	public static void createArr() throws NumberFormatException, IOException {
		int size = Integer.parseInt(br.readLine());
		arr = new int[size][2];
	}
	
	public static void initializeArr() throws IOException {
		for(int i=0; i<arr.length;i++) {
			stz = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(stz.nextToken());
			arr[i][1] = Integer.parseInt(stz.nextToken());
		}
	}
	
	public static void doCountingSort() {
		int xMax = getMaxCoordinateX();
		int yMax = getMaxCoordinateY();
		
		int[][] countingArr = new int[xMax*2+1][yMax*2+1];
		
		for(int i=0; i < arr.length;i++) {
			countingArr[arr[i][0]+xMax][arr[i][1] + yMax]++;
		}
		
		int arrPointer = 0;
		for(int i=0; i< countingArr.length; i++) {
			for(int j=0; j<countingArr[i].length; j++) {
				if(countingArr[i][j]==0)continue;
				arr[arrPointer][0] = i - xMax;
				arr[arrPointer++][1] = j - yMax;
			}
		}
	}
	
	public static int getMaxCoordinateX() {
		int max = 0;
		for(int i=0;i<arr.length;i++) {
			int value = Math.abs(arr[i][0]);
			if( value > max) {
				max = value;
			}
		}
		return max;
	}
	
	public static int getMaxCoordinateY() {
		int max = 0;
		for(int i=0; i<arr.length; i++) {
			int value = Math.abs(arr[i][1]);
			if( value  > max) {
				max = value;
			}
		}
		return max;
	}
	
	
	public static void printArr() throws IOException {
		for(int i =0; i < arr.length; i++) {
			sb.append(arr[i][0]+" "+arr[i][1]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void closeIO() throws IOException {
		br.close();
		bw.close();
	}

}

package boj1181;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader bufferedReader;
	private static BufferedWriter bufferedWriter;
	private static StringBuilder sb;
	private static StringTokenizer stz;
	private static int size;
	private static String[] arr;

	public static void main(String[] args) throws IOException {
		initializeIO();
		getSize();
		initializeArr();
		doBubble();
		printArr();
		closeIO();
	}
	
	public static void initializeIO() {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	public static void getSize() throws IOException {
			stz = new StringTokenizer(bufferedReader.readLine());
			size = Integer.parseInt(stz.nextToken());
	}
	
	public static void initializeArr() throws IOException {
		HashSet<String> hs = new HashSet<String>();
		for(int i=0; i < size; i++) {
			stz = new StringTokenizer(bufferedReader.readLine());
			hs.add(stz.nextToken());
		}
		
		Iterator<String> iterator = hs.iterator();
		arr = new String[hs.size()];
		int i = 0;
		
		while(iterator.hasNext()) {
			arr[i++] = iterator.next();
		}
	}
	
	public static void doBubble() {
		for(int i = 0; i<arr.length-1; i++) {
			int exchangeNum = 0;
			int lastExchangeIndex = 0;
			for( int j = arr.length-1; j > 0; j--) {
				if(arr[j].length() < arr[j-1].length()) {
					swap(j);
					exchangeNum++;
					lastExchangeIndex = j-1;
				}
				else if(arr[j].length() == arr[j-1].length()) {
					if(isSmaller(j)) {
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
		String tmp = arr[index];
		arr[index] = arr[index-1];
		arr[index-1] = tmp;
	}
	
	public static boolean isSmaller(int index) {
		for(int i =0; i < arr[index].length(); i++) {
			if(arr[index].charAt(i) < arr[index-1].charAt(i)) return true;
			else if(arr[index].charAt(i) > arr[index-1].charAt(i)) return false;
		}
		return false;
	}
	
	
	
	public static void printArr() throws IOException {
		sb = new StringBuilder();
		for(String value : arr) {
			sb.append(value).append("\n");
		}
		bufferedWriter.write(sb.toString());
		bufferedWriter.flush();
	}
	
	public static void closeIO() throws IOException {
		bufferedReader.close();
		bufferedWriter.close();
	}
}

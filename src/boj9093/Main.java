package boj9093;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br;
	public static BufferedWriter bw;
	public static StringTokenizer stz;
	public static StringBuffer stringBuffer;
	public static StringBuilder stringBuilder;

	public static String[] arr;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		stz= new StringTokenizer(br.readLine());
		int size = Integer.parseInt(stz.nextToken());
		arr = new String[size];
		
		for(int i=0; i<size; i++) {
			stz= new StringTokenizer(br.readLine());
			arr[i] = "";
			
			while(stz.hasMoreTokens()) {
				stringBuffer = new StringBuffer(stz.nextToken());
				arr[i] += stringBuffer.reverse().toString()+" ";
			}
		}
		
		stringBuilder = new StringBuilder();
		for(int i=0; i<size; i++) {
			stringBuilder.append(arr[i]).append("\n");
		}
		
		bw.write(stringBuilder.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

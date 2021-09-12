package boj10828;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringTokenizer stz;
	private static StringBuilder sb;
	
	private static int[] stack = new int[10000];
	private static int stackPointer = 0;
	private static int max = stack.length - 1;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		stz = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(stz.nextToken());
		
		for(int i = 0; i<size; i++) {
			stz = new StringTokenizer(br.readLine());
			String identifier = stz.nextToken();
			switch(identifier) {
				case "push" : push(Integer.parseInt(stz.nextToken())); break;
				case "pop" : append(pop()); break;
				case "size" : append(size()); break;
				case "empty" : append(empty()); break;
				case "top" : append(top()); break;
				default : break;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void push(int value) {
		if(stackPointer < max) stack[stackPointer++] = value;
	}
	
	public static int pop() {
		if(stackPointer <= 0) return -1;
		else return stack[--stackPointer];
	}
	
	public static int size() {
		return stackPointer;
	}
	
	public static int empty() {
		if(stackPointer <= 0) return 1;
		else return 0;
	}
	
	public static int top() {
		if(stackPointer <= 0) return -1;
		else return stack[stackPointer -1];
	}
	
	public static void append(int value){
		sb.append(value+"").append("\n");
	}
}

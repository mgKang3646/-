package boj9012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static StringTokenizer stz;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		stz = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(stz.nextToken());
		String[] PS = new String[size];
		
		for(int i=0; i<size; i++) {
			stz = new StringTokenizer(br.readLine());
			PS[i] = stz.nextToken();
		}
		
		for( String value : PS) {
			if(isVPS(value)) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean isVPS(String value) {
		Stack<Character> openPSStack = new Stack<Character>();
		
		for(int i=0; i<value.length(); i++) {
			char ps = value.charAt(i);
			if(ps == '(') openPSStack.push(ps);
			else if(ps == ')') {
				if(openPSStack.isEmpty()) return false;
				else openPSStack.pop();
			}
		}
		
		if(openPSStack.isEmpty()) return true;
		else return false;
	}

}

package boj10757;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		
		sb = new StringBuilder(sc.next());
		String A = sb.reverse().toString();
		
		sb = new StringBuilder(sc.next());
		String B = sb.reverse().toString();
	
		//길이 맞추기
		if(A.length() > B.length()) {
			B = appendZero(B, A.length() - B.length());
		}else {
			A = appendZero(A, B.length() - A.length());
		}
	
		String result= "";
		int carry = 0;

		for(int i=0; i< A.length(); i++) {
			int a = A.charAt(i) - '0';
			int b = B.charAt(i) - '0';
			int sum = a + b + carry;
			
			if(sum >= 10) {
				carry = 1;
			}else {
				carry = 0;
			}
				result += sum%10;
		}
		
		if(carry == 1) {
			result += 1;
		}
		
		sb = new StringBuilder(result);
		System.out.println(sb.reverse().toString());

	}
	
	public static String appendZero(String value, int count) {
		
		for( int i = 0; i< count; i++) {
			value += "0";
		}
		return value;
	}

}

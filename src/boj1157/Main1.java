package boj1157;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String data = sc.next();
		int size = 'Z'-'A'+1;
		
		
		int[] countAlphabet = new int[size];
		
		for(int i=0; i<data.length(); i++) {
			char value = data.charAt(i);
			if(value > 'Z') {
				value -= ( 'a' - 'A' );
			}
			countAlphabet[value-'A']++;
		}
		
		int max = -1;
		char ch = '?';
		
		for(int i=0; i<size;i++) {
			if( countAlphabet[i] > max ) {
				max = countAlphabet[i];
				ch = (char)(i + 'A');
			}else if ( countAlphabet[i] == max ) {
				ch = '?';
			}
		}
		
		System.out.println(ch);
		
		
	}

}

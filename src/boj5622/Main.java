package boj5622;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String data = sc.next();
		int timeForCall = 0;
		
		for(int i = 0; i< data.length(); i++) {
			int num = switchCharToNum(data.charAt(i));
			timeForCall += num+1;
		}
		System.out.println(timeForCall);
	}
	
	public static int switchCharToNum(char data) {
		
		int value = 0;
		switch(data) {
			case 'A' : case 'B' : case 'C' : value = 2; break;
			case 'D' : case 'E' : case 'F' : value = 3; break;
			case 'G' : case 'H' : case 'I' : value = 4; break;
			case 'J' : case 'K' : case 'L' : value = 5; break;
			case 'M' : case 'N' : case 'O' : value = 6; break;
			case 'P' : case 'Q' : case 'R' : case 'S' : value = 7; break;
			case 'T' : case 'U' : case 'V' : value = 8; break;
			case 'W' : case 'X' : case 'Y' : case 'Z' : value = 9; break;
			default : value = 0; break;
		}
		
		return value;
	}

}

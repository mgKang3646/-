package boj5622;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String data = sc.next();
		int timeForCall = 0;
		
		for(int i =0; i < data.length(); i++) {
			timeForCall += swtichCharToNum(data.charAt(i))+1;
		}
		System.out.println(timeForCall);
	}
	
	public static int swtichCharToNum(char ch) {
		int value = 0;
		if(ch >= 65 && ch < 68) value = 2;
		else if(ch < 71) value = 3;
		else if(ch < 74) value = 4;
		else if(ch < 77) value = 5;
		else if(ch < 80) value = 6;
		else if(ch < 84) value = 7;
		else if(ch < 87) value = 8;
		else if(ch < 91) value = 9;
		else value = 0;
		
		return value;
	}

}

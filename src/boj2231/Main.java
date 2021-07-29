package boj2231;

import java.util.Scanner;

public class Main {

	public static final int MAX_VALUE = 1000000;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		
		int numberOfValue = String.valueOf(value).length();
		int bigScope = 9*numberOfValue;
		int smallScope = 9*(numberOfValue-1);
		
		int minOfBigScope = getGenerator(value,bigScope);
		int minOfSmallScope = getGenerator(value,smallScope);
		
		System.out.println(getResult(minOfBigScope,minOfSmallScope));
	}
	
	public static int getGenerator(int value, int scope) {
		int min = MAX_VALUE;
		for(int i=(value - scope); i < value; i++) {
			boolean result = isGenerator(value,i);
			if(result) {
				if(i < min) {
					min = i;
				}
			}
		}
		return min;
	}

	public static boolean isGenerator(int value, int data) {
		int sum = 0;
		int tmp = data;
		while(tmp != 0) {
			sum += tmp % 10;
			tmp /= 10;
		}
		
		if(value == data+sum) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static int getResult(int data1, int data2) {
		int result = Math.min(data1, data2);
		if(result != MAX_VALUE) {
			return result;
		}else {
			return 0;
		}	
	}

}

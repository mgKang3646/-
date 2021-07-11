package boj1157;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 내 풀이
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
		

		// 쓸데 없는 변수가 너무 많이 사용됨
		int max = 0;
		int indexOfMax = 0;
		boolean isDuplicate = false;
		
		for(int i=0; i<countAlphabet.length;i++) {
			int value = countAlphabet[i];
			
			if( value > max ) {
				max = value;
				indexOfMax = i;
				isDuplicate = false;
			}else if ( value == max ) {
				isDuplicate = true;
			}
		}
		
		// 조건 판단이 하나 더 사용 됨
		if(isDuplicate) {
			System.out.println("?");
		}else {
			System.out.println((char)(indexOfMax + 'A'));
		}
		
		// 개선점 : 목적은 char 형 문자 출력이다. 굳이 구태어 max와 max일때의 인덱스를 구한 후 조건 판단 문에서 char형으로 형변환할 필요없다. 
		// 출력시킬 데이터를 중심으로 코드를 짜라. 사고과정에서는 중간 매개가 있지만 코드 구현은 최대한 중간 매개를 줄여야 코드가 단순해진다.
		// 주어 - 서술어가 붙어 있는 문장이 이해가 빠른 문장이듯 말이다.
	}

}

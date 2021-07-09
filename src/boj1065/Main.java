package boj1065;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 첫 풀이
		// 브루트 포스 알고리즘
		// 너무 어렵게 풀었음;; 알고리즘 추론 능력부터 위기대응 능력까지 문제가 너무 많은 풀이였음
		// 무조건 정리 ( 그림으로 알고리즘 그려서 정리하기 )

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.println(d(num));
		
		

	}
	
	public static int d(int num) {
		int count = 0;

		for(int i=1; i<=num; i++) {
			
			int difference = 0;
			int current = i;
			int next = 0;
			int min = 10;
			int sum = 0;
			int number = 0;
			
			System.out.println("테스트 값 : "+ i);
			while(current > 0) {
				int value = current%10;
				next = (current/10)%10;
				System.out.println("현재 자릿 수 : "+value +" 다음 자릿 수 : "+next);
				current /= 10;
				
				if(value < min) {
					min = value;
				}
				
				if(next != 0) {
					difference = Math.abs(next - value);
				}
				sum += value;
				number++;
			}
			if(sum == (number * (2*min + (number-1)*difference))/2) {
				System.out.println("최솟값 : "+ min);
				System.out.println("등차 : "+difference);
				System.out.println("총 합 : "+ sum);
				System.out.println("자릿갯수 : "+ number);
				System.out.println("true");
				count++;
			}else {
				System.out.println("최솟값 : "+ min);
				System.out.println("등차 : "+difference);
				System.out.println("총 합 : "+ sum);
				System.out.println("자릿갯수 : "+ number);

				System.out.println("false");
			}
			System.out.println();

		}
		
		return count;
	}

}

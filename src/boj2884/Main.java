package boj2884;

import java.util.Scanner;
//2884 ¾Ë¶÷
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt();
		int min = sc.nextInt();
		
		if(hour==0) {
			hour = 24;
		}
		
		int sum = min + hour*60;
		int result = sum - 45;
		
		int resultHour = result/60;
		int resultMin = result%60;
		
		
		if(resultHour==24) {
			resultHour = 0;
		}
		
		System.out.println(resultHour+" "+resultMin);
		
	}
}

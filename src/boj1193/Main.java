package boj1193;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int value = sc.nextInt();
		int parent = 1;
		int child = 1;
		
		int max = 1;
		int count = 1;
		
		while(value > max)
		{
			max = max + (++count);
		}
		
		int dif = max - value;
		
		//count가 짝수면 상향, 홀수면 하향
		if(count%2==0) {
			parent = 1 + dif;
			child = count - dif;	
		}else {
			parent = count - dif;
			child = 1 + dif;
		}
		
		System.out.println(child+"/"+parent);
	}

}

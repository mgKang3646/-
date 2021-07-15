package boj1193;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		int max = 1;
		int layer = 1;
		while( value > max ) {
			layer++;
			max = max + layer;
		}

		int preMax = max - layer;
		int position = value - preMax;

		//layer가 짝수면 하향, 홀수면 상향 
		// 하향 : 분자 = position, 분모 = (layer+1) - position
		// 상향 : 분모 = position, 분자 = (layer+1) - position
		
		int child = 1;
		int parent = 1;
		
		if(layer%2==0) {
			child = position;
			parent = (layer+1) - position;
		}else {
			child = (layer+1) - position;
			parent = position;
		}
		System.out.println(child + "/" + parent);
	}

}

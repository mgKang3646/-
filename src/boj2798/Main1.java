package boj2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		
		stz = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(stz.nextToken());
		int blackjack = Integer.parseInt(stz.nextToken());
		int[] arr = new int[num];
		
		stz = new StringTokenizer(br.readLine());
		for(int i=0; i<num;i++) {
			arr[i] = Integer.parseInt(stz.nextToken());
		}
		
		System.out.println(searchCards(arr,num,blackjack));

	}
	
	public static int searchCards(int[] arr, int num, int blackjack) {
		
		int max = 0;
		int sum = 0;
		for(int i=0; i<num; i++) {
			sum = arr[i];
			if(sum >= blackjack) continue;
			
			for(int j=i+1; j<num;j++) {
				sum = arr[i] + arr[j];
				if(sum >= blackjack) continue;
				
				for(int z=j+1; z<num;z++) {
					sum = arr[i] + arr[j] + arr[z];
					if(blackjack == sum ) {
						return sum;
					}
					
					else if(blackjack > sum && sum > max) {
						max = sum;
					}
				}
			}
		}
		
		return max;
	}

}

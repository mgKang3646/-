package boj1065;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int result = countHanNumber(num);
		System.out.println(result);
	}
	
	public static int countHanNumber(int num) {
		
		int count = 0;
		
		for(int i=1; i<=num;i++) {
			if(isHanNumber(i)) {
				count++;
			}
		}
		
		return count;
		
	}
	
	public static boolean isHanNumber(int num) {
		boolean isFirst = true;
		int current = 0;
		int next = 0;
		int nextnext = 0;
		int difference = 0;
		
		while( num > 0 ) {
			current = num%10;
			next = (num/10)%10;
			num /= 10;
			
			if(num != 0) {
				difference = next - current;
			}else {
				return true;
			}
			
			if(isFirst) {
				nextnext = next + difference;
			}else {
				if(nextnext != current + difference) {
					return false;
				}else {
					nextnext = next + difference;
				}
			}
			isFirst = false;
		}
		return true;
	}

}

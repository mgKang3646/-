package boj1110;

import java.util.Scanner;

public class Main {
	// 다른 애들 풀이와 비교하여 정리
	//https://st-lab.tistory.com/42
	//https://st-lab.tistory.com/41
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner sc = new Scanner(System.in);
		String start = sc.next();
		
		if(Integer.parseInt(start)<10) {
			start = "0"+start;
		}
		
		String tmp = start;
		String result = null;
		int count = 0;
		
		while(!start.equals(result)) {
			int x = Integer.parseInt(tmp.substring(0,1));
			int y = Integer.parseInt(tmp.substring(1));
			
			int sum = x + y;
			String sumString;
			if(sum<10) {
				sumString = "0"+String.valueOf(sum);
			}else {
				sumString = String.valueOf(sum);
			}
			
			result = String.valueOf(y)+sumString.substring(1);
			tmp = result;
			count++;
		}
		
		System.out.println(count);

	}

}

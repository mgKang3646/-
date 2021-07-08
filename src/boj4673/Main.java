package boj4673;

public class Main {
	// 에라토스테네스의 체
	// 나의 풀이
	public static void main(String[] args) {
		
		boolean[] decimalArray = new boolean[10050];
		//합이 10000이 넘어가는 제약상황을 자료구조에 투영했다.
		//제약위반이 발생하면 조건문으로 처리하고 자료구조는 문제에 주어진 조건을 그대로 따른다.
		
		for(int i=1; i<=10000;i++) {
			int j = d(i);
			decimalArray[j] = true;
		}
		
		for(int j=1; j<=10000;j++){
			if(decimalArray[j]==false) {
				System.out.println(j);
			}
		}
		
	}
	
	public static int d(int data) {
		int result = data;
		
		while(data > 0) {
			int value = data%10;
			data /= 10;
			result += value;
		}
		return result;
	}
}



package boj4673;

public class Main1 {
		// 다른 사람 풀이
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 자료구조는 제약이 적용된 상태가 아닌 조건으로 주어진 그대로로 만든다.
		// 제약은 조건 및 반복으로 구현한다.
		int size = 10001;
		boolean[] isNotSelfNumber = new boolean[size];
		
		for(int i=1; i<isNotSelfNumber.length;i++) {
			int result = d(i);
			if(result < size) {
				isNotSelfNumber[result]= true;
			}
		}
		
		for(int i=1; i < isNotSelfNumber.length; i++) {
			if(isNotSelfNumber[i]==false) {
				System.out.println(i);
			}
		}
	}
	
	public static int d(int data) {
		int result = data;
		while(data > 0) {
			result += data%10;
			data /= 10;
		}
		return result;
	}

}

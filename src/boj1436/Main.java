package boj1436;

import java.util.Scanner;

public class Main {
	// 1. 자리수 파악
	// 2. 재귀함수 구성
	// 결과 : 실패
	private static int count = 0;
	private static int[] scopeArr = new int[5];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int scope = searchScope(n);
		count = scopeArr[scope-1];
		System.out.println(getSeriesNum(scope,n));
	}
	
	// 1 : 4자리수, 2: 5자리수 , 3 : 6자리수, , 4 : 7자리수
	public static int searchScope(int n) {
		makeScopeArr();
		return getScope(n);
	}
	
	public static String getSeriesNum(int scope, int n) {
		String result = searchSeriesNum(scope,n);
		if(scope != 1) {
			int value = Integer.parseInt(result) + (int)Math.pow(10, scope+2);
			return value+"";
		}
		return result;
	}
	
	public static String searchSeriesNum(int scope, int n) {
		int decimal = (int)Math.pow(10,scope);
		
		if(scope == 1) {
			for(int i=0;i<10;i++) {
				if(i==6) {
					for(int j=0;j<decimal;j++) {
						count++;
						if(count==n) return "666"+j;
					}
					continue;
				}
				count++;
				if(count == n) return i+"666";
			}
			return null;
		}
		
		for(int i=0;i<10;i++) {
			if(i==6) {
				for(int j=0; j<decimal;j++) {
					count++;
					if(count==n) {
						return "666"+getStringNum(j,decimal/10);
					}
				}
				continue;
			}
			//재귀에서 스택오버플로우 나오면 -1 해주었는지 확인
			String result = searchSeriesNum(scope-1,n);
			if(result != null) {
				return i + result;
			}
		}
		return null;
	}

	public static void makeScopeArr(){
		int scope = 0;
		int sum = 0;
		for(int i=1; i<5; i++) {
			int value = 8*scope + 9 + (int)Math.pow(10, i);
			sum += value;
			scopeArr[i] = sum;
			scope = value;
		}
	}
	
	public static int getScope(int n) {
		for(int i=1; i<scopeArr.length; i++) {
			if( n <= scopeArr[i]) return i; // 자리수 반환
		}
		return -1;
	}
	
	public static String getStringNum(int value, int decimal) {
			String result ="";
			while(decimal > value) {
				result = result +"0";
				decimal /= 10;
			}
			return result + value;
	}
}
	
	
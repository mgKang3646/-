package boj2798;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	// 확실하지 않은 알고리즘은 실수를 만든다.
	// 리스트를 다루는 것이 익숙치 않음
	// 리스트 반복문 사용은 주의해야함. 변수의 한계를 리스트 사이즈로 하지말것. 향상된 반복문과 아닌 것에 주의
	// 배열의 사이즈 문제 stz 값 갖고오는 문제 크기를 잘고려해야한다.
	private static StringTokenizer stz;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		stz = new StringTokenizer(br.readLine()," ");
		int num = Integer.parseInt(stz.nextToken());
		int blackjack = Integer.parseInt(stz.nextToken());
	
		stz = new StringTokenizer(br.readLine()," ");
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		

		ascSort(numbers,num);
		
		bw.write(findBlackJack(numbers,blackjack)+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void ascSort(ArrayList<Integer> numbers, int num) {
		
		for(int i=0; i<num;i++) {
			int value = Integer.parseInt(stz.nextToken());
			if(i==0) {
				numbers.add(value);
				continue;
			}
			for(int j=0; j<num; j++) {
				
				if(numbers.size() <= j) {
					numbers.add(value);
					break;
				}
				if(value > numbers.get(j)) {
					numbers.add(j,value);
					break;
				}
			}
		}
	}
	
	public static int findBlackJack(ArrayList<Integer> numbers, int blackjack) {
		int sum = 0;
		
		for(int i=0; i<numbers.size();i++) {
			if(sum + numbers.get(i) >= blackjack) continue;
			sum += numbers.get(i);
			
			for(int j=i+1; j<numbers.size();j++) {
				
				if(sum + numbers.get(j) >= blackjack) continue;
				sum += numbers.get(j);
				
				for(int z=j+1; z<numbers.size(); z++) {
					if(sum + numbers.get(z) > blackjack) continue;
					sum += numbers.get(z);
					System.out.println(numbers.get(i)+" "+numbers.get(j)+ " "+numbers.get(z));
					return sum;
				}
				sum -= numbers.get(j);
			}
			sum = 0;
		}
		
		return sum;
	}
}

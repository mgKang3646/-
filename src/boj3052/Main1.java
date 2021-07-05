package boj3052;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		// HashSet은 내부에서 중복되는 값을 제거한다. 그러므로 HashSet 자료구조는 중복값 제거에 잘 사용된다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<Integer> duplicateDelete = new HashSet<Integer>();
		
		for( int i=0; i<10;i++) {
			duplicateDelete.add(Integer.parseInt(br.readLine())%42);
		}
		
		bw.write(duplicateDelete.size()+"");
		bw.flush();
		bw.close();
		br.close();

	}

}

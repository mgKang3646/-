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
		
		// HashSet은 내부에서 중복값을 제거함. 그러므로 HashSet을 이용하여 중복제거 가능
		
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

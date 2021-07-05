package boj3052;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = 10;
		int divisor = 42;
		int count = 0;
		int[] remainderArr = new int[size];
		
		
		for(int i=0; i<size;i++) {
			remainderArr[i] = Integer.parseInt(br.readLine())%divisor;
		}
		
		for(int i=0; i<size; i++) {
			if(remainderArr[i] < divisor) {
				for(int j=i;j<size;j++) { 
					if( (i != j ) && (remainderArr[i] == remainderArr[j])) { 
						remainderArr[j] = divisor;
					}
				}
			}
		}
		
		for(int value : remainderArr) {
			if(value < divisor) {
				count++;
			}
		}
		
		bw.write(count+"");
		bw.flush();
		bw.close();
		br.close();
	}

}

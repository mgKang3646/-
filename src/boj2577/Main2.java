package boj2577;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int num = A*B*C;
		int[] arr = new int[10];
		
		do{
			int i = num%10;
			num /= 10;
			arr[i]++;
		}while(num!=0);
		
		for(int i =0; i<arr.length; i++) {
			bw.write(arr[i]+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}

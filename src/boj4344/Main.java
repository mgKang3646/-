package boj4344;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {
	
	//DecimalFormat 객체를 사용하면 문제풀이 실패하지만 System.out.printf를 사용하면 성공한다 왜 그럴까?

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stz;
		int[] scoreArr;
		
		int testcase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testcase;i++) {
	
			String score = br.readLine();
			stz = new StringTokenizer(score," ");
			int size = Integer.parseInt(stz.nextToken());
			
			int sum = 0;
			scoreArr = new int[size];
			
			for(int j = 0; j < size; j++) {
				int value = Integer.parseInt(stz.nextToken());
				sum += value;
				scoreArr[j] = value;
			}
			
			double avg = sum/size;
			int biggerThanAvg = 0;
			
			for(int z = 0; z < size; z++) {
				if( scoreArr[z] > avg ) {
					biggerThanAvg++;
				}
			}
			
			// DecimalFormat 객체를 사용하면 소수점 자리수를 고정할 수 있다. 
			double result = ((double)biggerThanAvg/size)*100;
			//DecimalFormat df = new DecimalFormat("#.000");
			System.out.printf("%.3f%%\n",result);
			//bw.write(df.format(result) +"%\n");
		}
			//bw.flush();
			//bw.close();
			br.close();
	}
	

}

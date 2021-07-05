package boj1546;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		// 왜? double 나누기 연산과 int 나누기 연산의 결과가 다른 이유는?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;
		
		int size = Integer.parseInt(br.readLine());
		stz = new StringTokenizer(br.readLine()," ");
		
		double[] scoreArr = new double[size];
		int i = 0;
		double[] upgradeScore = new double[size];
		
		int value = Integer.parseInt(stz.nextToken());
		scoreArr[i] = value;
		int M = value;
		
		while(stz.hasMoreTokens()) {
			value = Integer.parseInt(stz.nextToken());
			scoreArr[++i] = value;
			if( value > M ) {
				M = value;
			}
		}
		
		double sum =0;
		for( int j =0; j<size;j++) {
			upgradeScore[j] = scoreArr[j]/M*100 ;
			sum += upgradeScore[j];
		}
		
		bw.write((sum/size)+"");
		bw.flush();
		bw.close();
		br.close();
		
	}

}

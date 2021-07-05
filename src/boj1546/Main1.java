package boj1546;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		// 다항식은 교환, 결합, 분배 법칙을 통해 간략화하면 반복적 연산을 피할 수 있다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;
		
		int size = Integer.parseInt(br.readLine());
		stz = new StringTokenizer(br.readLine()," ");
		double sum = 0;
		double max = 0;
		
		for(int i=0;i<size;i++) {
			double value = Double.parseDouble(stz.nextToken());
			sum += value;
			if( value > max ) {
				max = value;
			}
		}
		
		double avgUpgradeScore = (sum/max*100)/size;
		
		bw.write(avgUpgradeScore+"");
		bw.flush();
		bw.close();
		br.close();
	}

}

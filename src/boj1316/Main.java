package boj1316;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testcase = Integer.parseInt(br.readLine());
		int nGroupWord = 0;
		
		for(int i=0; i<testcase;i++) {
			
			String str = br.readLine();
			char currentChar =0;
			int nChar = 0;
			HashSet<Character> usedChar = new HashSet<Character>();
			
			for(int j=0; j<str.length();j++) {
				
				if(currentChar != str.charAt(j)) {
					currentChar = str.charAt(j);
					nChar++;
					usedChar.add(str.charAt(j));
				}
			}
			
			if(nChar == usedChar.size()) nGroupWord++;
		}
		
		bw.write(nGroupWord+"");
		bw.flush();
		bw.close();
		br.close();
	}

}

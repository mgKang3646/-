package boj1316;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testcase = Integer.parseInt(br.readLine());
		int nGroup = 0;
		
		for(int i=0;i<testcase;i++) {
			String str = br.readLine();
			
			boolean[] alphabet = new boolean['z'-'a'+1];
			char currentChar = 0;
			
			for(int j=0; j<str.length();j++) {
				
				if(currentChar != str.charAt(j)) {
					if(checkAlphabet(str.charAt(j)-'a',alphabet)) {
						break;
					}else {
						alphabet[str.charAt(j)-'a'] = true;
					}
					currentChar = str.charAt(j);
				}
				
				if(j==str.length()-1) nGroup++;
			}
		}
		
		bw.write(nGroup+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean checkAlphabet(int value, boolean[] alphabet) {
		
		if(alphabet[value] == true) return true;
		else return false;
		
	}
}

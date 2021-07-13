package boj2941;

import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] croatiaWords = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		Scanner sc = new Scanner(System.in);
		String value = sc.next();
		
		for(int i=0; i<croatiaWords.length;i++) {
			value = value.replaceAll(croatiaWords[i],"0");
		}
		System.out.println(value.length());		
	}
	
	
}

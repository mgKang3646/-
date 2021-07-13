package boj2941;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int nWord = 0;
		
		for(int i = 0; i<str.length(); i++) {
			nWord++;
			
			if(i < str.length()-1) {
				i = searchWord(i,str);
			}
		}
		
		System.out.println(nWord);

	}
	
	public static int searchWord(int i, String str) {
		
		if(str.charAt(i)=='c') {
			if(str.charAt(i+1)=='=') {
				i++; 
			}
			else if(str.charAt(i+1)=='-') {
				i++;
			}
			
		}
		
		else if(str.charAt(i)=='d') {
			if(str.charAt(i+1)=='z') {
				if(i <str.length()-2) {
					if(str.charAt(i+2)=='=') {
						i += 2;
					}
				}
			}
			else if(str.charAt(i+1)=='-') {
				i++;
			}
		}
		
		else if(str.charAt(i)=='l') {
			if(str.charAt(i+1)=='j') {
				i++;
			}
		}
		
		else if(str.charAt(i)=='n') {
			if(str.charAt(i+1)=='j') {
				i++;
			}
		}
		
		else if(str.charAt(i)=='s') {
			if(str.charAt(i+1)=='=') {
				i++;
			}
		}
		
		else if(str.charAt(i)=='z') {
			if(str.charAt(i+1)=='=') {
				i++;
			}
		}
		
		return i;
	}

}

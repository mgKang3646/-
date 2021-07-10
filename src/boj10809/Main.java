package boj10809;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String data = sc.next();
		String alphabet = null;
		
		for(int i = 'a'; i<'z'; i++) {
			alphabet = (char)i +"";
			int value = data.indexOf(alphabet);
			System.out.print(value+ " ");	
		}
	}
}

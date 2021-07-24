package boj3053;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	
		
		Scanner sc = new Scanner(System.in);
		double r = sc.nextDouble();
		
		double pi = Math.PI;
		double taxiPi = 2;

		System.out.printf("%.6f\n",pi*r*r);
		System.out.printf("%.6f\n",taxiPi*r*r);
	}
}

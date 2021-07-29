package boj7568;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	private static StringTokenizer stz;
	private static BufferedReader br; 
	private static BufferedWriter bw;
	private static StringBuilder sb;
	private static int[][] people;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		createObjects();
		makePeopleArr();
		setPeopleArr();
		getRank();
		printRank();
		closeIO();
		
	}
	
	public static void createObjects(){
		 br = new BufferedReader(new InputStreamReader(System.in));
		 bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 sb = new StringBuilder();
	}
	
	public static void makePeopleArr() throws NumberFormatException, IOException{
		int testcase = Integer.parseInt(br.readLine());
		people = new int[testcase][2];
	}
	
	public static void setPeopleArr() throws IOException {
		for(int i=0;i<people.length;i++) {
			stz = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(stz.nextToken());
			int height = Integer.parseInt(stz.nextToken());
			
			people[i][0] = weight;
			people[i][1] = height;
		}
	}
	
	public static void getRank() {
		for(int i=0; i<people.length;i++) {
			sb.append(countRank(i)+1).append(" ");
		}
	}
	
	public static void printRank() throws IOException {
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void closeIO() throws IOException {
		bw.close();
		br.close();
	}
	
	public static int countRank(int i) {
		int weight = people[i][0];
		int height = people[i][1];
		int count = 0;
		for(int j=0; j<people.length;j++) {
			if(i==j)continue;
			if(isBig(weight,height,j)) {
				count++;
			}
		}
		return count;
	}
	
	public static boolean isBig(int weight, int height, int j) {
		if( weight < people[j][0] && height < people[j][1]) {
			return true;	
		}
		return false;
	}

}

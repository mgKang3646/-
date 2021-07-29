package boj1018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	private static final int PIVOT = 8;

	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringTokenizer stz;
	
	private static int height;
	private static int width;
	
	private static char[][] chess;


	public static void main(String[] args) throws IOException {
		createIOObjects();
		getChess();
		printResult(getMinChange());
	}
	
	public static void createIOObjects() {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	public static void getChess() throws IOException {
		createChess();
		initializeChess();
	}
	
	public static void printResult(int result) throws IOException {
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int getMinChange() {
		int min = width*height;
		for(int i=0; i+PIVOT<=height;i++) {
			for(int j=0; j+PIVOT<=width;j++) {
				int tmp = countChange(i,j);
				if(tmp < min) min = tmp;
			}	
		}
		return min;
	}

	public static void createChess() throws IOException {
		stz = new StringTokenizer(br.readLine());
		height = Integer.parseInt(stz.nextToken());
		width  = Integer.parseInt(stz.nextToken());
		
		chess = new char[height][width];
	}
	
	public static void initializeChess() throws IOException {
		for(int i=0;i<height;i++) {
			String value = br.readLine();
			for(int j=0; j<width;j++) {
				chess[i][j] = value.charAt(j);
			}
		}
	}
	
	public static int countChange(int startHeight, int startWidth) {
		 char[][] whitePivotChess = makePivotChess('W');
		 char[][] blackPivotChess = makePivotChess('B');
		 int whiteMin = getCount(whitePivotChess,startHeight,startWidth);
		 int blackMin = getCount(blackPivotChess,startHeight,startWidth);
		 return Math.min(whiteMin, blackMin);
	}
	
	public static char[][] makePivotChess(char start) {
		
		char[][] pivotChess = new char[PIVOT][PIVOT];
		char even = ( start == 'B') ? 'B' : 'W';
		char odd = ( start == 'B') ? 'W' : 'B';
	
		for(int i=0;i<PIVOT;i++) {
			for(int j=0;j<PIVOT;j++) {
				if(j%2==0) {
					pivotChess[i][j] = even;
				}else {
					pivotChess[i][j] = odd;
				}
			}
			char tmp = even;
			even = odd;
			odd = tmp;
		}
		
		return pivotChess;
	}
	
	public static int getCount(char[][] pivotChess, int startHeight,int startWidth) {
		int count = 0;
		for(int i=0;i<PIVOT;i++) {
			for(int j=0;j<PIVOT;j++) {
				if(chess[i+startHeight][j+startWidth] != pivotChess[i][j]) count++;
			}
		}
		return count;
	}
}

package boj1018;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1 {
	
	private static final int PIVOT = 8;

	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringTokenizer stz;
	
	private static int height;
	private static int width;
	
	private static boolean[][] chess;


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
				int tmp = getCount(i,j);
				if(tmp < min) min = tmp;
			}	
		}
		return min;
	}
	
	public static void createChess() throws IOException {
		stz = new StringTokenizer(br.readLine());
		height = Integer.parseInt(stz.nextToken());
		width  = Integer.parseInt(stz.nextToken());
		
		chess = new boolean[height][width];
	}
	
	public static void initializeChess() throws IOException {
		for(int i=0;i<height;i++) {
			String value = br.readLine();
			for(int j=0; j<width;j++) {
				if(value.charAt(j)=='W') { //'W'는 false
					chess[i][j] = false;
				}
				else if(value.charAt(j)=='B') {
					chess[i][j] = true;
				}
			}
		}
	}
	
	public static int getCount(int startHeight,int startWidth) {

		boolean current = chess[startHeight][startWidth];
		int count = 0;
		
		for(int i=0;i<PIVOT;i++) {
			for(int j=0;j<PIVOT;j++) {
				if(current != chess[i+startHeight][j+startWidth]) count++;
				current = !current;
			}
			current = !current;
		}
		return Math.min(count, PIVOT*PIVOT-count);
	}
}

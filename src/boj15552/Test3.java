package boj15552;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test3 {
	
	public static void main(String[] args) throws IOException {

		long startTime = System.currentTimeMillis();
		System.out.println("시작시간 : " + startTime);
		
		File file1 = new File("C:\\Users\\USER\\Desktop\\test.txt");
		File file2 = new File("C:\\Users\\USER\\Desktop\\result.txt");
		
		FileReader fr = new FileReader(file1);
		FileWriter fw = new FileWriter(file2);
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String data;
		
		while((data = br.readLine()) != null) {
			bw.write(data);
		}
		bw.flush();
		
		long endTime = System.currentTimeMillis();
		System.out.println("끝나는 시간 : "+ endTime);
		
		System.out.println("소요시간 : " + (endTime-startTime));
		
	}

}

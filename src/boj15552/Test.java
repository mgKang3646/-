package boj15552;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		System.out.println("시작시간 : " + startTime);

		
		File file1 = new File("C:\\Users\\USER\\Desktop\\test.txt");
		File file2 = new File("C:\\Users\\USER\\Desktop\\result.txt");

		FileInputStream fis = new FileInputStream(file1);
		FileOutputStream fos = new FileOutputStream(file2);
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		
		BufferedReader br = new BufferedReader(isr);
		BufferedWriter bw = new BufferedWriter(osw);
		
		String data;
		
		while((data=br.readLine())!=null) {
			bw.write(data+"\n");
		}
		
		bw.flush();
		
		long endTime = System.currentTimeMillis();
		System.out.println("끝나는 시간 : "+ endTime);

		System.out.println("소요시간 : " + (endTime-startTime));
	}
}

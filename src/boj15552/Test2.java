package boj15552;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		long startTime = System.currentTimeMillis();
		System.out.println("시작시간 : " + startTime);
		
		File file1 = new File("C:\\Users\\USER\\Desktop\\test.txt");
		File file2 = new File("C:\\Users\\USER\\Desktop\\result.txt");
		
		FileReader fr = new FileReader(file1);
		FileWriter fw = new FileWriter(file2);
		char[] data = new char[512];
		int readcount;
		
		while((readcount=fr.read(data)) != -1) {
			fw.write(data,0,readcount);
		}
		fw.flush();
		
		long endTime = System.currentTimeMillis();
		System.out.println("끝나는 시간 : "+ endTime);
		
		System.out.println("소요시간 : " + (endTime-startTime));
	}

}

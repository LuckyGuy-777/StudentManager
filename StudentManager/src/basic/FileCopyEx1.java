package basic;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileCopyEx1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//1. 읽고 쓰는데 사용될 스트림을 준비 -Reader Writer 스트림 필요
		Reader rd = null;
		Writer wr = null;
		
		rd = new FileReader("C:\\Temp\\bbbb.txt");
		wr = new FileWriter("Copy.txt");
		
		//2. 읽고 /쓰기
		while(true)
		{
			int data = rd.read();
			
			if(data == -1)
				break;
			
			wr.write(data);
			System.out.println((char)data);
		}
		
		// 3. 장치를 닫아줌
		rd.close();
		wr.close();
	}

}

package basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyEx {

	public static void main(String[] args) throws IOException{
		//1. 읽고 쓸 장치 준비
		//바이트 데이터를 처리
		InputStream in = null;
		OutputStream out = null;
		
		in = new FileInputStream("C:\\Temp\\bbbb.txt");//약한부분
		out = new FileOutputStream("copy.txt");//2
		//읽고 쓸 파일의 위치 기입
		
		
		//2. 읽고/쓰기를 한다
		while(true) {
			int data = in.read();
			
			if(data == -1)
			{
				break;
			}
			
			out.write(data);
			System.out.print((char)data);
		}
		
		//3. 장치를 닫아준다.
		in.close();
		out.close();
	}

}

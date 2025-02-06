package basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream("c:\\Temp\\bbbb.txt");
			out = new FileOutputStream("copy.txt");
			
			while(true)
			{
				int data = in.read();
				
				if(data == -1)
					break;
				
				out.write(data);}
		}catch(FileNotFoundException e){
			
			e.printStackTrace();
			System.out.println("파일을 열수없습니다");
		}catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("파일을 읽을 수가 없습니다.");
		}
		finally {
			
			try {
				in.close();
			}catch(IOException e) {
				e.printStackTrace();
				System.out.println("파일을 닫지 않았습니다.");
			}
			try {
				out.close();
			}catch(IOException e) {
				e.printStackTrace();
				System.out.println("파일을 닫지 않았습니다.");
			}
		}
		
	}

}

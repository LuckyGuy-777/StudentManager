package basic;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class FileCopyEx4 {
	
	public static void main(String[] args)throws Exception {
		//저장한 객체를 읽어오기
				FileInputStream fis = new FileInputStream("data.txt");
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis);
				
				//객체 역직렬화
				ArrayList<Student> stulist = (ArrayList<Student>)ois.readObject();
				Student kim_stu = (Student) ois.readObject();
				Student lee_stu = (Student) ois.readObject();
				Student park_stu = (Student) ois.readObject();
				
				Iterator it = stulist.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
				ois.close();
				bis.close();
				fis.close();
	}
}

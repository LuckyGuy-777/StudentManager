package basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class FileCopyEx3 {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("data.txt");
		//속도개선
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		//객체를 읽고 쓰는 스트림
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		Student stuKim = new Student("100","kim",79);
		Student stulee = new Student("200","lee",99);
		Student stupark = new Student("300","park",84);
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(stuKim);
		list.add(stulee);
		list.add(stupark);
		
		//객체직렬화
		oos.writeObject(list);
		
		oos.close();
		bos.close();
		fos.close();
		
		
		
	}

}

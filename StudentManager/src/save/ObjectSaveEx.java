package save;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import basic.Student;

public class ObjectSaveEx {

	public static void main(String[] args)throws Exception {
		FileOutputStream fos = new FileOutputStream("aaa.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Student stuKim = new Student("100","Kim",90);
		Student stuLee = new Student("200","LEE",70);
		Student stuPark = new Student("300","Park",80);
		
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(stuKim);
		al.add(stuPark);
		al.add(stuLee);
		//객체직렬호 - 저장할 객체에 Serializable인터페이스를 구현하여 객체를 직렬화 해주어야함
		oos.writeObject(al);
		
		oos.close();
		fos.close();
		
		
		System.out.println("저장된 객체를 읽기 위해서 객체 역직렬화");
		FileInputStream fis = new FileInputStream("aaa.txt");
		
	}

}

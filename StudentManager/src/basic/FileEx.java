package basic;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileEx {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("data.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Student s1 = new Student("100","Kim",99);
		Student s2 = new Student("200", "Lee",99);
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		
		oos.writeObject(list);
		
		fos.close();
		oos.close();
	}

}

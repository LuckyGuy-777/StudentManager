package basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;



public interface Serializable {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("data.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		Student stuKim = new Student("100","Kim",90);
		Student stuLee = new Student("200","Lee",80);
		Student stuPark = new Student("300","Park",88);
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(stuKim);
		list.add(stuLee);
		list.add(stuPark);
		
		//객체직렬화
		oos.writeObject(list);
		
		oos.close();
		bos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("data.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		//객체역직렬화
		ArrayList<Student> stuList = (ArrayList<Student>) ois.readObject();
		Student stuKim1 = (Student) ois.readObject();
		Student stuLee1 = (Student) ois.readObject();
		Student stuPark1 = (Student) ois.readObject();
		
		Iterator it = list.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		ois.close();
		bis.close();
		fis.close();
	}
}

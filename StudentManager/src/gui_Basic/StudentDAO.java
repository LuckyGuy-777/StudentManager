package gui_Basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class StudentDAO {
	
	private Scanner scan;
	private ArrayList<Student> al;
	
	private String id;
	private String name;
	private int score;
	
	
	public StudentDAO()
	{
		scan = new Scanner(System.in);
		al = new ArrayList<Student>();
	}
	
	//1.등록
	//등록시 점스는 0 to 100 사이의 값이 등록됨.
	//이 외의 경우 예외처리
	public boolean create(String id, String name, int score) {
		for(int i = 0; i< al.size(); i++) {
			Student s = al.get(i);
			if(id.equals(s.getId()))
				return false;
		}
		Student stu = new Student(id,name,score);
		al.add(stu);
		return true;
	}
	//2. 조회
	public String read() {
		// TODO Auto-generated method stub
		String str="";
		for(int i = 0; i <al.size(); i++)
		{
			str = str + "ID:" + al.get(i).getId()+" 이름:"+al.get(i).getName()+" 성적 :"+al.get(i).getScore() + "\n";
		}
		return str;
		
	}
	//3.수정
	public boolean update(String id) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<al.size();i++)
		{
			Student stu = al.get(i);
			if(id.equals(stu.getId())) {
				al.remove(i);
				return true;
			}
			
		}
		return false;
	}
	//삭제
	public void delete(String id) {
		// TODO Auto-generated method stub
		
		boolean found = false;
		int tempIndex = 0;
		
		for(int i = 0 ; i<al.size();i++)
		{
			Student stu = al.get(i);
			if(id.equals(stu.getId()))
			{
				found = true;
				tempIndex = i;
			}// 같은 아이디가 나오면 트루에 1
			
			if(found) {
				al.remove(tempIndex);
				System.out.println("id가 삭제됨.");
			}else {
				System.out.println("삭제할 id가 없습니다.");
			}
		}
	}

	// 5. 정렬
	public String sort_name() {
		Collections.sort(al);
		
		String str = ""; // 공백을 주고
		
		for(int i = 0; i <al.size(); i++)
		{
			str = str + "ID:" + al.get(i).getId()+" 이름:"+al.get(i).getName()+" 성적 :"+al.get(i).getScore()+"\n";
		}
		
		return str;
		
	}
	public String sort_score() {
		Collections.sort(al,new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getScore()-o2.getScore();
			}
		});
		
		String str = ""; // 공백을 주고
		
		for(int i = 0; i <al.size(); i++)
		{
			str = str + "ID:" + al.get(i).getId()+" 이름:"+al.get(i).getName()+" 성적 :"+al.get(i).getScore()+"\n";
		}
		
		return str;
	}

}

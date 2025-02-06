package basic;

import java.util.ArrayList;
import java.util.Scanner;

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
	public void create() {
		System.out.println("학번을 입력해주세요 : ");
		id = scan.nextLine();
		
		//id 가 존재하면 등록안됨
		for(int i = 0; i<al.size(); i++)
		{
			Student stu = al.get(i);
			if(id.equals(stu.getId())) {	//아이디중복방지코드. 아이디객체가 같다면 아래의 문구띄워줌.
				System.out.println("이미 존재하는 id 입니다.");
				return;
			}
		}
		
		System.out.println("학생 이름 : ");
		name = scan.nextLine();
		
		System.out.println("학생 성적 : ");
		int score = Integer.parseInt(scan.nextLine());
		
		Student stu = new Student(id, name, score);
		
		al.add(stu);
	}
	//2. 조회
	public void read() {
		// TODO Auto-generated method stub
		for(int i = 0; i <al.size(); i++)
		{
			System.out.println("ID:" + al.get(i).getId()+" 이름:"+al.get(i).getName()+" 성적 :"+al.get(i).getScore());
		}
		
	}
	//3.수정
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("수정할 ID를 입력하세요 :");
		id=scan.nextLine().trim();
		
		for(int i = 0; i<al.size();i++)
		{
			Student stu = al.get(i);
			if(id.equals(stu.getId())) {
				al.remove(i);
			}
			else {
				System.out.println("수정할 id가 없습니다.");
				return;
			}
			
		}
		System.out.println("수정할 내용을 다시 입력하세요.");
		create();
	}
	//삭제
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("삭제할 id를 입력하세요:");
		id = scan.nextLine();
		
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
				System.out.println(tempIndex + "번째 id 가 삭제됨.");
			}else {
				System.out.println("삭제할 id가 없습니다.");
			}
		}
	}

	public void call() {
		// TODO Auto-generated method stub
		System.out.println("무엇을 불러올까요?");
	}

	public void save() {
		// TODO Auto-generated method stub
		System.out.println("저장할까요?");
	}
	
	public void sort() {
		System.out.println("정렬");
	}

}

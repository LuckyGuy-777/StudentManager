package basic;

import java.util.Scanner;


public class StudentUI {
	private Scanner scan;
	private StudentDAO dao;
	
	public StudentUI()
	{
		scan = new Scanner(System.in);
		dao = new StudentDAO();
	}
	
	
	public void getShowUsage() 
	{
		boolean bFlag = true;
		
		
		while(bFlag)
		{
			System.out.println("=============사용방법==============");
			System.out.println("1.등록 2.조회 3.수정 4.삭제 0.종료");
			System.out.println("5.저장 6.불러오기");
			
			String menu = scan.nextLine();
			if(menu.equals("0")) {
				System.out.println("종료");
				bFlag = false;
				return;
		}else {
			getUserInput(menu);
		}
	}
}
	
	public void getUserInput(String strMenu)
	{
		if(strMenu.equals("1")) {
			System.out.println("등록메뉴");
			
			dao.create();
		}
		else if(strMenu.equals("2")) {
			System.out.println("조회 메뉴");
			dao.read();
		}
		
		else if(strMenu.equals("3")) {
			System.out.println("수정 메뉴");
			dao.update();
		}
		
		else if(strMenu.equals("4")) {
			System.out.println("삭제 메뉴");
			dao.delete();
		}
		
		else if(strMenu.equals("5")) {
			System.out.println("저장 메뉴");
			
			dao.save();
		}
		
		else if(strMenu.equals("6")) {
			System.out.println("불러 오기");
			
			dao.call();
		}
		
		else  {
			System.out.println("0~4 사이의 숫자를 입력하세요");
		}
	}
	
	public static void main(String[] args) 
	{
		
		StudentUI ui = new StudentUI();
		ui.getShowUsage();
	}

}

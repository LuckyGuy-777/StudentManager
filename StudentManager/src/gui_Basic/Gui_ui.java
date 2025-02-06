package gui_Basic;

//이 파일을 실행시키면 창이 뜸
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Gui_ui extends JFrame implements ActionListener,FocusListener{
	
	private JMenuBar jmb = new JMenuBar();
	private JMenu file = new JMenu("파일");
	private JMenu sort1 = new JMenu("정렬");
	
	private JMenuItem file_call= new JMenuItem("파일 불러오기");
	private JMenuItem file_save = new JMenuItem("파일 저장하기");
	private JFileChooser fc = new JFileChooser();
	
	private JMenuItem sort_name= new JMenuItem("이름순으로 정렬");
	private JMenuItem sort_score = new JMenuItem("성적순으로 정렬");
	
	
	private JLabel id_L, name_L, score_L;
	private JTextField id_T, name_T, score_T;
	private JTextArea output_T;
	private JButton regist_B, view_B, exit_B,delete_B,save_B,call_B,sort_B,update_B;
	private JPanel side_P , input_P , south_P;
	private dialog dialog_edit;
	
	
	//창(폼)의 아래쪽에 버튼이 3개. (패널기능)
	//등록, 조회 등을 처리하는StudentDAO 클래스를 이용
	StudentDAO dao = new StudentDAO();
	
	Gui_ui()
	{
		dialog_edit = new dialog(this,"학생정보 수정"); // 수정 타이틀
		this.setTitle("학생관리프로그램");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.formDesign();
		this.eventHandler();
		this.setSize(530,230);
		this.setVisible(true);
	}

	
	private void formDesign() {
		// TODO Auto-generated method stub
		jmb.add(file);
		jmb.add(sort1);
		
		file.add(file_call);
		file.add(file_save);
		
		sort1.add(sort_name);
		sort1.add(sort_score);
		
		this.setJMenuBar(jmb);
		
		side_P = new JPanel();
		input_P = new JPanel();
		south_P = new JPanel();
		
		id_L = new JLabel("ID : ");
		name_L = new JLabel("이름 : ");
		score_L = new JLabel("성적 : ");
		
		id_T =  new JTextField();
		name_T =  new JTextField();
		score_T =  new JTextField();
		
		output_T = new JTextArea("**조회화면**");
		regist_B = new JButton("등록");
		view_B = new JButton("조회");
		exit_B = new JButton("종료");
		delete_B = new JButton("삭제");
		save_B = new JButton("저장");
		call_B = new JButton("불러오기");
		sort_B = new JButton("정렬");
		update_B = new JButton("수정");
		
		this.add(side_P,BorderLayout.WEST);
		side_P.setLayout(new GridLayout(2,1));
		side_P.add(input_P);
		input_P.setLayout(new GridLayout(3,2));
		input_P.add(id_L);
		input_P.add(id_T);
		input_P.add(name_L);
		input_P.add(name_T);
		input_P.add(score_L);
		input_P.add(score_T);
		
		//South영역 배치
		this.add(south_P, BorderLayout.SOUTH);
		south_P.add(regist_B);
		south_P.add(view_B);
		south_P.add(exit_B);
		south_P.add(delete_B);
		south_P.add(update_B);		
		//CENTER영역에 배치
		this.add(output_T,BorderLayout.CENTER);
		
		//이벤트가 처리되기전에
		//name_T.setEditable(false);
		//score_T.setEditable(false);
		
		//종료버튼만 활성화
		//regist_B.setEnabled(false);
		//view_B.setEnabled(false);
	}

	
	private void eventHandler() {
		// TODO Auto-generated method stub
		//등록버튼클릭
		regist_B.addActionListener(this);
		view_B.addActionListener(this);
		exit_B.addActionListener(this);
		delete_B.addActionListener(this);
		save_B.addActionListener(this);
		call_B.addActionListener(this);
		sort_B.addActionListener(this);
		update_B.addActionListener(this);
		sort_name.addActionListener(this);
		sort_score.addActionListener(this);
		file_call.addActionListener(this);
		file_save.addActionListener(this);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Gui_ui();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("등록")) {
			if(dao.create(id_T.getText(),name_T.getText(),Integer.parseInt(score_T.getText()))) {
				output_T.setText("등록이 되었습니다");
			}else {
				output_T.setText("같은 ID가 존재합니다");
			}
			id_T.setText("");
			name_T.setText("");
			score_T.setText("");
			view_B.setEnabled(true);
		}
		else if(e.getActionCommand().equals("조회")) {
			output_T.setText(dao.read());
		}
		
		else if(e.getActionCommand().equals("수정")) {
			String id =JOptionPane.showInputDialog("수정할 아이디를 입력해주세요!");
			if(dao.update(id))
			{
				dialog_edit.setVisible(true);
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, "수정할 아이디가 없습니다.");
			}
			
		}
		else if(e.getActionCommand().equals("삭제")) {
			String del = JOptionPane.showInputDialog("삭제할 아이디를 입력하세요");
			dao.delete(del);
			
			
			
		}
		else if(e.getActionCommand().equals("이름순으로 정렬"))
		{
			output_T.setText(dao.sort_name());
		}
		else if(e.getActionCommand().equals("성적순으로 정렬"))
		{
			output_T.setText(dao.sort_score());
		}
		else if(e.getActionCommand().equals("파일 저장하기")) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
			fc.setFileFilter(filter);
			
			int ret = fc.showSaveDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			fc.setCurrentDirectory(new File(".\\"));
			
			String filePath = fc.getSelectedFile().getPath();
			
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
				bw.write(output_T.getText());
				bw.close();
			}
			catch(Exception e2) {
				JOptionPane.showMessageDialog(this, "저장오류");
			}
		}
		else if(e.getActionCommand().equals("파일 불러오기"))
		{
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
			fc.setFileFilter(filter);
			
			int ret = fc.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.","경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			//사용자가 파일을 선택하고 열기 버튼을 누른 경우
			//파일 다이얼로그가 실제 파일을 열기까지 수행하는 것이 아니라, 다이얼로그는 사용자로부터 파일 이름을 얻어내는 목적에 국한된다.
			String filePath = fc.getSelectedFile().getPath();
			try {
				BufferedReader rd = new BufferedReader(new FileReader(filePath));
				output_T.setText("");
				String line;
				while((line = rd.readLine()) != null) {
				output_T.append(line +'\n');
				}
				rd.close();
			}catch(Exception e1){
				JOptionPane.showMessageDialog(this, "열기 오류");
			}
		}
		else {
			System.out.println("시스템 종료");
			System.exit(0);
		}
	}


	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(id_T))
			output_T.setText("ID를 입력하세요 "+'\n');
		else if(e.getSource().equals(name_T))
			output_T.setText("이름을 입력하세요 "+'\n');
		else if(e.getSource().equals(score_T))
			output_T.setText("성적을 입력하세요 "+'\n');
	}


	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(id_T))
		{
			if(id_T.getText() == "")
				output_T.setText("아이디가 없습니다.");
			else
				name_T.setEditable(true);
		}
		else if(e.getSource().equals(score_T)) {
			if(score_T.getText() == "")
				output_T.setText("성적이 없습니다");
		}
	} 
	
	//수정할아이디 입력가능한 다이얼로그 창 구현.
	class dialog extends JDialog
	{
		private JLabel edit_id_L,edit_name_L,edit_score_L;
		private JTextField edit_id_T,edit_name_T,edit_score_T;
		private JPanel input_P,south_P;
		private JButton edit_btn_b;
		
	
		
		
		//메소드
		
		dialog(JFrame frame, String title) {
			super(frame,title,true);
			//생성자(사용자)
			//폼디자인
			this.dformDesign();
			this.deventHandler();
			this.setSize(530,230);
		}
		public void dformDesign()
		{
			input_P = new JPanel();
			south_P = new JPanel();
			
			
			//디자인배치
			edit_id_L = new JLabel("ID : ");
			edit_name_L = new JLabel("이름 : ");
			edit_score_L = new JLabel("성적 : ");
			edit_id_T = new JTextField();
			edit_score_T = new JTextField();
			edit_name_T = new JTextField();
			edit_btn_b = new JButton("수정");
			
			
			this.setLayout(new GridLayout(2,1));
			
			this.add(input_P);
			input_P.setLayout(new GridLayout(2,1));
			input_P.add(edit_id_L);
			input_P.add(edit_name_L);
			input_P.add(edit_score_L);
			input_P.add(edit_id_T);
			input_P.add(edit_name_T);
			input_P.add(edit_score_T);
			
			
			this.add(south_P,BorderLayout.SOUTH);
			south_P.add(edit_btn_b);
			
		}
		public void deventHandler()
		{
			//기능
			edit_btn_b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if(e.getActionCommand().equals("수정"))
					{
						
						if(dao.create(edit_id_T.getText(),edit_name_T.getText(),Integer.parseInt(edit_score_T.getText()))) {
							edit_id_T.setText("");
							edit_name_T.setText("");
							edit_score_T.setText("");
							
							setVisible(false);
							
						}else {
							output_T.setText("수정할 ID가 존재하지 않습니다.");
						}
						
					}
				}
			});
			
		}
	}
	class Delete_dialog extends JDialog
	{
		private JLabel Delete_id_L,Delete_name_L,Delete_score_L;
		private JTextField Delete_id_T,Delete_name_T,Delete_score_T;
		private JPanel input_P,south_P;
		private JButton Delete_btn_b;
		
	
		
		
		//메소드
		
		Delete_dialog(JFrame frame, String title) {
			super(frame,title,true);
			//생성자(사용자)
			//폼디자인
			this.dformDesign();
			this.deventHandler();
			this.setSize(530,230);
		}
		public void dformDesign()
		{
			input_P = new JPanel();
			south_P = new JPanel();
			
			
			//디자인배치
			Delete_id_L = new JLabel("ID : ");
			Delete_name_L = new JLabel("이름 : ");
			Delete_score_L = new JLabel("성적 : ");
			Delete_id_T = new JTextField();
			Delete_score_T = new JTextField();
			Delete_name_T = new JTextField();
			Delete_btn_b = new JButton("삭제");
			
			
			this.setLayout(new GridLayout(2,1));
			
			this.add(input_P);
			input_P.setLayout(new GridLayout(2,1));
			input_P.add(Delete_id_L);
			input_P.add(Delete_name_L);
			input_P.add(Delete_score_L);
			input_P.add(Delete_id_T);
			input_P.add(Delete_name_T);
			input_P.add(Delete_score_T);
			
			
			this.add(south_P,BorderLayout.SOUTH);
			south_P.add(Delete_btn_b);
			
		}
		public void deventHandler()
		{
			//기능
			Delete_btn_b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if(e.getActionCommand().equals("수정"))
					{
						
						if(dao.create(Delete_id_T.getText(),Delete_name_T.getText(),Integer.parseInt(Delete_score_T.getText()))) {
							Delete_id_T.setText("");
							Delete_name_T.setText("");
							Delete_score_T.setText("");
							
							setVisible(false);
							
						}else {
							output_T.setText("수정할 ID가 존재하지 않습니다.");
						}
						
					}
				}
			});
			
		}
	}

}

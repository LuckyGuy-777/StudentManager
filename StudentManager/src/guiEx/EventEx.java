package guiEx;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventEx extends JFrame {
	private JButton btn = new JButton("OK");
	
	EventEx(){
		this.setTitle("학생관리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.formDesign();
		this.eventHandler();
		this.setSize(300,200);
		this.setVisible(true);
	}
	
	private void eventHandler() {
		// TODO Auto-generated method stub
		//1.이벤트 소스 찾기 0 btn
		//2. 이벤트 소스가 이벤트를 들을수 있도록 귀를 달아준다.
		//3. 이벤트리스너 구현 1)익명중첩클래스
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(btn.getText().equals("OK"))
				{
					btn.setText("버튼클릭");
					btn.setBackground(Color.yellow);
				}
				else {
					btn.setText("ok");
					btn.setBackground(Color.red);
				}
			}
			
		});//OK를 클릭했을때 반응.
	}
	public void formDesign(){
		this.setLayout(new FlowLayout());
		this.add(btn);
	}//인터페이스(창)
	
	public static void main(String[] args) {
		new EventEx();
	}
}

package guiEx;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventEx1 extends JFrame {
	private JButton btn = new JButton("ok");
	
	EventEx1()
	{
		this.setTitle("EventEx1 - 프레임자체에 구현");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.formDesign();
		this.eventHandler();
		this.setSize(300,200);
		this.setVisible(true);
	}
	
	private void formDesign() {
		// TODO Auto-generated method stub
		this.setLayout(new FlowLayout());
		this.add(btn);
	}
	
	private void eventHandler() {
		// TODO Auto-generated method stub
		//1.이벤트소스 찾기 -> btn
		//2. 이벤트소스에 귀를달아줌 btn.add...리스너();
		//3. 이벤트리스너를 구현하여 객체를 넣어줌.
		//
		// 이벤트 리스너 구현 1 익명중첩클래스
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(btn.getText().equals("ok")) {
					btn.setText("버튼 클릭");
					btn.setBackground(Color.yellow);
				}
				else {
					btn.setText("ok");
					btn.setBackground(Color.red);
				}
			}
			
		});
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EventEx1();
	}
	public void actionPerfomred(ActionEvent e)
	{
		
	}

}

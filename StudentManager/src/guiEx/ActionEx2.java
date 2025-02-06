package guiEx;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionEx2 extends JFrame {
	private JButton okBtn = new JButton("OK");
	private JButton cancelBtn = new JButton("Cancel");
	private JPanel p = new JPanel();
	
	ActionEx2()
	{
		this.setTitle("EventEx2 - 내부클래스로 구현");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.formDesign();
		this.evnetHandler();
		this.setSize(300,200);
		this.setVisible(true);
	}

	
	private void formDesign() {
		// TODO Auto-generated method stub
		this.setLayout(new BorderLayout());
		this.add(p,BorderLayout.SOUTH);
		p.setLayout(new FlowLayout());
		p.add(okBtn);
		p.add(cancelBtn);
	}


	private void evnetHandler() {
		// TODO Auto-generated method stub
		okBtn.addActionListener(new MyActionListener());//내부클래스방식
	}


	public static void main(String[] args) {
		new ActionEx2();
	}
	
	//내부클래스로 구현
	class MyActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(okBtn.getActionCommand().equals("OK"))
			{
				okBtn.setText("버튼클릭");
			}
			else
			{
				okBtn.setText("OK");
			}
		}
		
	}
}        

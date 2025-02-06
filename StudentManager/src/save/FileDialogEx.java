package save;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileDialogEx extends JFrame implements ActionListener {
	private JMenuBar mb = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenuItem openItem = new JMenuItem("Open");
	private JMenuItem saveItem = new JMenuItem("save");
	
	FileDialogEx(){
		this.setTitle("파일다이얼로그");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.formDesign();
		this.eventHandler();
		this.setSize(300,200);
		this.setVisible(true);
	}
	private void formDesign() {
		// TODO Auto-generated method stub
		mb.add(fileMenu);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		this.setJMenuBar(mb);
		
		this.add(imgLabel);
	}
	private void eventHandler() {
		// TODO Auto-generated method stub
		openItem.addActionListener(null);
		saveItem.addActionListener(null);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileDialogEx();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Open")) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JBG&GIF","jpg","gif");
			fc.setFileFilter(filter);
			
			int ret = fc.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
				return;
			}
			String filePath = fc.getSelectedFile().getPath();
			imgLabel.setIcon(new ImgIcon(filePath));
			pack();
		}
		else if(e.getActionCommand().equals("Save")) {}
	}

}


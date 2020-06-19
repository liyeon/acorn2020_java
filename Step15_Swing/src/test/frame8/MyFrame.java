package test.frame8;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class MyFrame extends JFrame implements ActionListener{
	JTextField inputMsg;
	//default 생성자
	public MyFrame() {
		setLayout(new FlowLayout());
		//문자열 한줄을 입력할수있는 JTextField
		this.inputMsg = new JTextField(20);//10개의 칼럼
		//<input type="text" />
		add(inputMsg);
		JButton sendBtn = new JButton("전송");
		sendBtn.setActionCommand("send");
		sendBtn.addActionListener(this);
		add(sendBtn);
	}
	
	public static void main(String[] args) {
		//MyFrame 클래스를 이용해서 객체를 생성하고 참조값을 지역 변수 frame에 담기
		MyFrame frame = new MyFrame();
		//프레임의 제목 설정
		frame.setTitle("나의 프레임");
		//프레임을 닫으면 자동으로 프로세스가 종료되도록한다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
		JButton btn= new JButton();
	}
	//ActionListener 인터페이스를 구현해서 강제 오버라이드된 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("send")) {//자바에서 문자열 비교 .equals // 전송 버튼을 눌렀을 때
			//JTextField에 입력한 문자열을 읽어와야한다.
			String msg = inputMsg.getText();
			JOptionPane.showMessageDialog(this, msg);
		}
	}
}

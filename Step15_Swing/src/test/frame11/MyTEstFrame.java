package test.frame11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class MyTEstFrame extends JFrame implements ActionListener{
	JTextField inputMsg;
	JTextField inputMsg2;
	JLabel lab1;
	JLabel lab2;
	public MyTEstFrame() {
		//문자열 한줄을 입력할수있는 JTextField
		inputMsg = new JTextField(15);
		
		inputMsg2 = new JTextField(15);
		
		JButton addBtn = new JButton("+");
		addBtn.addActionListener(this);
		JButton subBtn = new JButton("-");
		subBtn.addActionListener(this);
		JButton multiBtn = new JButton("*");
		multiBtn.addActionListener(this);
		JButton diviBtn = new JButton("/");
		diviBtn.addActionListener(this);
//		add(addBtn);
//		add(subBtn);
//		add(multiBtn);
//		add(diviBtn);
		addBtn.setBackground(Color.ORANGE);
		subBtn.setBackground(Color.PINK);
		multiBtn.setBackground(Color.YELLOW);
		diviBtn.setBackground(Color.CYAN);
		
		
		//JLabel 객체 생성
		lab1=new JLabel(" = ");
		lab2=new JLabel("0");
		//JPanel 객체 생성
		JPanel panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(panel);
		//JPanel에 UI추가하고 
		panel.add(inputMsg);
		panel.add(addBtn);
		panel.add(subBtn);
		panel.add(multiBtn);
		panel.add(diviBtn);
		panel.add(inputMsg2);
		panel.add(lab1);
		panel.add(lab2);
		lab1.setFont(new Font("맑은 고딕", Font.BOLD, 30));;
		lab2.setFont(new Font("맑은 고딕", Font.BOLD, 30));;
		//파일에 패널 색 지정하기
		
	
	}
	
	public static void main(String[] args) {
		//MyFrame 클래스를 이용해서 객체를 생성하고 참조값을 지역 변수 frame에 담기
		MyTEstFrame frame = new MyTEstFrame();
		//프레임의 제목 설정
		frame.setTitle("나의 프레임");
		//프레임을 닫으면 자동으로 프로세스가 종료되도록한다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		String command = e.getActionCommand();
		double msg = Double.parseDouble(inputMsg.getText());
		double msg2 = Double.parseDouble(inputMsg2.getText());
			if(command.equals("+")){
				//읽어온 문자열을 JLabel에 추가하기
				double result = msg+msg2;
				lab2.setText(""+result);
				//입력창 문자열 삭제하기
				inputDelete();
			}else if(command.equals("-")){
				//읽어온 문자열을 JLabel에 추가하기
				double result = msg-msg2;
				lab2.setText(""+result);
				//입력창 문자열 삭제하기
				inputDelete();
				
			}else if(command.equals("*")){
				//읽어온 문자열을 JLabel에 추가하기
				double result = msg*msg2;
				lab2.setText(""+result);
				//입력창 문자열 삭제하기
				inputDelete();
			}else if(command.equals("/")){
				//읽어온 문자열을 JLabel에 추가하기
				double result = msg/msg2;
				lab2.setText(""+result);
				if(Double.isInfinite(result)) {
					zeroTry();
				}else if(Double.isNaN(result)) {
					zeroTry();
				}
				//입력창 문자열 삭제하기
				inputDelete();
				
			}
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(MyTEstFrame.this, "숫자 형식에 맞게 입력해주세요");
			nfe.printStackTrace();
		}	
		
		
	}//action종료

	public void inputDelete() {
		inputMsg.setText("");
		inputMsg2.setText("");
	}
	public void zeroTry() {
		lab1.setText("0으로는 나눌 수 없습니다.");
		JOptionPane.showMessageDialog(MyTEstFrame.this, "0으로는 나눌 수 없습니다.");
		
	}
	//java.lang.NumberFormatException
	
}

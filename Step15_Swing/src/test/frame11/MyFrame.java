package test.frame11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	//필드
	JTextField tf_num1, tf_num2;
	JLabel label_result;
	
	// Default 생성자
	public MyFrame() {
		// 프레임의 레이아웃 법칙 설정하기(프레임의 메소드를 불러온다.) 동서남북 센터로 구역을 나눌 수 있다.
		setLayout(new BorderLayout());

		// JPanel
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.YELLOW);
		// Panel을 북쪽에 배치하기
		add(topPanel, BorderLayout.CENTER);

		// JTextField 객체를 만들어서 Jpanel에 추가하기.
		tf_num1 = new JTextField(10);
		topPanel.add(tf_num1);

		// 기능 버튼 객체를 만들어서 Jpanel에 추가하기.
		JButton plusBtn = new JButton("+");
		JButton minusBtn = new JButton("-");
		JButton multiBtn = new JButton("*");
		JButton divideBtn = new JButton("/");
		plusBtn.setBackground(Color.CYAN);
		minusBtn.setBackground(Color.ORANGE);
		multiBtn.setBackground(Color.PINK);
		divideBtn.setBackground(Color.GREEN);
		topPanel.add(plusBtn);
		topPanel.add(minusBtn);
		topPanel.add(multiBtn);
		topPanel.add(divideBtn);
		//두번째 JTExtField 만들어서 페널에 추가하기.
		tf_num2 = new JTextField(10);
		topPanel.add(tf_num2);
		//JLabel
		JLabel label1=new JLabel("=");
		label_result = new JLabel("0");
		//패널에 레이블 추가하기.
		topPanel.add(label1);
		topPanel.add(label_result);
		//버튼에 리스너 등록하기
		plusBtn.addActionListener(this);
		minusBtn.addActionListener(this);
		multiBtn.addActionListener(this);
		divideBtn.addActionListener(this);
		//버튼에 액션 command 지정하기
		plusBtn.setActionCommand("plus");
		minusBtn.setActionCommand("minus");
		multiBtn.setActionCommand("multi");
		divideBtn.setActionCommand("divide");
	}

	public static void main(String[] args) {
		// MyFrame 클래스를 이용해서 객체를 생성하고 참조값을 지역 변수 frame에 담기
		MyFrame frame = new MyFrame();
		// 프레임의 제목 설정
		frame.setTitle("계산기");
		// 프레임을 닫으면 자동으로 프로세스가 종료되도록한다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);

	}
	//ActionListener 인터페이스를 구현해서 강제 오버라이드된 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
		//눌러진 버튼의 command 읽어오기
		String command = e.getActionCommand();
		//JTextField에 입력한 문자열을 읽어와서 숫자(실수)로 바꿔준다.
		double num1 = Double.parseDouble(tf_num1.getText());
		double num2 = Double.parseDouble(tf_num2.getText());
		double result=0;
		if(command.equals("plus")) {
			result = num1 + num2;
		}else if(command.equals("minus")) {
			result = num1 - num2;
		}else if(command.equals("multi")) {
			result = num1 * num2;
			
		}else if(command.equals("divide")) {
			result = num1 / num2;
			if(Double.isInfinite(result)) {
				zeroTry();
			}else if(Double.isNaN(result)) {
				zeroTry();
			}//nan 예외처리 
		}//나누기 종료
		
		//결과값 JLabel에 출력하기
		label_result.setText(Double.toString(result));
		}catch(Exception exe) {
			JOptionPane.showMessageDialog(this, "숫자 형식에 맞게 입력해주세요");
			exe.printStackTrace();
		};//catch 종료
	}//actionPerformed 종료
	
	public void zeroTry() {
		label_result.setText("0으로는 나눌 수 없습니다.");
		JOptionPane.showMessageDialog(this, "0으로는 나눌 수 없습니다.");
	}
	
}//void main 종료

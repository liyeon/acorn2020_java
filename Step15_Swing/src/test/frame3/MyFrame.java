package test.frame3;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
//생성자
	public MyFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//레이아웃 매니저를 GridLayout으로 지정하기(2행2열
		//격자 레이아웃
		setLayout(new GridLayout(6, 4)); 
		JButton btn1 = new JButton("버튼1");
		add(btn1);//프레임에 btn1 추가하기

		JButton btn2 = new JButton("버튼2");
		add(btn2);//프레임에 btn1 추가하기
		
		JButton btn3 = new JButton("버튼3");
		add(btn3);//프레임에 btn1 추가하기
		
		JButton btn4 = new JButton("버튼4");
		add(btn4);//프레임에 btn1 추가하기
		
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
}

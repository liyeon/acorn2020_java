package test.frame4;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
//생성자
	public MyFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//레이아웃 매니저를 BorderLayout으로 지정하기
		setLayout(new BorderLayout()); 
		JButton btn1 = new JButton("버튼1");
		add(btn1, BorderLayout.NORTH);//프레임에 btn1 추가하기 북

		JButton btn2 = new JButton("버튼2");
		add(btn2, BorderLayout.WEST);//프레임에 btn1 추가하기서
		
		JButton btn3 = new JButton("버튼3");
		add(btn3, BorderLayout.EAST);//프레임에 btn1 추가하기 동 
		
		JButton btn4 = new JButton("버튼4");
		add(btn4, BorderLayout.SOUTH);//프레임에 btn1 추가하기 남
		
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
}

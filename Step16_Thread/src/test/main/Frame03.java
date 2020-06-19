package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import test.mypac.CountRunnable;
import test.mypac.CountThread;

public class Frame03 extends JFrame implements ActionListener {

	// 생성자
	public Frame03() {
		// 레이아웃 설정
		setLayout(new BorderLayout());
		// 패널을 프레임의 상단에 배치
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		add(panel, BorderLayout.NORTH);
		// 버튼을 패널에 추가하고
		JButton countBtn = new JButton("1~10까지 세기");
		panel.add(countBtn);
		// 버튼에 리스너 드록하기
		countBtn.addActionListener(this);
		countBtn.setBackground(Color.orange);

	}// 생성자 종료

//실행순서가 들어오는 흐름의 작업단위를  Thread라고 한다. main thread 하나의 작업 단위를 쓰고 잇었음.
	// run했을 때 실행됨
	public static void main(String[] args) {
		// MyFrame 클래스를 이용해서 객체를 생성하고 참조값을 지역 변수 frame에 담기
		Frame03 frame = new Frame03();
		// 프레임의 제목 설정
		frame.setTitle("Frame01");
		// 프레임을 닫으면 자동으로 프로세스가 종료되도록한다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);

	}// main 종료
//눈에 보이지 않는 작업단위, 실행의 흐름을 thread라고 함. 

	@Override
	// 버튼누르면 실행의 흐름이 일로 옴
	public void actionPerformed(ActionEvent arg0) {
		//Runnable 인터페이스를 구현한 클래스로 객체 생성
		CountRunnable r = new CountRunnable();
		//Thread 객체를 생성하면서 생성자의 인자로 전달한다.
		Thread t = new Thread(r);
		//start()메소드를 호출해서 새로운 스레드를 시작한다.
		t.start();
		System.out.println("새로운 스레드를 시작했습니다.");
	}

}

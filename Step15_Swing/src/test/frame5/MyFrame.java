package test.frame5;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class MyFrame extends JFrame{//자동으로 오브젝트를 상속받음
	//default 생성자
	public MyFrame() {
		//레이아웃 매니저 지정학기
		setLayout(new FlowLayout());
		//버튼
		JButton sendBtn = new JButton("전송");
		JButton removeBtn = new JButton("삭제");
		//프레임에 버튼 추가하기(FlowLayout의 영향을 받는다)
		add(sendBtn);
		add(removeBtn);
		
		MyFrame a = this;
		
		//ActionListener 인터페이스 type  의 참조값 
		ActionListener listener = new ActionListener() { //전송버튼의 객체 역할을 할 listener
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("전송합니단");
				ActionListener a = this;
				JOptionPane.showMessageDialog(MyFrame.this, "전송합니다!"); 
				//바깥쪽 클래스의 참조값; = 클래스명.this
				//콘솔 창으로 들어오는게 아닌 팝업창으로 뜸
			}
		}; 
		sendBtn.addActionListener(listener);//실행순서는 오버라이드 안 쪽으로 들어감
		//객체의 참조값을 전달
		//lamda식 활용해보기
		removeBtn.addActionListener((e)->{//javascript의 addEventLister와 동일
			JOptionPane.showMessageDialog(MyFrame.this, "삭제합니다.");
		});
	}
	
	public static void main(String[] args) {
		//MyFrame 클래스를 이용해서 객체를 생성하고 참조값을 지역 변수 frame에 담기
		MyFrame frame = new MyFrame();
		//process?
		//운영프로그램을 실행 할 수 있도록 할당을 받는게 process
		//응용프로그램을 여러개 실행하려면 멀티 프로세싱이 필요하다.
		//termineated - 운영체제로부터 할당 받은 프로세스가 사라짐
		//프레임의 제목 설정
		frame.setTitle("나의 프레임");
		//프레임을 닫으면 자동으로 프로세스가 종료되도록한다.
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//자동으로 프로세스가 종료된다.
		//상수값을 전달해서 의미없는 숫자에 의미있는 이름을 붙인 것 - 상수화
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
		JButton btn= new JButton();
		
	}
}

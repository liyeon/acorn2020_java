package test.frame6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class MyFrame extends JFrame implements ActionListener{//자동으로 오브젝트를 상속받음
	//default 생성자
	public MyFrame() {
		//레이아웃 매니저 지정학기
		setLayout(new FlowLayout());
		//버튼
		JButton sendBtn = new JButton("전송");
		JButton removeBtn = new JButton("삭제");
		
		//버튼에 command 등록하기(어떤 기능을 하는 버튼인지)
		sendBtn.setActionCommand("send");//어떤 동작을 하는 버튼인지 읽어온다.
		removeBtn.setActionCommand("remove");
		
		
		//프레임에 버튼 추가하기(FlowLayout의 영향을 받는다)
		add(sendBtn);
		add(removeBtn);
		
		ActionListener a = this;
		MyFrame b = this;
		JFrame c = this;
		
		
		//MyFrame 객체의 참조값을 전달해서 리스너 등록하기
		sendBtn.addActionListener(this);
		removeBtn.addActionListener(this);
		
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
	//ActionListener 인터페이스를 구현해서 강제 오버라이드 된 메소드
	//프레임의 멤버 메소드로 바뀜. 프레임은 ACtionLister타입이기도하게바뀜
	//프레임 자체를 ActionLister로 바뀜
	//send 버튼, remove버튼을  누르면 밑으로 들어온다.
	@Override
	public void actionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(this, "버튼을 눌렀습니다.");
		//분기? 어떤 버튼을 눌렀는지 구분 한다.
		
		//set액션 Command 읽어오기
		String command = e.getActionCommand();
		if(command.equals("send")) {//자바에서 문자열 비교 .equals // 전송 버튼을 눌렀을 때
			JOptionPane.showMessageDialog(this, "전송합니다.");
		}else if(command.equals("remove")) {
			JOptionPane.showMessageDialog(this, "삭제합니다.");// 삭제 버튼을 눌렀을 때
		}
		
	}
}

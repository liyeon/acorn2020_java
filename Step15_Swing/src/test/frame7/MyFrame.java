package test.frame7;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class MyFrame extends JFrame implements ActionListener{
	JButton sendBtn;//필드에 저장
	JButton removeBtn;//공유할 값을 담아둔다.

	//default 생성자
	public MyFrame() {
		//레이아웃 매니저 지정학기
		setLayout(new FlowLayout());
		//버튼
		this.sendBtn = new JButton("전송");
		this.removeBtn = new JButton("삭제");
		//MyFrame 객체의 참조값을 전달해서 리스너등록하기
		sendBtn.addActionListener(this);
		removeBtn.addActionListener(this);
		//프레임에 버튼 추가하기(FlowLayout의 영향을 받는다)
		add(sendBtn);
		add(removeBtn);
		
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
		//이벤트가 발생한 UI(JButton)의 참조값을 얻어온다
		Object obj = e.getSource();//이벤트가 일어난 ui객체의 참조값을 리턴해준다.
		
		if(obj == sendBtn) {//전송버튼을 늘랐디먄
			JOptionPane.showMessageDialog(this, "전송합니다.");
		}else if(obj == removeBtn) {//삭제버튼을 눌렀다면
			JOptionPane.showMessageDialog(this, "삭제합니다.");
		}
		
		JButton a = new JButton();
		Object b = a;
		
	}
}

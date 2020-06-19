package test.frame10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class MyFrame extends JFrame
					 implements ActionListener, KeyListener{
	//필드
	JTextField inputMsg;
	JLabel lab1;
	JList<String> list;
	DefaultListModel<String> model;
	int listIndex;
	//static final 상수(final)
	static final String COMMAND_SEND="전송";
	static final String COMMAND_REMOVE="선택삭제";
	//default 생성자
	public MyFrame() {
		setLayout(new BorderLayout());
		//문자열 한줄을 입력할수있는 JTextField
		this.inputMsg = new JTextField(10);
		inputMsg.addKeyListener(this);
		
		
		JButton sendBtn = new JButton("전송");
		sendBtn.setActionCommand(COMMAND_SEND);
		sendBtn.addActionListener(this);
		//삭제 버튼
		JButton removeBtn=new JButton("선택삭제");
		removeBtn.addActionListener(this);
		removeBtn.setActionCommand(COMMAND_REMOVE);
		add(removeBtn, BorderLayout.SOUTH);
		removeBtn.setBackground(Color.ORANGE);
		
		
		
		
		//JLabel 객체 생성
		lab1=new JLabel("label입니다.");
		
		//JPanel 객체 생성
		JPanel panel= new JPanel();//패널?판넬?
		//패널도 레이아웃을 지정 할 수 있다.(기본값은 FlowLayout 가운데 정렬이다.)
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//JPanel에 UI추가하고 
		panel.add(inputMsg);
		panel.add(sendBtn);
		panel.add(lab1);
		//파일에 패널 색 지정하기
		panel.setBackground(Color.YELLOW);
		
		//JFrame에 JPanel을 북쪽에 배치하기
		add(panel, BorderLayout.NORTH);
		
		//목록을 출력 할 수 있는 Jlist
		list=new JList<String>();
		//기본 모델 객체(목록에 출력할 Data 를 가지고 있는 객체)
		model=new DefaultListModel<String>();
		model.addElement("김구라");
		model.addElement("해골");
		model.addElement("원숭이");
		model.addElement("덩어리");
		model.addElement("원숭이");
		
		
		//목록에 모델 연결하기
		list.setModel(model);
		
		list.setBackground(Color.PINK);
		
		//스크롤 패널에 목록 넣어주기
		JScrollPane sc = new JScrollPane(list,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,//상수값을 지정된 상수명으로 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
				);
		
		//스크롤 패널을 프레임의 가운데에 배치하기
		add(sc, BorderLayout.CENTER);
		//data->model->Jlist
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
		if(command.equals(COMMAND_SEND)) {//자바에서 문자열 비교 .equals // 전송 버튼을 눌렀을 때
			send();
		}else if(command.equals(COMMAND_REMOVE)){
			//JList겍체에게 선택된 item이 있는지. 있다면 몇번째 아이템이 선택되었는지 물어봐야한다.(메소드를 이용해야한다.)
			
			int selectedIndex = list.getSelectedIndex();
			
			if(selectedIndex >= 0) {//선택된 Cell 이 있을 때
				int result = JOptionPane.showConfirmDialog(this, selectedIndex + "번을 지우겠습니까?");
				if(result == JOptionPane.YES_OPTION) {
					
					//JList에 연결된 모델에서 해당 인덱스를 삭제한다.
					model.remove(selectedIndex);
					
					System.out.println("지워진 Index값은"+selectedIndex+" 번 입니다.");
				}else{
					System.out.println("선택된 INDEX 값은" + selectedIndex + "번 입니다.");
				}
			
					
			}else {//선택되 Cell이 없을 때
				JOptionPane.showMessageDialog(this, "삭제할 Cell을 선택해주세요");
			}
		};
		
		
		
	}
	//키를 눌렀을 때 호출되는 메소드
	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("pressed");
		//눌러진 키보드의 코드값을 읽어온다.
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {//상수 10
			send();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	
	public void send() {
		//JTExtField에 입력한 문자열을 읽어와야한다.
		String msg = inputMsg.getText();
		//읽어온 문자열을 JLabel에 추가하기
		lab1.setText(msg);
		//입력창 문자열 삭제하기
		inputMsg.setText("");
		//모델에 입력한 문자열 추가하기
		model.addElement(msg);
	
	}
	
	
	
	
}

package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class Quiz03 extends JFrame implements ActionListener {
	JTextArea area;

	// 생성자
	public Quiz03() {

		try {
			UIManager.setLookAndFeel("javax");
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		} catch (Exception e) {
		}
		// JFrame을 상속받아서 setTitle을 쓸 수 있다.
		// 프레임의 제목 설정
		setTitle("나의 파일");// this가 생략되어있다. 나의참조값 = this
		// 프레임의 레이아웃지정
		setLayout(new BorderLayout());
		// 메뉴 아이템 3개 만들기
		JMenuItem item_new = new JMenuItem("New");// 생성자의 인자로 String 이름 전달
		JMenuItem item_open = new JMenuItem("Open", 0);
		// default 생성자를 호출해서 객체를 생성 한 후
		JMenuItem item_save = new JMenuItem();
		// 아이템 text를 메소드를 이용해서 전달 가능하다.
		item_save.setText("Save");// 메소드로 이름 전달

		// 아이템에 ActionCommand지정하기
		item_new.setActionCommand("new");
		item_open.setActionCommand("open");
		item_save.setActionCommand("save");
		// 아이템에 ActionListener등록하기
		item_new.addActionListener(this);
		item_open.addActionListener(this);
		item_save.addActionListener(this);// 액션리스너를 구현으로 받아줬기때문에 this가 될 수 있다.

		// 메뉴에 아이템 추가
		JMenu menu1 = new JMenu("File입니다.");
		menu1.add(item_new);
		menu1.add(item_open);
		menu1.add(item_save);

		JMenu menu2 = new JMenu();
		menu2.setText("도움말");

		// 메뉴바에 메뉴 추가
		JMenuBar mb = new JMenuBar();
		mb.add(menu1);
		mb.add(menu2);
		// 메뉴아이템->메뉴->메뉴바->프레임
		// 프레임에 메뉴바 장착
		setJMenuBar(mb);

		// 텍스트 area를 프레임의 가운데에 배치

		area = new JTextArea();
		add(area, BorderLayout.CENTER);
		area.setBackground(Color.PINK);
		area.setVisible(false);
		Font font = new Font("맑은 고딕", Font.BOLD, 18);
		area.setFont(font);
		JScrollPane scroll = new JScrollPane(area);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll);
		scroll.setBackground(Color.ORANGE);
	}// 생성자 종료
		// run했을 때 실행순서가 시작되는 메인 메소드

	public static void main(String[] args) {
		// 프레임을 만들어서 화면에 띄우는 작업을 한다.
		Quiz03 f = new Quiz03();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}// 메인 메소드 종료
		// File > 메뉴 아이템을 클릭하면 호출되는 메소드

	@Override
	public void actionPerformed(ActionEvent e) {

		// 눌러진 아이콘의 액션 command를 읽어온다.
		String command = e.getActionCommand();
		if (command.equals("new")) {// 아이템 New 를 눌렀을 때
			area.setText("");//문자열삭제
			area.setVisible(true);// JTextArea를 보이게 하고
			area.grabFocus();// 포커스를 준다.
			
		} else if (command.equals("open")) {// 아이템 Open 를 눌렀을 때
			area.setText("");
			openContent();
		} else if (command.equals("save")) {// 아이템 Save 를 눌렀을 때
			saveContent();
		} // command if 종료

	} // action 종료
		// 파일에 있는 문자열을 읽어와서 출력하는 작업을 하는 메소드

	public void openContent() {
		// 해당 주소를 띄우는 방법
		JFileChooser fc = new JFileChooser("c:/acorn2020/myFolder");
		// 파일을 open하는 다이얼로그 띄우기
		int result = fc.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {// 열기 버튼 눌렀을 때
			// 선택한 파일을 access 할 수 있는 파일 객체
			// open할 예정인 파일 객체의 참조값얻어오기
			File file = fc.getSelectedFile();
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				// 파일에서 문자열을 읽어들일 객체의 참조값을 미리 만들어준 지역 변수에 담는다.
				fr = new FileReader(file);
				br = new BufferedReader(fr);

				while (true) {// 반복문 돌면서
					// 문자열을 줄단위로 (개행기호기준으로)한줄씩읽어낸다.
					String line = br.readLine();
					if (line == null) {//더이상읽을문자열이없다면
						break;// 반복문 탈출
					} // if종료
						//JTextArea에 문자열을 개행기호와 함께 append(누적출력)하기
					area.setVisible(true);
					area.append(line);
					area.append("\r\n");
				} // while종료
				
			}catch (FileNotFoundException ie) {
				ie.printStackTrace();

			} catch (IOException ie) {
				ie.printStackTrace();

			} finally {// 예외가 발생하던 안하던 반드시 실행이 보장되는 블럭
				// 마무리 작업을 한다.(보통 열었던 스트림 객체를 닫는 작업을 한다.)
				try {
					// null 체크를 한 다음에 메소드를 호출해서 마무리 작업을 한다.
					if (fr != null)fr.close();
					if (br != null)br.close();
				} catch (IOException ie) {

				} // finally 안의 try~catch 종료

			} // try~catch~finally종료

		} // chooser if 종료

	}// openContent()메소드 종료

	// Output에 관련된 예제
	// textarea를 String타입으로 불러와서
	// 파일에 저장하는 작업을 하는 메소드
	public void saveContent() {
		// JTextArea에 입력한 문자열을 읽어온다.
		String content = area.getText();
		JFileChooser fc = new JFileChooser("c:/acorn2020/myFolder");
		int result = fc.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			// 새로 만들 예정인 File 객체의 참조값 얻어오기
			File file = fc.getSelectedFile(); // 파일객체의 참조값을 file이라는 지역변수에 전달해준다.

			// File saveFile = new File(file.toString());
			try {
				// 파일에 문자열을 출력 할 수 있는 객체 생성
				FileWriter fw = new FileWriter(file);
				fw.write(content);// 파일에다 문자열을 출력하는것
				fw.flush();
				fw.close();
				JOptionPane.showMessageDialog(this, file.getName() + " 파일을 저장했습니다.");
			} catch (IOException ie) {
				ie.printStackTrace();
			} // catch종료
		} // if 종료
	}// saveContent메소드종료

}// main class종료

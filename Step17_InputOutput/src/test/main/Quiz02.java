package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Quiz02 extends JFrame implements ActionListener {
	JPanel topPanel;
	JPanel centerPanel;
	JTextField tf_msg;
	JButton appendBtn;
	JButton loadBtn;
	String addText;
	File memoFile;
	JTextArea area;

	// 생성자
	public Quiz02() {
		setTitle("나의 프레임");
		setLayout(new BorderLayout());

		topPanel = new JPanel();
		centerPanel = new JPanel();
		Font font = new Font("맑은 고딕", Font.BOLD, 18);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 15);
		tf_msg = new JTextField(15);
		tf_msg.setFont(font);

		appendBtn = new JButton("추가하기");
		appendBtn.setActionCommand("append");
		appendBtn.setFont(font2);
		loadBtn = new JButton("불러오기");
		loadBtn.setActionCommand("load");
		loadBtn.setFont(font2);
		// 버튼 리스너 등록하기
		appendBtn.addActionListener(this);// 꼭해줘야한다.
		loadBtn.addActionListener(this);

		topPanel.add(tf_msg);
		topPanel.add(appendBtn);
		topPanel.add(loadBtn);

		add(topPanel, BorderLayout.NORTH);
		topPanel.setBackground(Color.PINK);

		// JTextArea
		area = new JTextArea(19, 33);
		area.setFont(font2);
		// 프레임 가운데에 JTextArea배치하기
		centerPanel.add(area);
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setBackground(Color.ORANGE);
	}

	public static void main(String[] args) {
		Quiz02 f = new Quiz02();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}// 메인 메소드 종료
		// 버튼을 누르면 호출되는 메소드

	@Override
	public void actionPerformed(ActionEvent event) {
		// 눌러진 버튼의 액션 command 읽어오기
		String command = event.getActionCommand();

		if (command.equals("append")) {// 추가 버튼을 눌렀을 때
			append();
			tf_msg.setText("");
		} else if (command.equals("load")) {// 불러오기 버튼을 눌렀을 때
			load();
		} // equals if

	}// action 종료

	// 추가 작업을 하는 메소드
	public void load() {
		//JTextArea를 한번 clear 하고
		area.setText("");
		// 1.파일에서 문자열을 읽어와서
		File memoFile = new File("c:/acorn2020/myFolder/memo.txt");
		FileReader fr = null;
		BufferedReader br = null;// 빈공간
		try {
			if (!memoFile.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				return;// 메소드 끝내기
			}
			// 파일에서 문자열을 읽어들일 객체의 참조값을 미리 만들어준 지역 변수에 담는다.
			fr = new FileReader(memoFile);
			br = new BufferedReader(fr);

			while (true) {
				// 반복문 돌면서 문자열을 줄단위로 (개행기호기준으로)읽어낸다.
				String line = br.readLine();
				if (line == null) {
					break;// 반복문 탈출
				} // if종료
				// 2. JTextArea에 출력하기
				area.append(line + "\r\n");
				
			} // while종료
			br.close();
		} catch (IOException e) {
			e.printStackTrace();

		} finally {// 예외가 발생하던 안하던 반드시 실행이 보장되는 블럭
			// 마무리 작업을 한다.(보통 열었던 스트림 객체를 닫는 작업을 한다.)
			try {
				// null 체크를 한 다음에 메소드를 호출해서 마무리 작업을 한다.
				if (fr != null)
					fr.close();
				if (br != null)
					br.close();
			} catch (IOException ie) {

			} // finally 안의 try~catch 종료

		} // try~catch종료
			
		//area.setText("");
	}

	public void append() {
		// 1.JTextField 에 입력한 문자열을 읽어와서
		String addText = tf_msg.getText();
		// 2.memo.txt 파일에 저장하기
		File memoFile = new File("c:/acorn2020/myFolder/memo.txt");
		try {
			boolean isExist = memoFile.exists();
			if (!isExist) {
				memoFile.createNewFile();
			} // isExist if종료
			FileWriter fw = new FileWriter(memoFile, true);
			fw.write(addText + "\r\n");
			fw.flush();
			fw.close();
			JOptionPane.showMessageDialog(this, "파일에 문자열을 저장했습니다.!");
		} catch (IOException e1) {
			e1.printStackTrace();
		} // catch종료
	}

}// main class종료

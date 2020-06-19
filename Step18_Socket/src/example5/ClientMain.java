package example5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * JSON
 * - Java SCript Object Notation (자바스크립트 객체 표기법을 따르는 문자열)
 * - 데이터의 type
 * 1. { }
 * 2. [ ]
 * 3. "xxx"
 * 4. 10 or 10.1
 * 5. true or false
 * 6. null
 *
 *- JSON 예제
 *{"num":1, "name":"김구라", "isMan":true, "phone":null}
 *{"key":value}
 *[10, 20, 30, 40, 50]
 *["김구라","해골","원숭이"]
 *[{},{},{}]
 *{"name":"kim","friends":["김구라","해골","원숭이"]}
 *
 * 메세지의 종류
 * 
 * 1.일반 대화 메세지 {"type":"msg","이름":"김구라", "content":"안녕하세요"}
 * 2. 누군가 입장 했다는 메세지 
 * {"type":"enter", "name":"김구라"}
 * 3. 누군가 퇴장 했다는메세지
 * {"type":"out", "name":"김구라"}
 * JSON - JavaScriptObjectNotation
 * 4. 참여자 목록 메세지
 * {"type":"members", "list":[ "해골","원숭이"]}
 */
public class ClientMain extends JFrame implements ActionListener, KeyListener {
	// 필드
	JTextField tf_msg;
	// 서버와 연결된 Socket객체의 참조값을 담을 필드
	Socket socket;
	// 다른 메소드에서 사용 가능하려면 필드에 저장해야한다.
	// 비어있으면 nullpointExc이 발생

	BufferedWriter bw;
	JTextArea area;
	// 대화명
	String chatName;
	// 참여자 목록
	JList<String> jList;

	// 생성자
	public ClientMain() {

		// 레이아웃을 BorderLayout으로 지정하기
		setLayout(new BorderLayout());
		setBackground(Color.LIGHT_GRAY);
		// 패널
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		// 입력창
		tf_msg = new JTextField(15);

		// 버튼
		JButton sendBtn = new JButton("전송");
		sendBtn.setActionCommand("send");
		sendBtn.addActionListener(this);
		// 패널에 입력창과 버튼 추가
		panel.add(tf_msg);
		panel.add(sendBtn);
		// 프레임의 아래쪽에 패널 배치하기
		add(panel, BorderLayout.SOUTH);
		// JTextarea
		area = new JTextArea();
		// 문자열을 출력 전용으로 사용하기 위해 편집이 불가능하도록 설정
		area.setEditable(false);
		// 배경색
		area.setBackground(Color.PINK);
		Font font = new Font("맑은 고딕", Font.BOLD, 13);
		area.setFont(font);
		// 스크롤 가능하도록\\ㅇ
		JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// 프레임의 가운데에 배치
		add(scroll, BorderLayout.CENTER);
		// 엔터키로 메세지 전송 가능하게 하기 위해
		tf_msg.addKeyListener(this);

		// Vector는 ArrayList와 같다고 생각하고 사용하면된다.
		// 추가기능(스레드동기화)가 있어서 조금 더 무겁다.
		
		//String[]에 JList공간 확보를 위해 임시 문자열을 넣는다.
		String[] title = {"참여자 목록"};
		jList = new JList<>(title);
		jList.setBackground(Color.GREEN);
		
		//패널에 JList를 배치하고
		JPanel rightPanel = new JPanel();
		rightPanel.add(jList, BorderLayout.CENTER);
		rightPanel.setBackground(Color.yellow);
		//패널을 프레임의 동쪽에 배치
		add(rightPanel, BorderLayout.EAST);
		
		// 대화명을 입력받아 필드에저장한다.
		chatName = JOptionPane.showInputDialog(this, "대화명을 입력하세요");
		setTitle("대화명: " + chatName);
		// 서버에 소켓 접속을 한다.
		try {
			// 접속이 성공 되면 Socket객체의 참조값이 반환된다.
			// 반환되는 객체의 참조값을 필드에 저장해둔다.
			socket = new Socket("192.168.0.9", 5000);
			System.out.println("Socket 연결 성공");
			// 문자열을 서버에 전송(출력Output)하기
			// 접속한 서버에 출력을 할 객체는 소켓에서 받아와야한다. 소켓 객체가 리턴해주는 geoutput메소드
			// OutputStream객체는 소켓으로부터 리턴 받아서 사용
			OutputStream os = socket.getOutputStream();// 출력
			OutputStreamWriter osw = new OutputStreamWriter(os);// 일회용으로 사용즁ㅇㅁ//쓰레기 객체가 계쏙 생성되는거임
			// 서버에 문자열을 출력할 BufferedWriter 객체의 참조값을 얻어내서 필드에 저장해 놓는다.
			bw = new BufferedWriter(osw);
			// 내가 입장한다고 서버에 메시지니르 보랴ㅔㅔ내다
			// "{"type":"enter","name":"대화명"}"
			// String msg = "{\"enter\":\""+chatName+"\"}";//수동

			// {} = jsonObject , [] = jsonArray

			// 서버로 부터 메세지를 받을 스레드도 시작을 시킨다.
			new ClientThread().start();// 다른 스레드로 동작하여 동작이 잡혀있지 않음
			// 내가 입장한다고 서버에 메세지를 보냄
			JSONObject jsonObj = new JSONObject();

			jsonObj.put("type", "enter");
			jsonObj.put("name", chatName);
			String msg = jsonObj.toString();

			// JSON문자열을 얻어낸다

			// 필드에 있는 BufferedWriter 객체의 참조값을 이용해서 서버에 문자열을 출력하기
			bw.write(msg);
			bw.newLine();// 개행기호도 출력(서버에서 줄단위로 읽어낼 예정)
			bw.flush();
		} catch (Exception e) {// 접속이 실패하면 예외가 발생한다.
			System.out.println("접속실패했습니다.");
			e.printStackTrace();
		}

	}// 생성자 종료

	// run은 메인메소드 실행
	public static void main(String[] args) {
		// 프레임 객체 생성
		ClientMain f = new ClientMain();
		f.setBounds(100, 100, 300, 500);// 위치 크기
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 닫기
		f.setVisible(true);// 화면에 보이기

	}// main 메소드

	@Override
	public void actionPerformed(ActionEvent e) {// 버튼을 누를때마다 접속
		sendMessage();
	}// action

	// 메세지를 전송하는 메소드
	public void sendMessage() {
		// 리턴에서 받아서 쓰는것
		// 전송할 문자열
		String msg = tf_msg.getText();// 버튼을 뉴를때마다 텍스트필드에 있는 내용을 읽어와서 서버에 전송//핵심객체
		try {
			// JSONObject 객체를 생성해서 정보를 구성하고
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "msg");
			jsonObj.put("name", chatName);
			jsonObj.put("content", msg);
			// JSON 문자열을 얻어낸다.
			String json = jsonObj.toString();

			// 필드에 있는 BufferedWriter 객체의 참조값을 이용해서 서버에 문자열 출력하기
			bw.write(json);
			bw.newLine();// 개행기호도 출력 (서버에서 줄단위로 읽어낼 예정)
			bw.flush();

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		tf_msg.setText("");
	}// sendMessage

	// 서버에서 불특정 시점에 도착하는 메세지를 받을 스레드
	public class ClientThread extends Thread {
		// 내부 클래스 안에서 내부클래스를 싸고 있는 밖의 클래스의 메소드나 필드를 내것처럼 쓸수 있음
		@Override
		public void run() {
			try {

				// 서버로 부터 입력 받을 수 있는 객체의 참조값 얻어오기
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				while (true) {
					// 서버로 부터 문자열이 전송되는지 대기한다.
					String msg = br.readLine();
					// 메소드를 호출하면서 문자열 전달
					updateTextArea(msg);
					// 최근 추가된 글 내용이 보일 수 있도록
					int docLength = area.getDocument().getLength();// 스크롤 하면서 밑으로
					area.setCaretPosition(docLength);
					if (msg == null) {
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} // catch
		}// run

		public void updateTextArea(String msg) {
			try {
				// 서버로 부터 문자열이 전송되는지 대기한다.
				JSONObject jsonObj = new JSONObject(msg);
				String type = jsonObj.getString("type");
				if (type.equals("enter")) {// 입장메세지라면
					// 누가 입장했는지 읽어낸다.
					String name = jsonObj.getString("name");
					area.append("[" + name + "]님이 입장했습니다.");
					area.append("\r\n");
				} else if (type.equals("msg")) {// 대화메세지라면
					// 누가
					String name = jsonObj.getString("name");
					// 어떤 내용을
					String content = jsonObj.getString("content");
					// 출력하기
					area.append(name + " : " + content);
					area.append("\r\n");
				} else if (type.equals("out")) {
					// 누가
					String name = jsonObj.getString("name");
					// 출력하기
					area.append("[[ " + name + " }} 님이 퇴장했습니다.");
					area.append("\r\n");
				} else if (type.equals("members")) {// 대화 참여자 목록이 도착
					// list라는 키값으로 저장된 JSONArray 객체를 얻어온다.
					JSONArray arr = jsonObj.getJSONArray("list");
					//참여자 목록을 저장할 Vector
					Vector<String> list = new Vector<String>();
					list.add("참여자 목록");
					// 반복문 돌면서 참여자 목록을 넣어준다.
					for (int i = 0; i < arr.length(); i++) {
						String tmp = arr.getString(i);
						list.add(tmp);
					}//for
					//JList에 참여자 목록 연결하기
					jList.setListData(list);
				}//else if
			} catch (JSONException je) {
				je.printStackTrace();
			} // catch
		}// updateTextArea

	}// class ClientThread 종료

	@Override
	public void keyPressed(KeyEvent e) {
		// 눌러진 키의 코드값
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ENTER) {// 만일 엔터키를 눌렀다면
			sendMessage();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * 자바스크립트는 싱글스레드 자바는 멀티 스레드. 멀티스레드라서 여러개의 작업을 동시에 하려면 스레드가 여러개 필요
	 * 
	 */

}// main클래스

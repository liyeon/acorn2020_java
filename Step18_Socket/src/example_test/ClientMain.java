package example_test;

import java.awt.BorderLayout;
import java.awt.Color;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONObject;

public class ClientMain extends JFrame implements ActionListener, KeyListener{
	JTextField tf_msg;
	Socket socket;
	
	BufferedWriter bw;
	JTextArea area;
	String chatName;
	//생성자
	public ClientMain() {
		chatName = JOptionPane.showInputDialog(this, "대화명을 입력하세요");
		setTitle("대화명: "+chatName);
		try {
			socket = new Socket("192.168.0.9", 5000);
			System.out.println("Socket 연결 성공");
			OutputStream os=socket.getOutputStream();//출력
			OutputStreamWriter osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			
			new ClientThread().start();
			JSONObject jsonObj = new JSONObject();
			
			jsonObj.put("type", "enter");
			jsonObj.put("name", chatName);
			String msg=jsonObj.toString();
			
			bw.write(msg);
			bw.newLine();//개행기호도 출력(서버에서 줄단위로 읽어낼 예정)
			bw.flush();
			
		}catch(Exception e) {//접속이 실패하면 예외가 발생한다.
			System.out.println("접속실패했습니다.");
			e.printStackTrace();
		}
		
		
		setLayout(new BorderLayout());
		setBackground(Color.LIGHT_GRAY);
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		tf_msg = new JTextField(15);
		
		
		
		JButton sendBtn = new JButton("전송");
		sendBtn.setActionCommand("send");
		sendBtn.addActionListener(this);
		panel.add(tf_msg);
		panel.add(sendBtn);
		add(panel, BorderLayout.SOUTH);
		area = new JTextArea();
		area.setEditable(false);
		area.setBackground(Color.PINK);
		Font font = new Font("맑은 고딕", Font.BOLD, 13);
		area.setFont(font);
		JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
				);
		add(scroll, BorderLayout.CENTER);
		tf_msg.addKeyListener(this);
	}
	
	public static void main(String[] args) {
		ClientMain f = new ClientMain();
		f.setBounds(100,100,300,500);//위치 크기
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//닫기
		f.setVisible(true);//화면에 보이기
		

	}//main 메소드
	@Override
	public void actionPerformed(ActionEvent e) {//버튼을 누를때마다 접속
		sendMessage();
	}//action
	
	public void sendMessage() {
		String msg =tf_msg.getText();//버튼을 뉴를때마다 텍스트필드에 있는 내용을 읽어와서 서버에 전송//핵심객체
		try {
	         JSONObject jsonObj=new JSONObject();
	         jsonObj.put("type", "msg");
	         jsonObj.put("name", chatName);
	         jsonObj.put("content", msg);
	         String json=jsonObj.toString();
	         
	         bw.write(json);
	         bw.newLine();//개행기호도 출력 (서버에서 줄단위로 읽어낼 예정)
	         bw.flush();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		} 
		tf_msg.setText("");
	}//sendMessage
	
	
	
	public class ClientThread extends Thread{
		@Override
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				while(true) {
					String msg = br.readLine();
					JSONObject jsonObj = new JSONObject(msg);
					String type = jsonObj.getString("type");
					if(type.equals("enter")) {//입장메세지라면
						String name = jsonObj.getString("name");
						area.append("["+name+"]님이 입장했습니다.");
						area.append("\r\n");
					}else if(type.equals("msg")) {//대화메세지라면
						//누가
						String name = jsonObj.getString("name");
						//어떤 내용을
						String content = jsonObj.getString("content");
						//출력하기
						area.append(name+" : "+content);
						area.append("\r\n");
					}
					int docLength = area.getDocument().getLength();//스크롤 하면서 밑으로
					area.setCaretPosition(docLength);
					if(msg==null) {
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}//catch
		}//run
			
	}//ClientThread 종료
	@Override
	public void keyPressed(KeyEvent e) {
		//눌러진 키의 코드값
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {//만일 엔터키를 눌렀다면
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
	

}//main클래스

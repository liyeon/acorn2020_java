package example4;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/*
 통신에 관련된 동작만
 */
public class ServerMain {
	//필드
	static List<ServerThread> threadList = new ArrayList<>();
	//z클라이언트를 응대하는 thireadlist
	
	
	
	public static void main(String[] args) {
		// 필요한 객체를 저장할 지역변수 미리 만들기
		ServerSocket serverSocket = null;
		try {
			//5000번 통신 port를 열고 클라이언트 접속을 기다린다.(서버생성)
			serverSocket = new ServerSocket(5000);
			
			while(true) {//클라이언트가 접속 해 올 때마다 새로운 소켓객채의 참조값이 나온다.
				System.out.println("클라이언트의 Socket 연결 요청을 대기합니다.");
				Socket socket = serverSocket.accept();//받아들인다. //누가 접속 해 올때마다 받음 1번//접속한 클라이언트와 1대1로연결되어있는 것
				System.out.println("클라이언트가 접속을 했습니다.");
				//방금 접속한 클라이언트를 응대할 스레드르 시작시킨다.
				ServerThread thread = new ServerThread(socket);
				thread.start();
				//생성하고 시작한 스레드의 참조값을 List에 저장하기
				threadList.add(thread);//ServerMain.threadlist
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null)
					serverSocket.close();
			} catch (Exception e) {
			}//finally 안 catch종료
		} // finally종료

	}// main 메소드 종료
	
	//내부 클래스로 스레드 객체를 생성할 클래스를 정의한다.
	//static main()메소드에서 클래스를 사용하기 위해 static예약어를 붙여서 정의한다.
	public static class ServerThread extends Thread{//run 오버라읻
		//스레드 시작하려면 객체 new 한 다음에 .start()
		
		//필드
		Socket socket;
		//클라이언트에게 출력 할 수 있는 문자열이 있는 객체
		BufferedWriter bw;
		
		//생성자의 인자로 Socket 객체를 전달 받도록 한다.
		public ServerThread(Socket socket) {
			//생성자의 인자로 전달 받은 Socket객체의 참조값을 필드에 저장한다.
			this.socket=socket;
		}

		//인자로 전달된 문자열을 Socket을 통해서 출력하는 메소드  // 서버에만이 아닌 접속한 각각의 컴퓨터에 다 전달이 된다.
		public void sendMessage(String msg) throws IOException {
			//반복문 돌면서 모든 스레드의 BufferedWriter객체를 이용해서
			//문자열을 전송한다.
			for(ServerThread tmp:threadList) {
				tmp.bw.write(msg);//문자열 출력
				tmp.bw.newLine();//개행기호 출력
				tmp.bw.flush();//방출
				
			}
		}
		
		//새로운 작업단위가 시작되는 run()메소드
		@Override
		public void run() {//스레드가 시작됨
			try {
				String clientIp = socket.getInetAddress().getHostAddress();//2번
				//.getInetAddress().getHostAddress() 접속한 클라이언트의 아이피 주소를 읽어냄
				//강의실 안에서만 사용되는 가상의 아이피
				System.out.println("접속한 클라이언트의 아이피 : " + clientIp );
				//클라이언트로부터 읽어들일(Input)객체의 참조값 얻어오기
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				//클라이언트에게 출력 할 수 있는 객체
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				//BufferedWriter 객체의 참조값을 필드에 저장하기
				bw = new BufferedWriter(osw);
				
				
				while(true) {
					/*
					 * 클라이언트가 문자열을 한줄(개행기호와 함께) 보내면
					 * readLine() 메소드가 리턴하면서 보낸 문자열을 가지고 온다.
					 * 보내지 않으면 계속 블로킹 되어 대기하고 있다가 접속이 끊기면 Exception이 발생하거나 혹은 null이 리턴된다
					 * 따라서 null이 리턴되면 반복문을 빠져나가게 break문을 만나도록 한다.
					 * 실행순서가 try블럭을 벗어나면 run()메소드가 리턴하게 되고
					 * run()메소드가 리턴되면 해당 스레드는 종료가 된다.
					 */
					String msg = br.readLine();//메세지가 입력될때까지 블로킹(대기)한다.
					System.out.println("메세지 : "+msg);
					//클라이언트에게 동일한 메세지를 보내는 메소드를 호출한다.
					sendMessage(msg);
					if(msg==null) {
						break;
					}
				}
				
			} catch (Exception e) {
				
			}finally {
				//접속이 끊겨ㅕ서 종료되는 스레드는 list에서 제거한다.
				threadList.remove(this);//참조값으로 찾아서 삭제하는 기능//참조값 안에 있는 방을 찾아서 삭제해줘랑
				//this는 ServerThread로 생성된 객체
					try {
						if(socket!=null)socket.close();
					} catch (IOException e) {}
			}//finally
			
		}//run
	}//serverThread
	
}// mainClass종료

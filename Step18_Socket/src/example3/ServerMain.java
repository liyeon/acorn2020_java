package example3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * 소켓 통신? 네트워크끼리 어떤 데이터를 주고 받을 수 있따.
 * 네트워크 끼리 통신하는 방법
 * ServerSocket serverSocket = null;
 * Socket socket = null;
 */

public class ServerMain {
	public static void main(String[] args) {
		// 필요한 객체를 저장할 지역변수 미리 만들기
		ServerSocket serverSocket = null;
		try {
			//5000번 통신 port를 열고 클라이언트 접속을 기다린다.(서버생성)
			serverSocket = new ServerSocket(5000);
			/*
			 * accept()메소드는 클라이언트가 실제 접속을 할 때 까지 리턴하지 않고
			 * 블록킹 되는 메소드이다.
			 * 클라이언트가 접속을 해오면 Socket객체의 참조값을 반환하면서 리턴된다.
			 * 
			 *  serverSocket.accept(); 호출만 하고 리턴하지 않음.
			 *  socket객체를 통해서 접속을 한 누군가와 input output이 가능하다.
			 *  
			 *  serversocket은클라이언트의 접속을 기다리는 객체(연결요청)
			 *  접속을 하고 나면 클라이언트와 연결된 소켓객체에 전달한다.
			 */
			while(true) {//클라이언트가 접속 해 올 때마다 새로운 소켓객채의 참조값이 나온다.
				System.out.println("클라이언트의 Socket 연결 요청을 대기합니다.");
				Socket socket = serverSocket.accept();//받아들인다. //누가 접속 해 올때마다 받음
				System.out.println("클라이언트가 접속을 했습니다.");
				String clientIp = socket.getInetAddress().getHostAddress();
				//.getInetAddress().getHostAddress() 접속한 클라이언트의 아이피 주소를 읽어냄
				//강의실 안에서만 사용되는 가상의 아이피
				System.out.println("접속한 클라이언트의 아이피 : " + clientIp );
				//클라이언트로부터 읽어들일(Input)객체의 참조값 얻어오기
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				//클라이언트가 전송한 문자열 한 줄 읽어들이기
				String msg = br.readLine();
				System.out.println("메세지 : "+msg);
				socket.close();//계속 통신할거면 안 닫아도됨
				/*
				 * inputStreamReader
				 * BufferedReader
				 * 접속한 클라이언트의 숫자 만큼 스레드(thread)가 돌아야한다.
				 */
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
}// mainClass종료

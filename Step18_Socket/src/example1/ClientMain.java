package example1;

import java.net.Socket;

public class ClientMain {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			// ip주소 prot번호
			socket = new Socket("192.168.0.30", 5000);
			System.out.println("Socket 연결 성공");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close();
			} catch (Exception e) {}
		}//finally 종료
		System.out.println("main메소드가 종료됩니다.");
	}//main 메소드
}//main클래스

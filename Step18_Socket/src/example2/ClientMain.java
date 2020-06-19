package example2;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
	public static void main(String[] args) {
		//서버에 전송할 문자열을 입력받아서
		Scanner scan=new Scanner(System.in);
		System.out.println("서버에 전송할 문자열 입력");
		String msg=scan.nextLine();
		
		
		Socket socket = null;
		try {
			// ip주소 prot번호
			socket = new Socket("192.168.0.30", 5000);
			System.out.println("Socket 연결 성공");
			//문자열을 서버에 전송(출력Output)하기
			OutputStream os=socket.getOutputStream();//출력
			OutputStreamWriter osw = new OutputStreamWriter(os);
			osw.write(msg);
			osw.write("\r\n");//개행기호도 출력(서버에서 줄단위로 읽어낼 예정)
			osw.flush();
			osw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)socket.close();
			} catch (Exception e) {}
		}//finally 종료
		System.out.println("main메소드가 종료됩니다.");
	}//main 메소드
}//main클래스

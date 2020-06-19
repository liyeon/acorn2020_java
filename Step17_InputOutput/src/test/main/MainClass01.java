package test.main;

import java.io.IOException;
import java.io.InputStream;

public class MainClass01 {

	public static void main(String[] args) {
		//키보드와 연결괸 InputStream type의 참조값을 kbd라는 지역변수에 담기
		//InputStream 객체는 ibyte 단위처리의 스트림이다.
		//영문자 대소문자, 숫자, 특수문자만 처리 할 수 있다.
		//한글 처리 불가
		InputStream kdb=System.in; // 키보드로 부터 읽어 들일 때 사용 System.in;
		System.out.print("입력: ");
		try {
			//입력한 키의 코드값 읽어오기
			int code = kdb.read();
			System.out.println("code : "+code);
			//코드값에 대응되는 문자 얻어내기
			char ch=(char)code;
			System.out.println("char : " + ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package test.main;

import java.io.File;

public class MainClass07 {
	public static void main(String[] args) {
		//파일 객체의 기능을 통해서 목록을 얻어 낼 수 있다.
		File myFile = new File("c:/");//c드라이브에 access를 할 수 있는 파일 객체
		String[] names= myFile.list();
		//목록 문자열을 콘솔에 출력하기
		for(String tmp:names) {
			System.out.println(tmp);
		}
		
	}
}

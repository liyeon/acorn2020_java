package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass03 {

	public static void main(String[] args) {
		//1byte처리 스트림
		InputStream is = System.in;
		//2byte처리 스트림
		InputStreamReader isr = new InputStreamReader(is);
		//한번에 여러 글자를 읽어들여서 String type으로 리턴해주는 기능을 가지고 있는 객체
		BufferedReader br = new BufferedReader(isr);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//new Scanner(System.in)와 BufferedReader은 동일하지만 스캐너가 더 편함
		try {
			System.out.print("입력 : ");
			//입력한 문자열 한줄을 얻어내기
			String line = br.readLine();
			//출력하기
			System.out.println("line : "+line);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

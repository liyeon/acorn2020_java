package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MainClass04 {
	public static void main(String[] args) {
		//콘솔창에 출력 할 수 있는 PrintStream 객체의 참조값
		PrintStream ps = System.out;
		//학습을 위해서 PrintStream 객체를 부모 type OutputStream으로 받아보기
		OutputStream os = ps;
		//OutputStream도 1byte처리 스트림이다.
		try {
			os.write(97);//출력하기
			os.write(98);
			os.write(99);
			os.write(100);
			os.flush();//출력된 내용을 방출하기
			//outputstream은 콘솔하고도 연결된 객체기 때문에 콘솔창에 나옴
			//file하고 연ㄹ
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//		OutputStreamWriter ;
//		BufferedWriter;
		
		
	}
}

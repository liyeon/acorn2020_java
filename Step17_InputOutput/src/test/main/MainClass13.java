package test.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass13 {
	public static void main(String[] args) {
		File memoFile = new File("c:/acorn2020/myFolder/memo.txt");
		try {
			if(!memoFile.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				return;//메소드 끝내기
			}
			//파일에서 문자열을 읽어들일 객체
			FileReader fr = new FileReader(memoFile);//반복문을 돌다가 읽을게 없으면 빠져나오게 한다.
			while(true) {
				//글자 하나하나의 코드값을 반복문 돌면서 읽어들인다.
				int code = fr.read();//정수값을 반환(return)함.더이상 읽을게 없으면 -1을 리턴하는 경우가 많다. 참조값을 반환하는건 null
				if(code==-1) {//더이상 읽을 코드가 없으면
					break;//반복문 탈출
				}
				//코드값에 해당되는 문자
				char ch=(char)code;
				//콘솔차에 개행기호 없이 한글자한글자출력하기
				System.out.print(ch);
			}
			//fr.read();//한줄씩 못 읽음..알파벳 하나하나 읽어냄
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MainClass14 {
	public static void main(String[] args) {
		File memoFile = new File("c:/acorn2020/myFolder/memo.txt");
		try {
			if(!memoFile.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				return;//메소드 끝내기
			}
			//파일에서 문자열을 읽어들일 객체
			FileReader fr = new FileReader(memoFile);
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				//반복문 돌면서 문자열을 줄단위로 (개행기호기준으로)읽어낸다.
				String line = br.readLine();
				if(line == null) {
					break;//반복문 탈출
				}//if종료
				//읽은 문자열 출력
				System.out.println(line);
			}//while종료
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			
		}//try~catch종료
		
	}//메인 메소드 종료

}//main class종료

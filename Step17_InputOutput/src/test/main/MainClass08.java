package test.main;

import java.io.File;

public class MainClass08 {
	public static void main(String[] args) {
		File myFile = new File("c:/");
		// 파일 객체 목록(File[])를 얻어내기
		File[] files = myFile.listFiles(); // File배열을 리턴 //각각의 폴더 혹은 파일 하나하나에 대한 작업을 할 수 있는 파일 객체를 생성하여 배열에 담아서 리턴ㅈ
		// 반복문 돌면서 하나씩 참조해서 작업해보기
		for (File tmp : files) {
			//tmp.delete();
			tmp.getName();// 폴더 혹은 파일의 이름 //디렉토리인지도 알 수 있음
			if (tmp.isDirectory()) {//만일 해당 객체가 디렉토리이면
				System.out.println("[" + tmp.getName() + "]");
			} else {//파일이면
				System.out.println(tmp.getName());
			}
		}
	}
}

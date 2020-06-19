package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass12 {
	public static void main(String[] args) {
		// 문자열을 저장할 파일을 만들기 위한 File 객체
		File memoFile = new File("c:/acorn2020/myFolder/memo.txt");
		// 실제로 파일이 존재하는지 여부
		try {
			boolean isExist = memoFile.exists();
			if (!isExist) {// 존재하지않으면 //isExist==false와 같음
				//파일을 실제로 만듬
				memoFile.createNewFile();

			}//if종료
			//파일에 문자열을 출력할 객체
			FileWriter fw = new FileWriter(memoFile);
			fw.write("하나");
			fw.write("\r\n");//개행기호(enter)
			fw.write("두울");
			fw.write("\r\n");//개행기호(enter)
			fw.write("세엣");//바이트알갱이로변환돼서파일에저장됨
			fw.flush();
			fw.close();//.close()시점에 파일이 만들어진다.
			System.out.println("파일에 문자열을 저장했습니다.!");
		} catch (IOException e) {
			e.printStackTrace();
		}//catch종료
	}
}

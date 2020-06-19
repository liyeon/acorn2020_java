package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		/*
		 * Scanner객체를 이용해서 문자열 한줄을 입력받은 다음 c:/acorn2020/myFolder/quiz.txt 파일을 만들어서 해당
		 * 파일에 문자열을 저장해보세요
		 */
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("저장할 문자열 입력(종료 : q) : ");
			String str = scan.nextLine();
			if(str.equals("q")) {
				System.out.println("문자열이 종료됩니다.");
				break;
			}
			File file1 = new File("c:/acorn2020/myFolder/quiz.txt");
			try {
				boolean isExist = file1.exists();
				if (!isExist) {
					file1.createNewFile();
				} // if종료
				FileWriter fw = new FileWriter(file1, true);//append를 기존에 있던걸 덮어쓰지 않으려면 true입력
				//fw.write(str);
				fw.append(str+"\r\n");
				//fw.flush();
				fw.close();//close하는 시점에 자동으로 flush가 된다.
				System.out.println("문자열을 저장했습니다.");
			} catch (IOException ie) {
				ie.printStackTrace();
			} // catch 종료
		}//while
		
	}// void main 종료
}// main Class종료

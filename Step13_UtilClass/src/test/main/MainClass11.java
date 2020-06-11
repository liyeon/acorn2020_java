package test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass11 {
	public static void main(String[] args) {
		Map<String, String> dic = new HashMap<>();
		//Map은 사전 형태로 데이터를 관리한다고 보면 된다.
		dic.put("house", "집");
		dic.put("phone", "핸드폰");
		dic.put("car", "자동차");
		dic.put("pencil", "연필");
		dic.put("eraser", "지우개");
		/*
		 * 검색할 단어를 입력하세요: house
		 * 
		 * house의 뜻은 집입니다.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 단어를 입력해주세요  :  "); 
		String inputWord = scan.nextLine();//문자열 입력받기
		//Map 객체에서 입력한 문자열로 저장된 값 읽어와보기
		String mean = dic.get(inputWord);
		//출력할 문자열 구성하기
		System.out.println("==============");
		
		if(mean==null) {//존재하지 않으면
			System.out.println(inputWord + "에 해당 되는 단어가 없습니다.");
		}else {
			//출력할 문자열 구성하기
			String line = inputWord+"의 뜻은 " +mean+"입니다.";
			//출력하기
			System.out.println(line);
		}
				
	}
}

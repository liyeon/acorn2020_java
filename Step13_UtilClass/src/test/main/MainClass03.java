package test.main;

import java.util.ArrayList;
import java.util.List;

public class MainClass03 {
	public static void main(String[] args) {
		//String type을 저장할 ArrayList 객체를 생성하고 참조값을 List 인터페이스 type 지역변수 msgs에 담기
		List<String> msgs = new ArrayList<>();
		//ArrayList객체는 리스트타입이기도하다
		msgs.add("김구라");
		msgs.add("해골");
		msgs.add("원숭이");
		msgs.add("주뎅이");
		msgs.add("덩어리");
		//List객체에 담긴 문자열을 for 문을 이용해서 순서대로 콘솔창에 출력해보세요
		for(int i=0; i<msgs.size();i++) {
			//i번째 방에 있는 item 참조
			String tmp = msgs.get(i);
			System.out.println(tmp);
		}
		System.out.println("===========확장 for 문 forEach======");
		for(String tmp:msgs) {
			System.out.println(tmp);
		}
	}
}

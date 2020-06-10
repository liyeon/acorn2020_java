package test.main;

import java.util.ArrayList;

public class MainClass01 {
	public static void main(String[] args) {
		//가변 배열
		//String type을 저장 할 수 있는 index로 관리되는 목록(List) 객체
		ArrayList<String> names = new ArrayList<String>();//<> 안에는 담을 타입
		//String type의 참조값 지정하기
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		//배열의 방의 크기 얻어오기
		names.size();//방의 크기를 나타냄
		//각각의 방에 저장된 값 불러오기
		String name1 = names.get(0);//0번방
		String name2 = names.get(1);//1번방
		String name3 = names.get(2);//2번방
		//특정 방의 값 수정( 덮어쓰기)
		names.set(0, "김하");//0번방 수정
		//특정 index(방)의 값 삭제
		//names.remove(1);//1번방 삭제
		//모든 방 깨끗이 삭제
		//names.clear();;
		names.contains(name3);//포함되어있는지?
		System.out.println(names.contains(name2));
		System.out.println(names);
		for(int i=0;i<names.size();i++ ) {
			System.out.println(names.get(i) + "이름입니다.");
		}
	}
}

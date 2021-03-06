package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Info;

public class MainClass05 {

	public static void main(String[] args) {
		//Info 클래스로 객체를 생성해서 참ㅈ값을 i1이라는 지역 변수에 담기
		Info i1=new Info();
		//필드는 public으로 선언되어 있기 때문에 직접 접근해서 대입 연산자로 값을 대입 할 수 있다.
		i1.num = 1;
		i1.name = "김구라";
		i1.addr = "노량진";
		//자바스크립트에서의 object모양과 비슷하다 {num:1,name:"kim",addr:"nrg"} 파이썬에서는 딕트타입이라 한다. 딕셔너리.타입..
//		리플리티클래스?
		Info i2=new Info();
		i2.num = 2;
		i2.name = "해골";
		i2.addr = "행신동";
		//위의 Info type객체의 참조값을 List객체에 순서대로 담아보세요.
		List<Info> list= new ArrayList<>();//Info type이 들어가는 list배열
		list.add(i1);
		list.add(i2);
		
		/*
		 * 반복문 for를 이용해서 List 객체에 담긴 정보를 아래와 같은 형식으로 출력해보세요
		 * 1 | 김구라 | 노량진
		 * 2 | 해골 | 행신동
		 */
		for(int i=0;i<list.size(); i++) {
			Info l = list.get(i);
			System.out.println(l.num + "|" + l.name + "|"+ l.addr);
		}
		System.out.println("=====for문 확장=====");
		for(Info tmp:list) {
			//출력할 문자열 구성하기
			String line = tmp.num+ "|" +tmp.name+ "|" +tmp.addr;
			System.out.println(line);
		}
	
	}

}

package test.main;

import test.human.Blood;
import test.human.Men;

public class MainClass13 {

	public static void main(String[] args) {
		/*
		 * 프로그래밍의 목적 : 아래의 useMen() 메소드를 호출하는 것
		 * 아래의 useMen() 메소드를 호출해보세요
		 */
		//Men객체를 생성해서 참조값을 m1이라는 지역 변수에 담기
		Men m1 = new Men(new Blood("+","A"));//객체는 네개!String객체까지
		//useMen() 메소드를 호출하면서 Men 객체의 참조값전달하기
		MainClass13.useMen(m1);
		
	}
	public static void useMen(Men m) {//static메소드
		m.walk();
		m.study();
		m.seeMovie();
	}

}

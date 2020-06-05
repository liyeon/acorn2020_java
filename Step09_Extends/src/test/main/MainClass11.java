package test.main;

import test.human.Blood;
import test.human.Men;

public class MainClass11 {

	public static void main(String[] args) {
		/*
		 * 프로그래밍의 목적: 영화를 보고 싶다.
		 * 영화를 본 프로그래밍의 목적을 달성해보세요
		 */
		
		/*
		 * Men 객체를 생성해보자
		 * 객체생성은 new예약어와 함께 class명()
		 * Class명()는 해당 클래스의 생성자를 호출
		 * 생성자의 모습이 같아야 호출할수있다.
		 * MenClass의 생성자를 살펴보니
		 * public Men(Blood blood){} 이렇게 생김
		 * 생성자의 인자로 Blood type의 참조값을 전달해야한다!
		 */
		Blood b = new Blood("+", "a");
		Men men = new Men(b);
		men.seeMovie();
		men.study();
		men.walk();
		new Men(new Blood("-", "b")).seeMovie();// 일회용으로 사용한것
		
	}

}

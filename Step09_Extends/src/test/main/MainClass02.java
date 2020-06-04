package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass02 {
	public static void main(String[] args) {
		// SmartPhone 객체를 생성해서 SmartPhone type의 지역변수 p1에 담기
		SmartPhone p1 = new SmartPhone();
		p1.doInternet();
		p1.call();
		p1.mobileCall();
		// p1에 담긴 참조값을 HandPhone type 지역변수 p2에 담기
		HandPhone p2 = p1;
		// p1에 담긴 참조값을 Phone type 지역변수 p3에 담기
		Phone p3 = p1;
		// p1에 담긴 참조값을 Object type 지역변수 p4에 담기
		Object p4 = p1;
		// 지역변수가 4개 만들어져있고 객체는 한개이다. 56번 사물함 키가 4군데 지역 변수에 나눠서 들어가 있다.
		//어떤 클래스 타입으로 받느냐에 따라 사용 할 수 있는 기능이 달라진다.
		
		SmartPhone p5 = (SmartPhone)p4;
		p5.doInternet();
	}
}
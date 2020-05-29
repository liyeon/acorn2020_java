package test.main;

import test.mypac.Car;

public class MainClass01 {
	// run했을 때 실행 순서가 시작되는 특별한 main() 메소드
	public static void main(String[] args) {
		// Car 클래스를 이용해서 객체를 생성하고 참조값을 지역변수에 담기
		Car car1 = new Car(); // 객체를 생성(찍어낼떄) 할 때는 new라는 예약어와 함께 생성한다. 사물함번호인 참조값이 들어온다.(20..?);
		// 클래스가 다른 곳에 있을 때는 import를 한다. import test.mypac.Car; ctrl+space 하면 자동 완성된다.
		// Car 클래스로 객체를 만들었기 때문에 타입은 Car가 된다.
		// Car 객체의 메소드 호출하기
		car1.drive();
		// Car 객체의 필드에 값 대입하기.
		car1.name = "볼보!";
		// java에서 다루는 어떤 타입이던지 선언하는데로 가질 수 있다고 한다..
		// 1. Car 클래스를 이용해서 객체를 생성하고 참조값을 car2라는 이름의 지역변수에 담아보기!
		Car car2 = new Car();
		// 2.메소드를 호출해보세요!
		car2.drive();
		// 3. name이라는 필드에 차 이름을 담아보세요.
		// name에는 string타입만 담을 수 있다.
		car2.name = "지프!";

		/*
		 * 클래스명이 같아도 패키지 명이 다르면 아예 다른 클래스이다. 패키지명에는 주로 회사 주소가 들어간다고 한다.
		 */
		
	}
}

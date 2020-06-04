package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass01 {
	public static void main(String[] args) {
		//Phone 클래스로 객체를 생성해서 참조값을 지역변수에 담기
		Phone p1 = new Phone(); //phone객체는 object type이기도 한다. 하나의 객체를 여러개의 타입으로 받을 수 있다. 다형성 (polymorphism)
		Object p2 = new Phone();//상속 관계 때문에 Object type을 가질 수 있다.
		//클래스를 정의 하면 자동적으로 Object클래스를 상속 받는다.
		//오브젝트 클래스에 정의된 메소드을 쓸 수 있다.
		p1.call();
		
		//객체를 어떤 타입으로 받느냐에 따라 사용할수있는 메소드가 다르다.
		
		//HandPhone 클래스로 객체 생성해서 참조값을 지역 변수에 담기
		
		//하나의 객체의 참조값을 다양한 타입으로 받을 수 있다. 어떤 객체는 타입이 여러가지 일 수 있다.
		HandPhone p3 = new HandPhone();//object, phone, handphone 클래스 다 사용 가능.
		p3.call();//phone클래스에 정의된 메소드
		p3.mobileCall();// handphone클래스에 정의 된 메소드
		//상속을 받으면 부모클래스에 정의된 메소드를 자식 클래스에서 사용 할 수 있다.
		//기존에 만들어 놓은 기능들을 확장을 해서 사용한다.
		Phone p4 = new HandPhone();//object 클래스, phone클래스 안에있는 메소드만 사용 가능
		Object p5 = new HandPhone();//object 클래스 안에있는 메소드만 사용 가능
		//poly type(다형성)
		/*
		 * 어떤 객체를 부모타입으로 받으면 프로그래밍이 유연해진다고 한다..왤까..와이낫
		 * 
		 * 
		 * 
		 */
		p4.call();
		p3.mobileCall();
		//이미 만들어진 객체의 참조값을 다른 type으로 받아보기
		Phone p6 = p3;//new 한 값을 가져오는게 아닌 기존에 new한걸 가져오는거라?
		//객체자체는 모든 기능을 가지고 있지만 phone타입, Object의 기능만 사용 가능
		//클래스는 참조값에 대한 사용 설명서 역할을 한다. 자식의 설명서는 부모 설명서에 다 포함이 되어 있다. 부모타입으로 설명서 지정 시 자식 타입으로 정의된 기능은 쓸 수 없다.
		//기능을 다 쓰려면 설명서만 교체하면된다. 단지 객체의 기능은 가지고 있지만 부모타입으로 되어있어서ㅓㄱㅎㅇ너ㅏ힝나ㅣㅓ   ㄴ이ㅏ
		Object p7=p3;
		//String str = p3; //오류난당
		//Object가 가장 넓은 범위이다.
		//Casting 확신을 주는 것. 상위개념에 있는걸 하위 개념으로 옮길때ㅡㅡ
		HandPhone p9 = (HandPhone)p6;
		HandPhone p8 = (HandPhone)p5;
		p8.mobileCall();
		
		
	}//main메소드 종료
}//Class 종료


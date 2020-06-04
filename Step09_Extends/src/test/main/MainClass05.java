package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass05 {

	public static void main(String[] args) {
		//SmartPhone객체를 생성해서 Phone type p1이라는 지역 변수에 담기.
		Phone p1 = new SmartPhone(); //자식 클래스 객체를 부모 클래스에 담는건 성립ㅇ
		//p1에 들어있는 참조값을 이용해서 전화를 걸고 싶다면
		p1.call();//SmartPhone 객체임에도 Phone type의 클래스에 있는 기능만 사용 가능하다.
		//p1에 들어있는 참조값을 이용해서 이동 중에 전화를 걸고 싶다면
		//p1에 들어있는 참조값을 HandPhone type 지역변수에 Casting 해서 담는다.
		HandPhone p2=(HandPhone)p1;
 		p2.mobileCall();
 		
		//p1에 들어있는 참조값을 이용해서 인터넷을 하고 싶다
 		SmartPhone p3 = (SmartPhone)p1;
 		p3.doInternet();
		//객체는 한개임.
		
		p2.takePicture();
		
		
		
		
	}
}

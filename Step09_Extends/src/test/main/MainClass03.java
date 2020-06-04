package test.main;

import test.mypac.HandPhone;
import test.mypac.SmartPhone;

public class MainClass03 {

	public static void main(String[] args) {
		//HandPhone 객체를 생성해서 HandPhone type의 지역변수 p1에 담기
		HandPhone p1 = new HandPhone();
		//인터넷을 해야한다. 즉 SmartPhone type 객체가 필요하다.
		//p1안에 있는 값을 이용해서 인터넷을 할 수 있냐
		//SmartPhone p2 = (SmartPhone)p1;//실행시에 Class Cast Exception발생 |  문법 상 오류가 없으나 될리가 없다고 한다.
		//핸드폰객체의 참조값이 들어있는 p1.. 
		//아무런 관계가 없는 객체를 설명서를 바꿔준다고 될리가없다.
		//상위의 속성 재정의는 가능하나 하위 클래스의 속성(설명서) 재정의 는 불가능하다.
		//p2.doInternet();
		
	}

}

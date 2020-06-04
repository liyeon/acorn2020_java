package test.main;

import test.mypac.SmartPhone;

public class MainClass04 {
	public static void main(String[] args) {
		//객체는 new 할 때 만들어져서 객체는 하나임!
		//SmartPhone type의 지역변수 p1을 만들 준비만 하고 만들어 지지 않은 상태
		SmartPhone p1;//변수도 안 만들어진다. null이라도 집어넣던지..
		//SmartPhone type 의 지역변수 p2를 만들고 비워둔상태(참조값이 담기지 않은)
		SmartPhone p2 = null; // 참조값은 안 담긴 빈 상태의 변수(공간)가 만들어짐.
		//SmartPhone type 의 지역변수 p3을 만들고 참조값을 넣어둔 상태
		SmartPhone p3 = new SmartPhone(); //공간도 만들고 참조값도 들어있음ㅇ
		
		//p1은 아직 만들어 지지 않았기 때문에 문법이 성립하지 않는다.
		//p1.call();
		
		//p2는 비어있는(null 이 들어있는(참조값이 없는) 상태이기 때문에 실행시(runtime)시 nullPointerException 발생
		//p2.call(); 문법상으론 성립하지만 실행 안됨ㅇㅇ
		
		//p3에는 참조값이 들어 있으므로 정상적으로 사용 가능
		p3.call();
		
		
		
		
	}//void main
}//class

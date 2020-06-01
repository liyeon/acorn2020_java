package test.main;

import test.mypac.Car;

public class MainClass02 {
	public static void main(String[] args) {
		//Car 클래스로 객체를 생성(new Car())해서 참조값을 c1이라는 이름의 변수에 담아보세요
		Car c1 = new Car("볼보!");
		Car c2 = new Car("지프!");
		//()안에 지역변수의 이름은 뭘 전달해야하는지 힌트를 준다.
		//c1에 담겨있는 참조값을 이용해서 .drive()메소드를 호출해보세요
		c1.drive();
		c2.drive();
		System.out.println(c1.name);
		System.out.println(c2.name);
		//객체를 생성 할 때 전달하는 값이 객체 안의 메소드 에서 사용 가능하다.?
		
	}
}

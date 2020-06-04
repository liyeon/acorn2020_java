package test.main;

import test.auto.Car;
import test.auto.Engine;
import test.auto.Meow;

public class MainClass09 {
	public static void main(String[] args) {
		//여러분들이 Car 클래스를 상속받아서 만든 클래스로 객체를 생성해서
		//아래의 useCar()메소드를 호출해보세요
		Car m1 = new Meow(new Engine());//하나의 객체는 Car타입, Object타입, Meow 타입 (자바의 다형성)
		//Car car = (Car)m1;//없어도 상관없음
		//Car car = m1; 이기 때문에 가능가능 쌉가능
		MainClass09.useCar(m1);//이 메소드를 호출하기 위해서는 Car타입의 참조값을 호출해야 전달 할 수 있다.
	}
	public static void useCar(Car car) {//위에서 생성됐던 객체의 참조값이 전달이 된다.
		car.drive();
	}
}

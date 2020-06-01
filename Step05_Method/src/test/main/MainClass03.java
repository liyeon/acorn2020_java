package test.main;

import test.mypac.*;
public class MainClass03 {

	public static void main(String[] args) {
		MyObject obj1 = new MyObject();
		//.setNum(), .setName(). .useCar()메소드를 호출해보세요
		obj1.setNum(10); //지역변수 num에 들어갈 값을 대입하는 것. int num = 10;
		obj1.setName("뚱땅뚱땅");// String name = "뚱땅뚱땅" 와 동일
		obj1.useCar(new Car()); // Car car = new Car(); 와 동일하다.
		obj1.setNum2(30);
		int a = 20;
		String b = "김동현";
		Car c = new Car();
		//지역변수에 담긴 값을 이용해서 메소드 호출하면서 전달 할 수도 있다.
		obj1.setNum(a); //int num = a;
		obj1.setName(b);//String name = b;
		obj1.useCar(c); //Car car = c;
		
	}//
}//MainClass03 종료

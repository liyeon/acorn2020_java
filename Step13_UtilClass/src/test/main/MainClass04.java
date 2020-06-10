package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Car;

public class MainClass04 {

	public static void main(String[] args) {
		/*  1.
			Car type을 저장 할 수 있는 ArrayList 객체를 생성해서
			참조값을 List 인터페이스 type 지역변수 cars에 담아보세요
		*/
		List<Car> cars = new ArrayList<>();
		//2. Car객체(3개)를 생성해서 List 객체에 저장해보세요.
		cars.add(new Car("Jeep"));
		cars.add(new Car("VolVo"));
		cars.add(new Car("Cadillac"));
		//3. 반복문 for 문을 이용해서 List 객체에 저장된 모든  Car 객체의 drive()메소드를 순서대로 호출해보세요
		for(int i=0; i<cars.size();i++) {
			Car tmp = cars.get(i);
			tmp.drive();
		}
		System.out.println("======확장for문======");
		for(Car tmp:cars) {
			tmp.drive();
		}
		
	}
}

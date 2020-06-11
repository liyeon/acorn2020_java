package test.main;

import java.util.HashSet;
import java.util.Set;

import test.mypac.Car;
/*
 * HashSet<>
 * ArrayList - 어떤 데이터를 INDEx(순서)로 관리하고자 할때
 * HashMap - key:value, key:value
 * HashSet<> - 어떤 데이터를 어떠한 묶음으로 관리하고자 할 때
 * 
 * 
 *=================
 *HashSet은 Set인터페이스를 구현한 클래스이다.
 *- 순서가 없다.
 *- key값도 없다.
 *- 중복을 허용하지 않는다.
 *- 어떤 data를 묶음(집합) 으로 관리하고자 할 때 사용한다.
 */
public class MainClass12 {
	public static void main(String[] args) {
		//정수값을 저장 할 수 있는 HashSet 객체
		Set<Integer> set1 = new HashSet<>();
		set1.add(10);
		set1.add(20);
		set1.add(20);
		set1.add(30);
		set1.add(30);
		//문자열을 저장 할 수 있는 HashSet 객체
		Set<String> set2 = new HashSet<>();
		set2.add("kim");
		set2.add("lee");
		set2.add("park");
		set2.add("lee");
		set2.add("park");
		//Car 객체를 저장 할 수 있는 HashSet 객체
		Set<Car> set3 = new HashSet<>();
		//new 할 때마다 객체가 생성되기 때문에 4개가 그대로 들어간다.
		//지역변수명으로 add를 하면 id값이 같기 때문에 중복된 값이 된다.
		set3.add(new Car("Jeep"));
		set3.add(new Car("VolVo"));
		set3.add(new Car("Cadillac"));
		set3.add(new Car("VolVo"));
		Car car1=new Car("그랜저");
		set3.add(car1);
		set3.add(car1);
	}
}

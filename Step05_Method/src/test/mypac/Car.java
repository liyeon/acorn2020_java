package test.mypac;

/*
 * [클래스의 용도]
 * 1. 객체의 설계도 역할을 한다.
 * 2. 데이터 type의 역할을 한다.
 * 3. static 필드나 static메소드를 가지고 있는 역할을 한다.
 */
public class Car {
	// 자동차의 이름을 저장할 필드(속성)(저장소)
	public String name;

	// 달리는 메소드(기능)
	public void drive() {// function drive(){}를 만드는 것과 똑같다.
		System.out.println("부릉부릉!달립니다!");

	}
}

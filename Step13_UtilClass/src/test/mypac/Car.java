package test.mypac;

public class Car {
	//필드(데이터 저장소)
	private String name;
	//생성자
	public Car(String name) {
		this.name=name;
	}
	//메소드(기능)
	public void drive() {
		System.out.println(name + "이(가)부릉부릉 달려요!");
	}
}

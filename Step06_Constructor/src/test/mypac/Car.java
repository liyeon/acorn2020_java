package test.mypac;

public class Car {
	//필드
	public String name;
	
	//String Type을 전달 받는 생성자생성자
	public Car(String name) {
		//생성자의 인자로 전달받은 값을 필드에 저장하기
		this.name = name;
	}
	
	//메소드
	public void drive() {
		System.out.println(this.name +"이(가) 달려요");
	}
}

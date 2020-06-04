package test.auto;

public class Car {
	//필드
	public Engine engine;
	//메소드가 사용하는 어떤 필요한 값들이 저장되는 경우가 많다
	//Engine 객체를 인자로 전달 받는 생성자
	public Car(Engine engine) {
		//필드에 저장하기
		this.engine=engine;
	}
	//생성자를 하나라도 정의하면 꼭 저 생성자를 만들어야 호출이 가능하다.
	

	//메소드
	public void drive() {
		System.out.println("달려달려");
		if(this.engine==null) {
			System.out.println("Engine 객체가 없어서 달릴 수 없어요");
			return; //메소드 끝내기
		}
	}
}

package test.auto;

public class Truck extends Car{
	//Engine 객체를 생성자의 인자로 전달 받는 생성자
	public Truck(Engine engine) {
		//자식생성자로 받은 객체를 부모 생성자에 전달해 주어야 부모 객체가 생성된다.
		
		super(engine);//super()는부모생성자를가리키는 문법이다.
		//생성자를 하나라도 정의하면 기본 생성자는 사라진다.
		//car 객체가 생성되기 위해서는 engine객체가 필요하다.
		//자식생성자가 engine을 받아서 부모생성자에 넘겨줘야 문법적으로 성립한다
	
	}//이 모양이 돼야 extends Car를 받는 문법이 성립할수있다.
	//메소드
	public void dump() {
		//this. 은 참조값을 가리킨다. 상속된건 하나의 힙 영역에 다같이 묶인다.
		System.out.println("짐을 쏟아냅니다!");
	
		
	}
}

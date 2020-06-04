package test.auto;

public class Meow extends Car{
	//Engine의 객체를 생정자의 인자로 받는 생성자.
	public Meow (Engine engine){
		super(engine);
	}
	//메소드
	@Override
	public void drive() {
		super.drive();
		System.out.println("고양이가 차를 탈 수 있을까!");
	}
}

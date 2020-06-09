package test.auto;

public class TestCar extends Car {

	public TestCar(Engine engine) {
		super(engine);
	}

	@Override
	public void drive() {
		super.drive();
		System.out.println("수정합니다.");
	}

}

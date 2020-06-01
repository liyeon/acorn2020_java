package test.mypac;

/*
 * *메소드를 만들 때 고려 해야 하는 것.*
 * 
 * 1. 접근 지정자. - 이 메소드의 공개 범위는 어떻게 해야할것인지
 * 2. 리턴 type - 수행 했을 때 어떤 값을 되돌려줄것인지. 아무것도 안 돌려 줄 시에 void 
 * 3. 메소드명
 * 4. 메소드에 전달하는 인자의 갯수와 데이터 type
 * 
 */
public class MyObject {
	/*
	 * public -> 이 메소드는 어디에서든 접근 가능하다. //접근지정자 
	 * void -> 이 메소드는 어떤 값도 리턴하지 않는다. //리턴 type
	 * walk -> 메소드명
	 * walk()-> 이 메소드는 어떤 값도 전달 받지 않는다.
	 */
	public void walk() {
		System.out.println("걸어요!");
	}

	// int타입을 리턴해주는 메소드
	public int getNumber() {
		int myNum = 10;
		// int type을 리턴해 주어야 문법이 성립한다.
		return myNum;
	}

	// String type을 리턴해주는 메소드 String type은 참조값.
	// 데이터타입은 Car,Marine 등등 지정해준 Class에 따라 지정 가능하다.
	public String getGreeting() {
		String greet = "안녕하세요!";
		return greet;
	}

	// Car type을 리턴해주는 메소드

	public Car getCar() {
		// 객체의 내부
		Car c1 = new Car();
		return c1;
	}

	// int type을 메소드의 인자로 전달 받는 메소드
	public void setNum(int num) {// 지역변수
		System.out.println("num: " + num);
	}
	
	public void setNum2(int num) {
		System.out.println("테스트한 숫자는 "+ num +" 입니다");
	}
	// String type을 메소드의 인자로 전달 받는 메소드
	public void setName(String name) {
		System.out.println("name: " + name);
	}

	// Car type을 메소드의 인자로 전달 받는 메소드
	public void useCar(Car car) {
		car.drive();
	}
	// Car type을 메소드의 인자로 전달 받는 메소드
	public void useSome(String name, Car car) {
		System.out.println("name :"+name);
		car.drive();
	}
	// Radio type과 Speaker type을 전달받는 메소드
	public void doSome(Radio r, Speaker s) {
		System.out.println("doSome() 메소드가 호출 되었습니다.");
	}

}

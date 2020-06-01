package test.mypac;

public class Cat {
	public void catWalk() {
		System.out.println("캣워크");
	}

	public int catNumber() {
		int catNum = 10;
		return catNum;
	}

	public String catString() {
		String catStr = "Meow";
		return catStr;
	}

	public Car catCar() {
		Car c1 = new Car();
		return c1;
	}

	public void setCatNum(int num) {// 지역변수
		System.out.println("테스트한 숫자는 " + num + "입니다.");
	}

	public void setCatName(String name) {
		System.out.println("고양이 이름은 " + name +"입니다.");
	}

	public void useCatCar(Car car) {
		car.drive();
	}

	public void useCat(String name, Car car) {
		System.out.println("name :" + name);
		car.drive();
	}

	public void catCat(int num, String name, String breeds) {
		System.out.println("번호 : " +num +" 이름 : "+name + " 종 : " +breeds );
	
	}


}

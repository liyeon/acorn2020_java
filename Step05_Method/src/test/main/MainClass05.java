package test.main;
import test.mypac.*;
public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * test.mypac 패키지에 다양한 모양의 메소드를 가지는
		 * 클래스를 정의하고
		 * 그 클래스를 이용해서 객체를 생성하고 메소드도 호출해보세요.
		 */
		
		Cat c = new Cat(); 
		c.catWalk();
		System.out.println(c.catNumber());
		System.out.println(c.catString());
		c.catNumber();
		c.catString();
		c.catCar().drive();
		c.setCatNum(10);
		c.setCatName("삼색이");
		c.setCatName("뚱땅이");
		c.setCatName("야통이");
		c.useCatCar(new Car());
		c.useCat("뚱땅", new Car());
		c.catCat(1, "야통", "고등어");
		c.catCat(2, "뚱땅", "치즈태비");
		c.catCat(3, "먼지", "러시안블루");
	}
}

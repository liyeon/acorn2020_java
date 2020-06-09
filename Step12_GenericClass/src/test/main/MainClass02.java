package test.main;

import test.mypac.Apple;
import test.mypac.Banana;
import test.mypac.FruitBox;
import test.mypac.Orange;
//동적으로
public class MainClass02 {
	public static void main(String[] args) {
		//객체를 생성할때 Generic 클래스는 생략이 가능하다.
		FruitBox<Apple> box1=new FruitBox<>();
		FruitBox<Orange> box2=new FruitBox<Orange>();
		FruitBox<Banana> box3=new FruitBox<Banana>();
	}
}

package test.main;

import test.mypac.Zoo;
import test.mypac.Zoo.Monkey; //inner Class
import test.mypac.Zoo.Tiger;

public class MainClass03 {
	public static void main(String[] args) {
		//zoo클래스에 있는 getMonkey()메소드를 호출해서
		//리턴되는 값을 m1이라는 지역변수에 담아보세요
		
		Zoo z = new Zoo();
		//Zoo.Monkey m1 = z.getMonkey();
		Monkey m1 = z.getMonkey();//inner Class Type Monkey
		//메소드 호출하기
		m1.say();
		
		
		//zoo클래스에 있는 getTiger()메소드를 호출해서
		//리턴되는 값을 t1이라는 지역변수에 담아보세요
		Tiger t1 = z.getTiger();
		t1.say();
		
		
		
	}
}

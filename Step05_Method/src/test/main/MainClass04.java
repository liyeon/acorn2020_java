package test.main;

import test.mypac.*;

public class MainClass04 {

	public static void main(String[] args) {
		MyObject obj1 = new MyObject();
		//useSome() 메소드를 호출해보세요.
		Car c = new Car();
		obj1.useSome("뚱땅뚱땅", c);
		//doSome() 메소드를 호출해보세요!
		Radio r = new Radio();
		Speaker s = new Speaker();
		obj1.doSome(r, s);
	}
}
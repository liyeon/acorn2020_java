package test.main;

import test.mypac.Car;
import test.mypac.Messenger;

public class MainClass06 {
	public static void main(String[] args) {
		// Messenger 클래스의 static 메소드3개를 하나씩 호출해보세요.
		Messenger.sendMessage("xxxxx");
		Messenger.sendMessage("메에에엥세에에에지!!!!!!!!!");
		String a = Messenger.getMessage();
		System.out.println(a);
		Car c = new Car();
		Messenger.useCar(c);
	}
}

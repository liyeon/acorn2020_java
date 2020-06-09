package test.main;

import test.auto.Engine;
import test.auto.TestCar;

public class Test01 {

	public static void main(String[] args) {
		TestCar t = new TestCar(new Engine());
		t.drive();
	}

}

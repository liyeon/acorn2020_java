package test.main;

import test.human.Blood;
import test.human.Woman;

public class MainClass12 {

	public static void main(String[] args) {
		/*
		 * 프로그래밍의 목적 : 독서를 하고 싶다.
		 * 독서하는 프로그래밍을 해보세요
		 */
		Blood b = new Blood("+", "a");
		Woman woman = new Woman(new Blood("+","o"));
		woman.reading();
		Woman woman2 = new Woman(b);
		woman2.reading();
		new Woman(new Blood("+","o")).reading();
		new Woman(b).reading();
	}

}

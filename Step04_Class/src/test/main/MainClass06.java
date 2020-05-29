package test.main;

import test.mypac.Box;
import test.mypac.Car;
import test.mypac.Member;
import test.mypac.Rect;

public class MainClass06 {
	public static void main(String[] args) {
		// new Box(). 아이콘 중 초록동그라미는 필드 저장소라는 의미, 빨간색 에스는 static이라는 의미
		System.out.println("main 메소드가 시작 되었습니다.");
		Member a = Box.mem;// null
		Rect b = Box.rect;// null

		Car c = Box.car;// car의 참조값이 들어있다.
		c.drive();// 메소드 호출 가능!

		// 아래와 같이 사용 할 수도 있다
		Box.car.drive();
		System.out.println(a);// System은 import없이 사용 할 수 있는 클래스이다(string도).

		System.out.println();
		// system 클래스 안에 있는 out이라는참조값 안에 있는 PrintStream ;

		/*
		 * public class System{} public static PrintStream out = new xxxx();
		 *
		 *
		 */
//		a.showInfo(); //null member 타입
		//a가 null이므로 NullPointerException 발생 | 문법상 오류 아님
//		b.getArea();//b가 null이므로 NullPointerException 발생
	}
}

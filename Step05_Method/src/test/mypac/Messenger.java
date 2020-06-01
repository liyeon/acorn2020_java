package test.mypac;

public class Messenger {
	// String type을 인자로 전달받는 static 메소드
	public static void sendMessage(String msg) {
		System.out.println(msg + " 를 전송합니다.");
	}

	// String type을 리턴해주는 static 메소드
	public static String getMessage() {
		return "hello";
	}

	// Car type을 인자로 전달 받는 static 메소드
	public static void useCar(Car c) {
		c.drive();
	}
}

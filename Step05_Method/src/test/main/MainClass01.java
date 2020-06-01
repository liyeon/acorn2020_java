package test.main;

import test.mypac.MyObject;
public class MainClass01 {
	public static void main(String[] args) {
		// MyObject 클래스에 정의된 3개의 메소드를 차례로 호출하는 code를 작성해보세요.
		MyObject obj1 = new MyObject();
		obj1.walk();
		obj1.getNumber();
		obj1.getGreeting();
		
		//메소드가 리턴해주는 데이터를 지역변수에 담아보기
		int a = obj1.getNumber(); //int type 10으로 바뀐다(return);
		System.out.println(a);
		
		//String type을 리턴해주는 메소드
		String b = obj1.getGreeting();//String type은 참조값으로 바뀜ㅇㅇ  
		System.out.println(b);
		
		
	}
}

package test.main;

import test.mypac.SmartPhone;

public class MainClass07 {

	public static void main(String[] args) {
		//실행 후 콘솔창을 확인하면 부모 생성자가 먼저 호출되는 것을 확인 할 수 있다.
		SmartPhone p1 = new SmartPhone();//자식클래스를 생성을하면 부모클래스도 자동으로 생성된다.
		//SmartPhone에 실행순서가 맨 첫번째로 오기는 하나 시스템 프린터 직전까지 왔다가 실행하지 않고 부모 먼저 실행하도록 한다.
		//자동으로 new HandPHone 한거나 마찬가지다.
	}

}

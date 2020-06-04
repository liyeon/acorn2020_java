package test.main;

import test.mypac.SmartPhone;

public class MainClass06 {

	public static void main(String[] args) {
		SmartPhone p1 = new SmartPhone();
		p1.mobileCall();
		p1.doInternet();
		//SmartPhone 클래스에서 오버라이드 된 메소드가 호출된다.
		p1.takePicture();
		//확장을 할 때 부모 메소드를 개선하고 싶을 때. 덮어 쓰는 것 override
		
		
		
		
		
		
		
	}
}

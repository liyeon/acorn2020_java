package test.main;

import test.mypac.MyUtil;

public class MainClass02 {

	public static void main(String[] args) {
		// MyUtil 클래스의 static메소드 호출하기
		MyUtil.send();//static이 붙은 메소드는 new 객체를 생성하지 않아도 된다. 사물함에 안 만들어도 사용 가능.
		// MyUtil 클래스의 static필드에 값 대입하기
		MyUtil.version="1.0";
		System.out.println(MyUtil.version);
	}

}

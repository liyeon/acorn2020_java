package test.main;

import test.human.Blood;

public class MainClass10 {
	public static void main(String[] args) {
		//Blood 객체를 생성해서 참조값을 b1이라는 지역 변수에 담아보세요.
		Blood b1 = new Blood("+", "A");//Rh+ A형 혈액형을 의미
		Blood b2 = new Blood("+", "O");//Rh+ O형 혈액형을 의미
		b1.getRh();
		b1.getType();
		System.out.println(b1.getRh()+b1.getType());
		//Blood객체의 getter메소드 사용해보기
		String result1= b1.getRh();//"+"
		String result2 = b1.getType();//"A"
		
		String result3 = b2.getRh();//+
		String result4 = b2.getType();//O
		
	
		
	}
}

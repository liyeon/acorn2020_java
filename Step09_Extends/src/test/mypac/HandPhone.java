package test.mypac;

//phone클래스를 상속 받은 HandPhone 클래스
public class HandPhone extends Phone {
	//생성자!
	public HandPhone() {
		System.out.println("HandPhone() 생성자 호출됨");
	}
	//메소드
	public void mobileCall() {
		System.out.println("이동중에 전화를 걸어요");
	}
	
	//사진찍는메소드
	public void takePicture() {
		System.out.println("30만 화소의 사진을 찍습니다.");
	}
	
/*
 * 왜 상속을 하냐면
 * 위에 클래스에 정의된 기능(메소드) 들도 다 쓸 수 있다. 
 */
}

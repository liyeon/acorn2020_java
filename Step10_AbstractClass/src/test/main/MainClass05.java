package test.main;

public class MainClass05 {
	//필드
	public String myName="김구라";//non static
	public static String yourName="원숭이";
	public static void main(String[] args) {//run했을 때 들어오는 스테틱 메소드
//		System.out.println(MainClass05.myName);//static 메소드 안에서 non static은 사용 불가능하다.
		//this는 heap영역에서만 가능하다.
		//static메소드 안에서는 static 자원들만 obsess 할 수 있다.
		
		//myName이라는 필드는 non static 이므로 클래스명. 으로 접근 불가
		//myName은 non static 필드임으로 참조값으로 접근 가능.
		System.out.println(new MainClass05().myName);//필드는 객체를 생성해야 사용 가능
		

		//yourName 이라는 필드는 static 이므로 클래스명. 으로 접근이 가능하다.
		System.out.println(MainClass05.yourName);
		//yourName과 main() 메소드는 동일 클래스 내부에 있기 때문에 클래스명 생략 가능
		System.out.println(yourName);
		//static 메소드 안에서의 this는 의미도 없고 사용도 못 함.
//		System.out.println(this.yourName);객체안에서만의미있음
	}

}

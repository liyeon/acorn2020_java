package test.main;
/*
 * 클래스 안에 만든 클래스 : inner Class
 * 메소드 안에 만든 클래스 : local inner class
 */
public class MainClass04 {

	public static void main(String[] args) {
		//메소드 안에서드 클래스 정의가 가능하다.
		class Gura{
			public void say() {
				System.out.println("김구라 짱시름ㅠㅜ방송 그만 나오자");
			}
		}
		//메소드 안에 정의한 클래스를 이용해서 객체를 생성하고 참조값을 지역변수에 담기
		Gura g1 = new Gura();
		g1.say();   
	}

}

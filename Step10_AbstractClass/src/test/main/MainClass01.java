package test.main;

import test.mypac.MyWeapon;
import test.mypac.Weapon;

public class MainClass01 {
 
	public static void main(String[] args) {
		Weapon w1=new MyWeapon();//추상클래스도 일반 클래스와 마찬가지로 타입의역할이 가능하다.
		//추상 클래스는 단독으로 객체 생성이 불가능하다.
		//미완성된 메소드를 자식 클래스에서 강제로 오버라이드 해주면 가능하다.
		//abstractClass(추상클래스) 강제로 오버라이드 해야 한다.
		//목적 : Weapon type의 참조값을 얻어내는 것.
		//추상클래스를 이용하려면 자식클래스가 필요하다.
		//추상클래스는 만들어논거를 다운받아 import해서 사용한다.
		//어떤 용도로 사용할지 몰라서 기반만 만들어 놓은 것. 
		w1.prepare();
		w1.attack();
		Weapon w2 = new MyWeapon();
		w2.attack();
		/*
		 *  [ 추상클래스 (Abstract Class) ]
		 *  
		 *  - class 예약어 앞에 abstract 를 명시해서 클래스를 정의한다.
		 *  - 형태만 정의되고 실제 구현은 되지 않은 메소드가 존재할수있다.
		 *  - 형태만 정의된 메소드를 만들때는 abstract 예약어를 붙여서 메소드를 정의한다.
		 *  - 생성자는 존재하지만 단독으로 객체 생성은 불가하다
		 *  - 추상클래스 Type 의 id 가 필요하다면 추상클래스를 상속받은 자식클래스를 정의해서 객체 생성한다.
		 *  - 추상클래스를 상속받은 자식클래스는 부모의 추상메소드를 모두 오버라이드(재정의) 해야한다. 
		 */
	}

}

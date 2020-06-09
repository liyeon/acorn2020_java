package test.main;

import test.mypac.Weapon;

public class MainClass06 {
	//static innerClass로 Weapon 추상 클래스 상속받기
	public static class YourWeapon extends Weapon{

		@Override
		public void attack() {
			System.out.println("아무나 공격!");
		}
		
	}
	public static void main(String[] args) {
		/*
		 * useWeapon() 메소드를 호출하는게 목적이다.
		 * 호출하려고 보니 Weapon 추상 클래스 type 객체의 참조값이 필요함
		 * 따라서 Weapon 추상 클래스를 상속받은 클래스를 파일로 만들어야한다.
		 * 클래스를 따로 만들지 않고 내부클래스(inner Class)로 만들고 싶다.
		 */
		
		Weapon w1 = new YourWeapon();
		useWeapon(w1);
		//static이 붙어있는 메소드는 static Class로 지정을 해줘야 사용이 가능하다.
		
		//local inner class도 이용해보자
		class OurWeapon extends Weapon{
			@Override
			public void attack() {
				System.out.println("그만 공격할랭");
			}
			public void fly() {
				System.out.println("날아다닐랭");//Weapon이라는 설명서에 있는 메소드가 attack과 prepare두가지이고 추상클래스로 받아서 날아다닐 수 없다.
			//자식클래스의 내부 클래스에서 지정한 메소드를 사용하려면 자식클래스를 타입으로 받아야한다.
			}
		}
		
		
	
		Weapon w2 = new OurWeapon();
		useWeapon(w2);
		//w2.fly();

	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();

	}

}

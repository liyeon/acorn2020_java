package test.main;

import test.mypac.Weapon;

public class testClass {
	static Weapon w1 = new Weapon() {//필드 안의 익명 클래스
		
		@Override
		public void attack() {
			System.out.println("필드 안의 익명 클래스");
		}
	};
	
	
	public static void main(String[] args) {//main method
		class Gura{//local inner Class
			public void say() {
				System.out.println("say");
			}
		}
		new Gura().say();
		
		
		
	}//main method 
	

	public static void useWeapon(Weapon w) {//useWeapon method //Weapon class의 type을 쓰는 useWeapon 메소드
		w.prepare();
		w.attack();
	}//useWeapon method
	
}

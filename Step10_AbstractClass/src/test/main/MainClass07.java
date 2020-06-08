package test.main;

import test.mypac.Weapon;

public class MainClass07 {
	//run했을 때 실행순서가 시작되는 특별한 main 메소드
	
	public static void main(String[] args) {
		/*anonymous local inner class
		 * Weapon 추상 클래스를 상속 받은 익명의 local inner class의
		 * 생성자를 호출해서 Weapon type의 참조값을 얻어내서 지역변수 w1에 담기
		*/
		Weapon w1 = new Weapon() {//익명의 innerClass를 이용해서 참조값을 얻어내는 방법
			@Override
			public void attack() {
				System.out.println("아무나 공격할거야");
			}//Weapon(){} <--Weapon클래스를 상속받은 이름이 없는 클래스.
		};
		
		Weapon w2 = new Weapon() {
			
			@Override
			public void attack() {
				System.out.println("공중 공격을 해요");
			}
		};
		
	useWeapon(w1);	
	useWeapon(w2);
	useWeapon(new Weapon() {//객체를 일회용으로 사용
		@Override
		public void attack() {
			System.out.println("지상공격을해요");
		}
	});
	
	}//void main 종료
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();

	}

}

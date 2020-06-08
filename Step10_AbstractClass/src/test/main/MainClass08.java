package test.main;

import test.mypac.Weapon;

public class MainClass08 {
	//클래스의 필드에 Weapon type의 참조값 넣어두기
	//class 안에 정의 했기 때문에 anonymous inner class
	static Weapon w1=new Weapon() {//필드에 있는 참조값을 이용해서 메소드를 호출할수있따.
		@Override
		public void attack() {
			System.out.println("수중 공격을 합니다.");
		}
	};//필드
	
	public static void main(String[] args) {//main method
		//필드에 저장된 Weapon type의 참조값을 이용해서 useWeapon() 메소드호출하기
		useWeapon(w1);
	}//void main 종료
	
	public static void useWeapon(Weapon w) {//useWeapon method
		w.prepare();
		w.attack();

	}

}

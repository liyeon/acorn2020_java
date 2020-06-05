package test.main;

import test.mypac.MyWeapon2;
import test.mypac.Weapon;

public class MainClass02 {

	public static void main(String[] args) {
		//직접 클래스를 만들고 객체를 생성 해서 아래의 useWeapon()메소드를 호출하기!
		Weapon w = new MyWeapon2();//매개체역할을 했을뿐
		MainClass02.useWeapon(w);
	}
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}

}

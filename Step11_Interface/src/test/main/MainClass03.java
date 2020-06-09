package test.main;

import test.mypac.Drill;
import test.mypac.MultiPlayer;
import test.mypac.Remocon;

public class MainClass03 {
	public static void main(String[] args) {
		//MultiPlayer 객체는 3가지 타입이 모두 될 수 있기 때문에
		MultiPlayer mp = new MultiPlayer(); //자식객체가 부모 타입을 다 가지고 있기 때문에 가능
		//아래의 3개 메소드를 호출하면서 인자로 전달 할 수 있다.
		useRemocon(mp);
		useDrill(mp);
		useMuliPlayer(mp);
	}

	public static void useRemocon(Remocon r) {// Remocon 타입을 전달받는 메소드
		r.up();
		r.down();
		System.out.println("------------");
	}

	public static void useDrill(Drill d) {
		d.hole();
		System.out.println("------------");
	}

	public static void useMuliPlayer(MultiPlayer mp) {
		mp.up(); 
		mp.down();
		mp.hole();
	}
}//

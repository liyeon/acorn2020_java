package test.main;

import test.mypac.Remocon;

public class MainClass02 {
	//필드에 Remocon type
	static Remocon r3=new Remocon() {
		@Override
		public void up() {
			System.out.println("물건을 올려요");
		}
		@Override
		public void down() {
			System.out.println("물건을 내려요");
		}
	};
	
	public static void main(String[] args) {
		/*
		 *  Remocon 인터페이스를 구현한 익명의 local inner 클래스의 생성자를 호출해서
		 *  참조값을 얻어내서 Remocon type 의 지역변수 r1 에 대입하기 
		 */
		Remocon r1=new Remocon() {//{} 하면 익명 클래스가 된다. 리모컨 타입의 참조값을 익명클래스가 얻어낸것
			  //class ? implements Remocon{} 미완성인 메소드의 override를 강제하는 것이다.
			@Override
			public void up() {
				System.out.println("볼륨을 올려요");
			}
			@Override
			public void down() {
				System.out.println("볼륨을 내려요");
			}
		};
		
		useRemocon(r1);
		useRemocon(new Remocon() {//class ? implements Remocon{}

			@Override
			public void up() {
				System.out.println("채널을 올려요");
			}
			@Override
			public void down() {
				System.out.println("채널을 내려요");
			}
		});
		
		useRemocon(r3);
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}





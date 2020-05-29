package test.mypac;

public class Marine {
	
	//하나의 클래스에 nonstatic 필드와      static 필드ㄴ는 공존할수있다.
	//공격력을 저장하고 있는 static 필드
	public static int attackPower=6;//속도
	//에너지를 저장하고 있는 non static필드
	public int energy =40;
	
	//움직이는 메소드
	public void move() {
		System.out.println("마린이 움직입니다!");
	}
	//공격하는 메소드
	public void attack() {
		System.out.println(Marine.attackPower +"의 공격력으로 공격을 해요");
	}
	
	//현재 에너지를 출력하는 메소드
	public void showEnergy() {
		System.out.println("현재 에너지"+this.energy);
	}
	/*
	 * Static필드를 heap에서 참조하려면 Marine.attackPower
	 * 
	 * heap에서 heap을 참조하려면 this.
	 */
	
}

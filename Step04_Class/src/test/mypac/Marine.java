package test.mypac;

/*
 * 접근 지정자. 4가지.
 * 클래스, 필드, 메소드에 작성한다.
 * 1. public
 * - 어디에서나 자유롭게 접근 가능하다.
 * 2. default (접근 지정자(public 등)를 작성하지 않은 경우)
 * - 동일한 package 내에서만 접근 가능하다. 같은 패키지 내에서만 쓸 수 있다.
 * - package가 다르면 import도 불가능하다. 
 * 필드는 보통 메소드에서 사용하는 부품을 담고 있는 경우가 많다.
 * 프로그램의 신뢰성을 높이기 위해 	부분 공개를 하는 것이다.
 * 3. 
 */
public class Marine {

	// 하나의 클래스에 nonstatic 필드와 static 필드ㄴ는 공존할수있다.
	// 공격력을 저장하고 있는 static 필드
	public static int attackPower = 6;// 속도
	// 에너지를 저장하고 있는 non static필드
	public int energy = 40;

	// 움직이는 메소드
	public void move() {
		System.out.println("마린이 움직입니다!");
	}

	// 공격하는 메소드
	public void attack() {
		System.out.println(Marine.attackPower + "의 공격력으로 공격을 해요");
	}

	// 현재 에너지를 출력하는 메소드
	public void showEnergy() {
		System.out.println("현재 에너지" + this.energy);
	}
	/*
	 * Static필드를 heap에서 참조하려면 Marine.attackPower
	 * 
	 * heap에서 heap을 참조하려면 this.
	 */

}

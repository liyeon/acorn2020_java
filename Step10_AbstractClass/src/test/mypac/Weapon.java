package test.mypac;
/*
 * 미완성된추상 메소드를 멤버로 가지고 있는 클래스는
 * abstract 예약어를 붙여서 정의해야한다.
 */
public abstract class Weapon {//추상메소드를 하나라도 받고 있는 클래스는 abstract를 붙여서 클래스를 정의해야한다.
	//무기 작동을 준비하는 메소드
	public void prepare() {
		System.out.println("무기 작동을 준비합니다.");
	}
	//공격하는 메소드
	//미완성 된 추상메소드를 만들 때는 abstract예약어를 붙여서 메소드를 정의한다.
	public abstract void attack();
	//추상 메소드 // 어떤 동작을 할지 정해지지 않은 메소드
	//추상클래스는 파일 아이콘에 A가 붙어있음
}

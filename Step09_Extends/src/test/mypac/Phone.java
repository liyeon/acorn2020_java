package test.mypac;

public class Phone extends Object{//extends Object는 생량 가능
	// 기본 생성자 아무것도 안 써도 있다고 생각하라궁 public Phone(){}
	public Phone() {
		System.out.println("Phone() 생성자 호출됨");
	}
	//전화거는 메소드
	public void call() {
		System.out.println("전화를 걸어요");
	}
}

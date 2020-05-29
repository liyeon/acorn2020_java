package test.mypac;

public class Member {
	// non static 필드 정의하기
	public int num;
	public String name;
	public String addr;

	
	// non static 메소드 정의하기 내가 객체가 된다면 나의 참조값은 this.
	public void showInfo() {
		String name = "원숭이"; //지역변수
		//필드의 식별자 하고 지역변수의 식별자하고 같을 수 있다.
		System.out.println(this.num + " | " + this.name + " | " + this.addr);
		System.out.println(this.num + " | " + name + " | " + this.addr);
		//this가 없다면 메소드 안의 지역변수를 가리킨다.
	}
}

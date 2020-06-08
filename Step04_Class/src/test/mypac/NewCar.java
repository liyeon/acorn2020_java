package test.mypac;

public class NewCar {
	public String name;//필드
	public NewCar(String name) {//string 타입을 인자로 전달받는 생성자
		this.name=name; //string의 인자로 전달 받은 값을 필드에 저장하기
	}
	//메소드
	public void drive() {
		System.out.println(this.name +"가 달려요" );
	}
	
}

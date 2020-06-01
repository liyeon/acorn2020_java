package test.mypac;
/*
 * *생성자*
 * 1. 클래스명과 동일하다.
 * 2. 메소드 모양과 유사하지만 retrun type이 없다.
 * 생성자는 메소드가 아니기 때문에 return 타입이 없다.
 * 3. 객체를 생성 할 때 (new 할 때) 호출된다.
 * 4. 객체를 생성하는 시점에 무언가준비 작업을 할 때 유용하다.
 * 5. 생성자를 명시적으로 정의 하지 않아도 기본 생성자는 있다고 간주된다.
 * 
 */
public class Student {
	//생성자 
	public Student() {//new Student()는 이걸 호출하는 거
		/*뭔가 할 작업이 없으면 정의 할 필요 없다.
		//실행 순서는 new 하는 시점에 들어온다.(객체를 사물함 영역에 만드는 순간);
		//객체를 생성하는 시점에 초기화 해야할때(준비작업을해야할때)
		 * 
		 */
		System.out.println("Student 클래스의 생성자가 호출됨");
	}
	
	//메소드
	public void study() {
		System.out.println("공부를 합니다.");
	}
	public void goSchool() {
		System.out.println("학교를 갑니다.");
	}
	
}

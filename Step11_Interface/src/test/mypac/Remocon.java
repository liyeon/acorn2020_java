package test.mypac;
/*
 *  [ interface ]
 *  
 *  - 생성자가 없다 (단독 객체 생성 불가)
 *  - 구현된 메소드는 가질수 없다 ( 추상 메소드만 가질수 있다 )
 *  - 필드는 static final 상수만 가질수 있다.
 *  - data type  의 역할을 할수 있다.
 *  - interface type 의 참조값이 필요하면 구현(implements) 클래스를 만들어서
 *    객체를 생성해야 한다.
 *  - 클래스 상속은 단일 상속이지만, 인터페이스는 다중 구현이 가능하다 
 *  - 구현된 메소드는 정의 할 수 없다.
	- 구현된 메소드를 사용하면 오류가 난다.
	- 추상클래스보다 많이 쓰인다.
	- 어떤 클래스가 특정 인터페이스를 구현을 하면 구현할 메소드의 모양은 미리 정해져있다.(특정 메소드를 강제하는 역할)

 */
public interface Remocon {
	//필드 (static final 예약어 생략 가능)
	public static final String COMPANY="LG";//Remocon.Compay로 ㅏ용 가능
	/*
     * static final만 가지기 때문에 생략 가능
     * abstract(추상 메소드) 만 가지기 때문에 생략 가능.
     */

	//메소드 (abstract 예약어 생략 가능)
	public abstract void up();
	public void down();
}













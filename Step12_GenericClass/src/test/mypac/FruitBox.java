package test.mypac;
/*
 * Class 클래스명<Generic type>
 * 클래스를 정의 할 때 Generic type을 지정해서 특정 type을 동적으로 지정 할 수 있다.
 */
public class FruitBox<T> {//포괄타입을 변수명 적듯이 적는다.//어떤한 데이터 타입을 동적으로 전달 받을 수 있는 문법이다.
	//필드
	private T item;
	//메소드
	public void push(T item) {//필드에 전달하는 메소드
		this.item=item;
	}
	public T pull() {//에플타입을 리턴해주는 메소드
		return item;
	}
}

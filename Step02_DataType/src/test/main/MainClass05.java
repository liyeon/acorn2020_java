package test.main;

/*
 *JAVA 참조 데이터 type 
 * String Type
 *-문자열을 다룰 때 사용하는 데이터 type이다.
 *변수 안에는 아이디 값이 나온다 이걸 참조값이라 하면 됨.
 *이 정보를 가지고 있는 문자데이터는 id 25라는 사물함에 들어갔다.
 *id값을 가지고 다니는 데이터타입은 참조 데이터 타입.
 */
 
public class MainClass05 {

	public static void main(String[] args) {
		System.out.println("main메소드가 시작되었습니다.");
		
		//"김구라" 정보를 담고 있는 참조값(id값)이 변수에 들어간다.
		String name="김구라";
		String tmp=name;//참조값 복사해주기
		name="원숭이";//새로운 참조값으로 대입학기
		/*참조데이터타입의 특징은
		//사물함에 들어있는 것을 객체라 한다.
		/참조값,키값,id값 다 똑같은 얘기.
		 * 스트링 타입을 가지고 있는 변수에 .을 찍으면  
		 * 객체 : 속성(데이터의 저장소)와 기능
		 */
		
		name=null;//name 변수를 empty(빈) 상태로 만들기
		//오직 string타입의 참조값만 들어갈 수 있는 빈 공간.
		//null예약어임ㅇㅇ
	}

}

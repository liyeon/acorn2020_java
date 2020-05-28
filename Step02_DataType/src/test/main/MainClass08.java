package test.main;

public class MainClass08 {
	public static void main(String[] args) {
		//string type의 메소드 사용해보기
		String str="abcde12345";//str 안에는 스트링타입의 참조값이 들어있다. 사물함 참조키
		//문자열의 길이
		str.length(); //string의 메소드를 반환하면 int타입으로 바뀜 int type 10으로 바뀐다.
		//메소드를 호출한 이 위치는 바뀔 수도 있고 안 바뀔수도있다. 
		//문자열의 길이
		int size = str.length();
		System.out.println(size);
		/*
		 * 참조값에 쩜을 찍은 것. 찍으면 기능을 사용 할 수 있다. 함수가 아니고 메소드라 한다.
		 * 어떤 객체의 참조값에 쩜을 찍으면 메소드를 사용가능하다.
		 */
		//5번 인덱스의 문자 1개
		char ch = str.charAt(5);
		System.out.println(ch);
		//소문자를 모두 대문자로 변환한 문자열을 얻어낼 수 있다.
		String result =str.toUpperCase(); 
		System.out.println(result);
	
	}

}


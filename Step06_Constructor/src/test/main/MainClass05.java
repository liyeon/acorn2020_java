package test.main;

import java.util.Scanner;

public class MainClass05 {
	public static void main(String[] args) {
		//InputStream a = System.in;
		/*
		 *프로그래밍의 목적 : 키보드로 부터 문자열을 입력받고싶다.
		 *입력받아서? : 콘솔창에 출력한다.
		 */
		//생성자의 인자에 적합한 값을 넣어야 실행이된다.
		//System.in//inputStream 키보드와 연결된 아주 특별한.객체 system 클래스의 static 필드에 들어있는 것.
		//new Scanner(System.in) 와 inputStream source = System.in 동일
		Scanner scan = new Scanner(System.in);//InputStream type //시스템 클래스 안의 필드에 들어있다.
		//system은 키보드로부터입력받을수있는객체
		//키보드로 입력받기 위해서는 일단 콘솔창을 열리게 해야 한다.
		System.out.println("문자열을 입력하세요 : "); 
		//Scanner 객체의 메소드를 이용해서 문자열(String)입력받기
		String str = scan.nextLine();//실행순서가 어딘가에 잡혀있는것 요기 잡혀있음 //입력을 하고 엔터치는 순간 리턴된다.
		//실행 시점에 입력을 받는다. 입력받은 문자열이 갯수가 몇개인지?
		//입력받은 문자열을 콘솔창에 출력하기
		System.out.println(str);
		System.out.println(str.length());
		System.out.println("main 메소드가 종료됩니다.");
	}
}

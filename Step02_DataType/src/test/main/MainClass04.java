package test.main;
/*
 * [java기본 데이터 type]
 * 2. 문자형 (char)
 * -65536가지의 코드값을 가질 수 있다.
 * -전세계에서 사용하는 모든 문자 1글자를 표현 할 수 있다.
 * -single quotation(싱글따옴표)를 이용해서 만든다.
 * */
public class MainClass04 {
	public static void main(String[]args) {
		System.out.println("Main 메소드가 시작되었습니다.");
		//char 형 변수 선언과 동시에 값 대입하기
		char ch1='a';
		char ch2='b';
		char ch3='c';
		char ch4='가';
		char ch5='나';
		char ch6='다';
		char ch7='@';
		
		//정수값에 1:1 대응되는 char 값이 존재한다.value 유니코드 값이 나옴.
		int code1=ch1;
		int code2=ch2;
		int code3=ch3;
		int code4=ch4;
		int code5=ch5;
		int code6=ch6;
		int code7=ch7;
		
		char result1=100;
		char result2=101;
		char result3=102;
		System.out.println("Main 메소드가 종료되었습니다.");
	}
	
}
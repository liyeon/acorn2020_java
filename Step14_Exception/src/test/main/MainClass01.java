package test.main;

import java.util.Scanner;

public class MainClass01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		//숫자형식의 문자열을 입력받는다. "10" "20" 등등
		String inputNum = scan.nextLine();
		try {//예외처리? // 예외가 발생 할 수 있는 공간을 try{} 로 묶어준다. //try 안에 지정된 지역변수는 try 안에서만 사용 가능하다.
		//입력한 숫자를 실제 숫자로 바꾼다.
		double num = Double.parseDouble(inputNum);
		//입력한 숫자에 100을 더한다.
		double result = num+100;
		System.out.println("입력한 숫자("+ inputNum + ") + 100 = " + result);
		}catch(NumberFormatException nfe) {//발생 할 수 있는 exception(예외) 타입과 지역변수(참조값)를 입력해준다.
			//exception은 자바에서 객체로 관리가 된다.
			System.out.println("숫자 형식에 맞게 입력해주세요!");
			//예외 정보를 콘솔창에 출력하기
			nfe.printStackTrace();//printStackTrace() 예외 정보를 출력 해주는 객체? 메소드
		};
		System.out.println("========================================");
		System.out.println("main메소드가 종료됩니다.");
		
		//NumberFormatException
		
		
		
		
	}// void main 종료
}// class 종료

package test.main;

import java.util.Random;
import java.util.Scanner;

public class MainClass06 {

	public static void main(String[] args) {
		/*
		 * 1. Scanner 객체를 이용해서 문자열을 5번 입력 받는다.
		 * 입력받은 문자열은 차례대로 배열에 저장되어야한다.
		 * 모두 다 입력 받은 후 for문을 이용해서 배열에 저장된
		 * 모든 문자열을 콘솔창에 순서대로 출력하는 코드를 작성해보세요!
		 */
		//Scanner 객체를 생성해서 참조값을 지역변수에 담기
		Scanner scan = new Scanner (System.in);//System.in은 inputStream type
		//문자열(String) 5개를 담을 수 있는 배열 객체를 생성해서 참조값을 지역변수에 담기!
		String[] msgs = new String[5];
		//다섯번 문자열을 입력받기 위해 for문을 구성한다.
		for(int i=0; i<msgs.length; i++) {
			System.out.println("문자열을 입력해주세요!"); 
			String str = scan.nextLine();//입력한 문자열의 참조값이 str이라는 변수에 담긴다.
			//키보드로 부터 String type의 객체를 new 받아서 str에 리턴해준다.
			//입력받은 문자열의 참조값을 배열에 순서대로 저장하기.
			msgs[i] = str;
			
		}
		for(int i=0; i<msgs.length; i++) {
			//i번째 방에 있는 String 객체의 참조값을 불러온다.
			String tmp = msgs[i];
			//콘솔에 출력한다.
			System.out.println(tmp);
		}//객체의 메소드를 통해서 문제를 해결하고 있다.
		//scan for문 종료
		
		/*
		 *2. Random 객체를 이용해서 로또 번호 6개를 랜덤하게 얻어내서 배열에 저장한다.
		 *모두 다 저장되면 for 문을 이용해서
		 *배열에 저장된 모든 로또 번호를 콘솔창에 순서대로 출력하는 코드를 작성해보세요! 
		 */
		
		int[] ran = new int[6];
		for(int i=0; i<ran.length; i++) {
			//int r = ran[i];
			Random b = new Random();
			int lottoNum = b.nextInt(45)+1;
			System.out.println("로또번호는!"+lottoNum);
			
		}//Random for문 종료
		
		
		
		
		
		
		
	}// void main종료
}// MainClass06 종료
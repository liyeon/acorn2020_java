package test.main;
/*
 * hint
 * String[] items=
 * 
 *  1.
 * cherry, apple, banna,melon,7
 * 다섯개의 문자열 중에서 하나가 랜덤으로 출력되게해보세요
 * 
 * 2.다섯개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력해보세요.
 * 예) cherry | apple | cherry
 *    7 | apple | melon
 *    7 | 7 | 7
 */

import java.util.Random;

public class MainClass08 {

	public static void main(String[] args) {
		//랜덤하게 출력할 문자열을 미리 배열에 담아놓는다.
		String[] items = {"Cherry", "Apple", "Banna", "Melon", "7"};
		//랜덤한 숫자를 얻어내기 위한 객체
		Random ran = new Random();
		//0~4사이의 랜덤한 정수 얻어내기
		int ranNum = ran.nextInt(5);
		System.out.println(items[ranNum]);
		
		
	}// void main
}// MainClass

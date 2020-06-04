package test.main;
/*
* 
* 2.다섯개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력해보세요.
* 예) cherry | apple | cherry
*     7  | apple | melon
*     7  | 7 | 7
*/

import java.util.Random;

public class MainClass09 {

	public static void main(String[] args) {
		//랜덤하게 출력할 문자열을 미리 배열에 담아놓는다.
		String[] items = {"Cherry", "Apple", "Banna", "Melon", "7"};
		//랜덤한 숫자를 얻어내기 위한 객체
		Random ran = new Random();
		
		//랜덤하게 얻어낸 3개의 정수를 저장할 배열.
		int[] nums = new int[3];
		//0~4사이의 랜덤한 정수 얻어내기
		for(int i=0; i<nums.length; i++) {
			//랜덤한 정수를 얻어내서
			int ranNum = ran.nextInt(items.length);
			nums[i]=ranNum;//배열에 저장한다.
		}
		
		//랜덤한 정수 세개 참조
		int one= nums[0];
		int two= nums[1];
		int three= nums[2];
		
		System.out.println(items[one]+"|"+items[two]+"|"+items[three]);
		
		
	}// void main
}// MainClass

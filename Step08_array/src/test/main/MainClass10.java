package test.main;

import java.util.Random;

public class MainClass10 {
	public static void main(String[] args) {
		/*
		* 
		* 2.다섯개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력해보세요.
		* 예) cherry | apple | cherry
		*     7  | apple | melon
		*     7  | 7 | 7
		*     
		*     cherry | cherry | cherry
		*     10점입니다.
		*     
		*     apple | apple | apple
		*     20점 입니다.
		*     바나나 30점
		*     멜론 40점
		*     7 - 1000점
		*     apple | cherry | apple
		*     0점입니다.
		*  	  
		*     hint
		*     int[] points = {10, 20, 30, 40, 1000}
		*     if(nums[0] == nums[1] && nums[1] == nums[2]){}
		*     배열 반복문 if문의 조합..
		*/
		
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
				
				System.out.println(items[one]+" | "+items[two]+" | "+items[three]);
				
				//부여할 점수를 미리 배열에 담아둔다.
				int[] points = {10, 20, 30, 40, 1000};
				//nums = {0,0,0}; Cherry가 나온것. 점수를 참조할 방번호
				//nums 배열에 있는 3개의 숫자가 모두 같은지 비교해본다.
				if(nums[0] == nums[1] && nums[1] == nums[2]) {//3개가 모두 같은 경우
					//점수가 몇점인지 부여해야한다.
					//nums배열에 있는 숫자 3개가 다 같으므로 아무거나 하나를 읽어와서 점수를 얻어낸다.
					int point = points[nums[0]];//0 or 1 or 2or 3or 4
					System.out.println(point + "점입니다.");
				}else {//하나라도 다를 경우
					//0점을 출력한다.
					System.out.println("0점 입니다.");
				}
				
	}//void main
}//class

package test.main;

import java.util.Random;

public class MainClass07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 *2. Random 객체를 이용해서 로또 번호 6개를 랜덤하게 얻어내서 배열에 저장한다.
		 *모두 다 저장되면 for 문을 이용해서
		 *배열에 저장된 모든 로또 번호를 콘솔창에 순서대로 출력하는 코드를 작성해보세요! 
		 */
		
		
		Random ran = new Random();
		//로또 번호를 저장 할 수 있는 방 6개짜릴 배열 객체 생성하기.
		int[] nums = new int[6];
		//반복문을 돌면서 로또번호6개를 얻어낸다.
		for(int i=0; i<nums.length; i++) {
			int lottoNum = ran.nextInt(45)+1;
			//순서대로 저장하기
			nums[i]=lottoNum;
		}//Random for문 종료
		
		for(int tmp:nums) {//for문의 줄임. (타입 만들지역변수:배열){}
			System.out.println("로또번호는!!"+tmp);
		}
		//for문 종료
				
	}// void main종료
}// MainClass07 종료
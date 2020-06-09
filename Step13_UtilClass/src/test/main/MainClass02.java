package test.main;

import java.util.ArrayList;

public class MainClass02 {
	public static void main(String[] args) {
		//정수를 저장 할 수 있는 가변 배열 객체 생성
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
		//배열의 크기 얻어오기
		int size = nums.size();
		//특정 인덱스의 아이템 얻어오기 (참조)
		int num1 = nums.get(0);
		Integer nums2 = nums.get(1);
		int num3 = nums.get(2);
		//1번방을 40으로 바꾼다. 특정 인덱스 수정
		nums.set(1,  40);
		//1번방을 지운다. 특정 인덱스 삭제
		nums.remove(1);
		//다 지움 배열 비우기
		//정수가 Integer객체에 첨조값으로 저장되어있다.  
		nums.clear();
		System.out.println(nums);
		
		for(int i=0;i<nums.size();i++) {
			System.out.println(nums.get(i) + "번 입니다.");
		}
		
		
	}

}

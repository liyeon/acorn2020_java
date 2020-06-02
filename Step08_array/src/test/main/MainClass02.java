package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		//0으로 초기화된 방 3개짜리 int[] 객체를 만들어서 참조값을 지역변수 nums에 담기
		int[] nums= {0,0,0};//new를 한 것
		nums[0]=10;
		nums[1]=20;
		nums[2]=30;
		//0을 초기화된 방 3개짜리 int[] 객체를 만들어서 참조값을 지역변수 nums2에 담기
		int[] nums2=new int[3];
		nums2[0] = 100;
		nums2[1] = 200;
		nums2[2] = 300;
		//nums2[3] = 400;//??없는 방 번호를 참조하면 Exception(예외)이 발생한다.
		System.out.println("마무리 작업을 하고 app을 종료합니다.");
	}
}

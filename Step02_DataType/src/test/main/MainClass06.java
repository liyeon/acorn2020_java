package test.main;
/*
 * 메소드 안에서 만든 것은 지역 변수
 * */
public class MainClass06 {
	public static void main(String[] args) {
		//int type지역 변수를 선언만 하면 만들어 지지 않는다.
		System.out.println("main메소드가 시작되었습니다.");
		int num1;/*만들 준비만 해 놓음*/
		//String type 지역변수를 선언만 하면 만들어지지 않는다.
		String name1;
	//아직 만들어 지지 않았기 때문에 num1은 참조 불가하다.
//		int result=10+num1;
		//아직 만들어지지 않았기 때문에 name1은 참조불가.
//		System.out.println("name1:"+name1);
		System.out.println("main메소드가 종료됩니다.");
		
}	
}

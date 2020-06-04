package test.main;

import java.util.Random;
import java.util.Scanner;

public class MainClass11 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		//외형상 무한루프
		while(true) {
			System.out.print("종료(q) 계속(enter) : ");//print는 개행하지않는다.
			String str = scan.nextLine();
			String str2="q";
			if(str.equals(str2)) {//무한루프탈출조건 //문자열을 비교할때는 메소드를 이용해서 비교해야한다. equals 같으면 true, 다르면 false
				//문자열을 어케 만드냐에 따라서 문자열은 같고 참조값은 다를 수 있다. 문자열이 같은지 궁금할때 사용하는게 equals
				break;//while문 탈출
			}
			System.out.println("무언가작업합니다.");
			//이전예제에서 작업한 내용을 static메소드에 이동시키고 해당 메소드 호출하기
			MainClass11.doGame();//같은공간에잇는거래 MainClass11은생략가능하다.
		}      
		System.out.println("main메소드가 종료됩니다.");
		}
	
	public static void doGame() {
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
		
		//thread 클래스에 있는 sleep이라는 메소드에 1000을 전달한다.
		//저 위치에서 실행 순서가 1초동안 잡혀있다가 진행한다. 리셉션?이 발생한다.
		
		for(int i=0; i<nums.length;i++) {
			try {
				//실행의 흐름(스레드)을 1초 잡아놓기!
				Thread.sleep(1000);//리셥션이 발생한걸 처리하는 문법?
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//.print()메소드를 이용해서 개행 기호를 출력하지 않는다.
			System.out.print("| \t" + items[nums[i]]+"\t |"); // print - 한줄로 출력. // "\t" 는 tab이다.
		}
		//개행 한번하기
		System.out.println();
		
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
	}
}

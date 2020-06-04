package test.main;

import java.util.Random;
import java.util.Scanner;

/*
 * - 컴퓨터와 가위바위보하기 -
 * 	가위(s), 바위(r), 보(p)
 *  
 *  나 : 가위 vs 컴 : 보 
 *  win!(draw or lose)
 *  
 *  나 : 보 vs 컴 : 가위
 *  
 *배열 if문 반복문
 */
public class MainClass13 {
	public static void main(String[] args) {
		//가위바위보 문자열을 일단 배열에 담아보자.
		String[] items = { "가위", "바위", "보" };
		//사용자 입력을 받아야 하니 Scanner 객체를 생성한다.
		Scanner scan = new Scanner(System.in);
		//컴퓨터가 랜덤하게 가위바위보를 정해야하니 Random객체를 생성한다.
		Random ran = new Random();
		
		
		//1.사용자 입력을 받는다.
		System.out.println("가위(s) 바위(r) 보(p)를 입력하세요!");
		System.out.println("====================");
		String clientInput = scan.nextLine();
		//client에는 s or r or p or error!가 입력받을 수 있다.
		
		//2."s"는 0, "r"은 1, 'p"는 2로 바꿔보기로 하자.
		int me=0; //정수값을 받을 변수
		if(clientInput.equals("s")) {
			me=0;
		}else if(clientInput.equals("r")) {
			me=1;
		}else if(clientInput.equals("p")) {
			me=2;
		}
		if(clientInput.equals("가위")) {
			me=0;
		}else if(clientInput.equals("바위")) {
			me=1;
		}else if(clientInput.equals("보")) {
			me=2;
		}
		
		
		//3. Computer도 랜덤하게 하나의 숫자를 부여받는다.(0,1,2 중에 하나)
		int com = ran.nextInt(3);
		//변수를 미리 만들어 두고 조건에 의해 변수를 사용한다.
		//win, draw, lose 문자열을 담을 변수를 미리 만들어준다.
		String result=null;
		//4. 승패를 판단해야 한다.
		if((me==0 &&com==2) || (me==1 && com==0) || (me==2 && com==1)) {//내가 이기는 경우
			result = "이겼습니다!";
		}else if(me == com) {//비기는 경우
			result = "비겼습니다!";
		}if(me!=0 || me!=1 || me!=2) {
			result = "정해진 글자를 입력해주세요";
		}else {//나머지는 따져 보지 않아도 내가 지는 경우.
			result = "졌습니다ㅜㅠ";
		}
//		if(me==0 &&com==2) {//내가 이기는 경우
//			result = "Win!!!";
//		}else if(me==1 && com==0) {
//			result = "Win!!!";
//		}else if(me==2 && com==1) {
//			result = "Win!!!";
//		}else if(me == com) {//비기는 경우
//			result = "Draw!";
//		}else {//나머지는 따져 보지 않아도 내가 지는 경우.
//			result = "lose...";
//		}
		System.out.println("====================");
		System.out.println("나 : " + items[me]+" vs 컴 : "+items[com]);
		System.out.println("==========결과==========");
		System.out.println(result);
		
		
		
	}// void main
}// MainClass13

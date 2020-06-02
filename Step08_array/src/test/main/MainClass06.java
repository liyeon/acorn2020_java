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
		Scanner[] scan = new Scanner[5];
		for(int i=0; i<scan.length; i++) {
			Scanner tmp = scan[i];
			tmp = new Scanner(System.in);
			System.out.println("문자열을 입력하세요 : "); 
			String str = tmp.nextLine();
			//System.out.println(str);
		}//scan for문 종료
		
		
		/*
		 *2. Random 객체를 이용해서 로또 번호 6개를 랜덤하게 얻어내서 배열에 저장한다.
		 *모두 다 저장되면 for 문을 이용해서
		 *배열에 저장된 모든 로또 번호를 콘솔창에 순서대로 출력하는 코드를 작성해보세요! 
		 */
		Random[] ran = new Random[6];
		for(int i=0; i<ran.length; i++) {
			Random r = ran[i];
			r = new Random();
			int lottoNum = r.nextInt(45)+1;
			System.out.println("로또번호는!"+lottoNum);
		}//Random for문 종료
		
		
	}// void main종료
}// MainClass06 종료
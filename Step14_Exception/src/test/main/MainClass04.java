package test.main;

import java.util.Random;

import test.mypac.SleepyException;

public class MainClass04 {
	public static void main(String[] args) {
		Random ran = new Random();
		
			for(int i=0; i<100; i++) {
				//0~9사이의 랜덤한 정수를 발생시킨다.
				int ranNum=ran.nextInt(10);
				//예외를 일부로 발생시킬수있다.
				if(ranNum==5) {//우연히 랜덤한 정수가 5가 나오면 예외를 발생시킨다.
					//throw 예약어와 함께 예외 객체를 생성하면 예외가 발생한다. 예외를 던진다. 객체를 생성해서 던지면 예외가 발생한다.
					throw new SleepyException("너무 졸려ㅠㅜ");
				}
				System.out.println(i+1+"번째 작업중입니다.");
			}
		
		System.out.println("main 메소드가 종료됩니다.");
	}
}

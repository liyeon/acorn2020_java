package test.main;

import test.mypac.Marine;

public class MainClass07 {
	public static void main(String[] args) {
		//MainClass07.main();main이라는 메소드를 실행하면 시작한다.
		/*
		 * Marine 객체를 생성해서 참조값을 m1이라는 지역 변수에 담아보세요
		 */
		
		Marine m1 = new Marine(); 
		m1.move();
		m1.attack();
		
		m1.showEnergy();
		System.out.println("-----m1-----");
		
		Marine m2=new Marine();
		m2.move();
		m2.attack();
		m2.showEnergy();
		System.out.println("-----m2-----");
		
		//Marine의 공격력을 올려보자 (모든 Marine 객체의 공격력에 영향을 미친다.)
		//모든 것에 영향을 줄 때. 하나만 있어도 될 때
		Marine.attackPower += 2;  //2를 더한 다음 대입
		m1.attack();
		m2.attack();
		
		//m1의 에너지 감소시키기 (m2의 에너지에는 영향을 주지 않는다.)
		//객체마다 영향을 줄 때.
		m1.energy -= 10;
		m1.showEnergy();
		m2.showEnergy();
	}
}
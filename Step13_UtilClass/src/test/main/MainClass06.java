package test.main;

import test.mypac.MemberInfo;
import test.mypac.PrivateInfo;

public class MainClass06 {

	public static void main(String[] args) {
		//default 생성자를 호출해서 MemberInfo 객체 생성
		MemberInfo m1 = new MemberInfo();
		//필드에 값을 각각 대입하기
		m1.num=1;
		m1.name="김구라";
		m1.addr="노량진";
		
		//int, String, String type을 인자로 전달하는 생성자를 호출해서 MemberInfo 객체생성
		MemberInfo m2 = new MemberInfo(2, "해골", "행신동"); 
		
		PrivateInfo p1 = new PrivateInfo(0, "원숭이", "동물원");
		System.out.println(p1.getNum()+p1.getName()+p1.getAddr());
	
		
	}

}

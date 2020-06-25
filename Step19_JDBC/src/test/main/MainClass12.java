package test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass12 {
	public static void main(String[] args) {
		/*
		 * MemberDao 객체를 이용해 회원목록을 얻어와서
		 * 아래와 같은 형식으로 출력해보세요
		 * 
		 * 1|김구라|노량진
		 * ..
		 * .
		 * .
		 * .
		 * .
		 */
		//MemberDao 객체의 참조값얻어오기
		MemberDao dao = MemberDao.getInstance();
		//MemberDao 객체의 메소드를 이용해서 회원목록 얻어오기
		List<MemberDto> list = dao.getList();
		//반복문 돌면서 원하는 형식으로 출력하기
		for(int i=0; i<list.size(); i++) {
			MemberDto tmp = list.get(i);
			System.out.println(tmp.getNum() +" | "+ tmp.getName() +" | "+ tmp.getAddr());
		}
		System.out.println("--------------------------------");
		for(MemberDto tmp:list) {
			System.out.println(tmp.getNum() +" | "+ tmp.getName() +" | "+ tmp.getAddr());
		}//for 종료
		
	}//main
}//class

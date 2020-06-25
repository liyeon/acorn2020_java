package test.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass13 {
	public static void main(String[] args) {
		/*
		 * Scanner 객체를 이용해서 문자열을 두번 입력받는다.
		 * 즉 새로 추가할 이름과 주소를 입력 받아서
		 * MemberDao 객체를 이용해서 DB에 저장하는 code를 작성해보세요
		 */
		//Scanner 객체를 이용해서 이름과 주소를 문자열로 입력받기
		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		String name = scan.nextLine();
		System.out.println("주소를 입력하세요");
		String addr = scan.nextLine();
		
		//이름과 주소를 MemberDto 객체에 저장하기
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		//MemberDao 객체의 참조값얻어오기
		MemberDao dao = MemberDao.getInstance();
		//MemberDao 객체의 메소드를 이용해서 Db에 저장하기
		dao.insert(dto);//boolean isSuccess = 
		dao.getList();
	}//main
}//class

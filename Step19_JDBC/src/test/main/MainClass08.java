package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass08 {
	public static void main(String[] args) {
		// 추가할 회원의 정보
		String name = "주뎅이";
		String addr = "봉천동";
		// 아래의 insert()메소드를 호출해서 회원 한명의 정보가 추가되도록 해보세요
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		insert(dto);
	}// main()
	//MemberDto 객체를 인자로 전달받아서 회원정보를 DB에 저장하는 메소드
	public static void insert(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DBConnect().getConn();
			String sql = "INSERT INTO MEMBER "
					+ " (num, name, addr) "
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.executeUpdate();
			System.out.println("회원정보를 추가했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {}
		}//finally
	}//insert()
}// class

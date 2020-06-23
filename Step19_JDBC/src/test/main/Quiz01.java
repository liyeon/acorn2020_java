package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Quiz01 {
	public static void main(String[] args) {
		/*
		 * 2, 해골, 행신동이라는 정보를 
		 * member table에 추가
		 */
		int num= 2;
		String name = "해골";
		String addr = "행신동";
		
		Connection conn = null;
		try {
			//오라클 오버라이딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB의 정보@아이피주소:port번호:db이름 형식
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			//계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "scott", "tiger");//비밀번호 다를 시 SQLException
			//예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
			System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();}
		
		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO MEMBER "
					+ " (num, name, addr)"
					+ " VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.executeUpdate();
			//여러번 업데이트 하면
			/*
			 * java.sql.SQLIntegrityConstraintViolationException: ORA-00001: 무결성 제약 조건(SCOTT.SYS_C004040)에 위배됩니다
			 * 발생
			 */
			System.out.println("회원정보가 업데이트되었습니다.");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
			} catch (Exception e) {}
			
		}//finally
		
	}//
}//

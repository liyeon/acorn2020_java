package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass04 {

	public static void main(String[] args) {
/*
 * 2번 회원의 이름을 원숭이로 수정하고자 한다.
 *
 */
		//DB 연결 객체를 담을 지역 변수 만들기
		Connection conn = null;//결국엔 커넥션객체의 참조값을 얻어옴
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
			e.printStackTrace();
		}//try~Catch 종료
		
		int num = 2;
		String name = "원숭이";
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE member"
					+ " SET name=?"
					+ " WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			System.out.println("회원정보를 수정했습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
			} catch (Exception e) {}
		}
		
	}//main 메소드 종료

	
}//MainClass04 종료

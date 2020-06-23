package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * 3번 회원을 삭제하는 코드를 작성해보세요
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
		//삭제할 회원의 번호
		int num = 3; 
		PreparedStatement pstmt = null;
		try {
			//실행할 ㅎsql문 //insert, update, delete 는 이런 패턴임 select 문은 result 문이 필요하다. result는 excuteQuery
			String sql = "DELETE FROM member"
					+ " WHERE NUM=?";
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩
			pstmt.setInt(1, num);
			//sql문 실행하기
			pstmt.executeUpdate();
			System.out.println("회원정보를 삭제했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
			} catch (Exception e) {}
		}
		
		
		
	}//main 메소드 종료
}//MainClass05 종료

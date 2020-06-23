package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 * member 테이블에 추가할 회원의 정보
		 * 1. 김구라, 노량진
		 */
		int num =1;
		String name = "김구라";
		String addr = "노량진";
		/*이 데이터를 오라클 db의 member table에 insert할것임
		 * 1.Connection
		 * 2.PreparedStatement // sql문을 대신 수행해줌
		 */
		
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
		
		//필요한 객체의 참조값을 담을 빈 지역 변수를 미리 만들기
		PreparedStatement pstmt = null;
		try {
			//실행할 sql문
			String sql = "INSERT INTO MEMBER "
					+ " (num, name, addr )" // 항상 한 칸씩 띄우기
					+ " VALUES(?, ?, ?)";//?표로 미완성의 sql문을 완성할수있다.
			//PreparedStatement 객체의 참조값얻어오기
			pstmt = conn.prepareStatement(sql);
			//?에 값을 바인딩해서 미완성의 sql문을 완성시킨다.
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			//실제로 수행하기
			pstmt.executeUpdate();
			System.out.println("회원정보를 저장 했습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//안전하게 마무리 작업하기
				if(pstmt!=null)pstmt.close();
			}catch (Exception e) {}//catch
		}//finally 종료
	}//main 메소드
}//MainClass

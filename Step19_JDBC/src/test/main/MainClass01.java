package test.main;

import java.sql.Connection;//인터페이스
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * JDBC (JAVA DataBase Connectivity)
 * 자바에서 데이터를 연결함
 * DataBase에 연결해서 SELECT, INSERT, UPDATE, DELETE 작업하기
 * 
 * Oracle에 연결하기 위해서는 드라이버 클래스가 들어있는 ojdbc6.jar 파일을 사용 할 수 있도록 설정해야 한다. //참조 라이브러리
 */
public class MainClass01 {
	public static void main(String[] args) {
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
		
		//SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역변수 만들기
		PreparedStatement pstmt = null; //인터페이스
		ResultSet rs = null;
		try {
			//실행할 sql문
			String sql = "SELECT num,name,addr FROM member " + " ORDER BY num ASC";
			//PreparedStatement 객체의 참조값얻어오기
			pstmt = conn.prepareStatement(sql);//실행할 sql문 준비 커넥션 객체의 메소드를 통해서 가져옴
			//PreparedStatement 객체를 이용해서 query문을 수행하고 결과를 ResultSet 객체로 받아오기
			rs=pstmt.executeQuery();//결과 데이터를 ResultSet으로 받아온다. 셀렉트문을 받아온다.
			while(rs.next()) {//ResultSet객체의 next 메소드 boolean타입 리턴 //false가 되면 반복문이 끝남
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				//출력하기
				System.out.println(num+" | " + name +" | " + addr);
			}//while
		}catch (Exception e) {e.printStackTrace();}//catch
		System.out.println("main메소드가 종료됩니다.");
	}//MAIN메소드
}//MAINCLASS
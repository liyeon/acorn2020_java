package test.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	//필드
	private Connection conn;
	
	//생성자에서 Connection 객체를 얻어와서 필드에 저장한다.
	public DBConnect() {
		try {
			//오라클 오버라이딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB의 정보@아이피주소:port번호:db이름 형식
			String url = "jdbc:oracle:thin:@localhost:1521:xe";//다른 곳에 있으면 아이피 주소를 정어도 된다. localhost는 내 컴퓨터 //xe 아니면 org
			//계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "scott", "tiger");//비밀번호 다를 시 SQLException
			//new 하는 시점에 오류가 없으면 connection객체에 참조값이 들어간다.
			//예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
			System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}//try~Catch 종료
	}
	//필드에 저장된 Connection 객체의 참조값을 리턴해주는 메소드
	public Connection getConn() {
		return conn;
		//new DBConnect().getConn(); Connection type의 참조값을 불러온다.
		//Connection conn = new new DBConnect().getConn()
	}
}

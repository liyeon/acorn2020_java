package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

/*
 * DAO(Data Access Object) 의 약자
 * DB에 insert, update, delete, select 메소드를 각각 만들어 쉽게 사용 할 수 있도록 한다.
 * - 만드는 방법
 * 1. 외부에서 객체를 생성하지 못하도록 생성자의 겁근지정자를 private로 지정
 * 2. 자신의 참조값을 저장 할 수 있는 필드를 private로 선언
 * 3. 자신의 참조값을 오직 하나만 생성해서 리턴해주는 static 메소드 만들기
 * 4. 나머지 기능(select, insert, update, delete)들은 non static 으로 만들기
 * 
 * 필요할 때마다 new를 해서 생성하는 것은 웹사이트를 만들때는 불 필요하다
 * getinstance는 한번만 생성되고 나머지는 다 메소드?로 사용한다.
 * db에 insert 막 넣을때 connection이 필요한데
 * connection이 무한하지 않고 많지 않다.
 * dao가 많이 만들어지면 conneciton이 부족한 경우가 생기기 때문에
 * dao를 static을 사용해서 한번만 생성되게 한다.
 */
public class MemberDao {
	//자신의 참조값을 저장할 private 필드
	private static MemberDao dao;
	//외부에서 객체를 생성하지 못하도록한다.
	private MemberDao() {}
	
	//참조값을 리턴해주는 메소드
	public static MemberDao getInstance() {//이전에 호출되었으면 null이 아니다. 처음 호출 했을 때만 new
		if(dao==null) {//최초 호출되면 null이므로 
			dao=new MemberDao();//객체를 생성해서 static 필드에 담는다.
		}
		return dao;
	}
	
	//회원 한명의 정보를 리턴해주는 메소드
	public MemberDto getData(int num) {
		//회원 한명의 정보를 담을 MemberDto
		MemberDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null; //인터페이스
		ResultSet rs = null;
		try {//DBConnect 객체를 이용해서 Connection 객체의 참조값을 얻어온다.
			conn = new DBConnect().getConn();//num은 인자로 전달돼서 필요없음
			String sql ="SELECT name,addr"
					   +" FROM member"
					   +" where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//MemberDto객체 생성해서
				dto=new MemberDto();
				//회원한명의 정보를 담는다.
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				
			}//while종료
			System.out.println("회원정보를 불러왔습니다.");
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {}
	}//finally
		return dto;
	}//getdata();
	
	//회원목록을 리턴해주는 메소드
	public List<MemberDto> getList(){
		//회원 목록을 담을 객체 생성
		List<MemberDto> list=new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//DBConnect 객체를 이용해서 Connection 객체의 참조값을 얻어온다.
			conn=new DBConnect().getConn();
			//실행할 sql 문
			String sql="SELECT num,name,addr"
					+ " FROM member"
					+ " ORDER BY num ASC";
			pstmt=conn.prepareStatement(sql);
			//query 문 수행하고 결과 얻어오기
			rs=pstmt.executeQuery();
			//반복문 돌면서 select 된 회원정보  읽어오기
			while(rs.next()) {
				//회원정보를 list 에 담아 보세요.
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				//MemberDto 객체를 생성해서 회원 한명의 정보를 담는다.
				MemberDto dto=new MemberDto();
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				//MemberDto 객체를 List 에 누적 시킨다.
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//객체를 사용했던 순서 역순으로 닫아준다.
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {}
		}//fianlly  종료
		
		return list;
	}//getList
	
	//회원 한명의 정보를 db에서 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String sql="DELETE FROM MEMBER"
					+ " WHERE NUM=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			flag = pstmt.executeUpdate();
			System.out.println("회원정보를 삭제했습니다.");
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {}
		}//finally
		
		if(flag>0) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	//회원 정보를 DB에 저장하는 메소드(잡업의 성공 여부가 boolean으로 리턴된다.)
	public boolean insert(MemberDto dto) {//인자로 dto를 전달 받음 //name, addr이 저장되어있는 dto를 전달 받아
		//작업에 성공하면 true, 아니면 false
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "INSERT INTO MEMBER "
					+ " (num, name, addr) "
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			//sql문을 수행하고 변화된 row의 갯수를 리턴받는다. (1)
			flag = pstmt.executeUpdate();//정수값을 리턴해줌
			//테이블의 수정된 로우의 개수(업데이트된 )로우의 개수를 리턴해준다.
			//한번에 다섯개 삭제되면(delete) 5가 리턴
			
			System.out.println("회원정보를 추가했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {}
		}//finally
		if(flag>0) {
			return true;//작업 성공이라는 의미에서 true를 리턴한다.
		}else {
			return false; //작업 실패라는 의미에서 false를 리턴한다.
		}
	}//insert
	
	//회원정보를 DB에서 수정하는 메소드
	public boolean update(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag=0;
		try {
			conn = new DBConnect().getConn();
			String sql = "UPDATE member"
					+ " SET name=?, addr=?"
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			//update된 row의 갯수가 반환된다.
			pstmt.executeUpdate();
			System.out.println("회원정보를 수정했습니다.");
		}catch (Exception e) {
		e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {}
		}//finally
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}//update 종료
	
}//class

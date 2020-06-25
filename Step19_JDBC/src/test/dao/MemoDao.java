package test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemoDto;
import test.util.DBConnect;

public class MemoDao {
	//참조값을 저장할 필드
	private static MemoDao dao;
	private MemoDao() {};
	
	public static MemoDao getInstance() {
		if(dao == null) {dao = new MemoDao();}
		return dao;
	}//getInstance()
	
	//SELECT, INSERT, UPDATE, DELETE
	
	public List<MemoDto> getList(){
		List<MemoDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			String sql = "SELECT num, content, TO_CHAR(regdate, 'YYYY\"년\"MM\"월\"DD\"일\" AM HH:MI') AS regdate"
					+ " FROM memo"
					+ " order by num asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String content = rs.getString("content");
				String regdate = rs.getString("regdate");
				
				MemoDto dto = new MemoDto();
				dto.setNum(num);
				dto.setContent(content);
				dto.setRegdate(regdate);
				
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {}
		}//finally
		return list;
	}//getList()
	
	
	
	public boolean insert(MemoDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "INSERT INTO MEMO "
					+ " (num, content, regdate) "
					+ " VALUES(memo_seq.NEXTVAL, ?, SYSDATE";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());
			flag = pstmt.executeUpdate();
			System.out.println("추가했습니다.");
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
	}//insert()
	
	public boolean update(MemoDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "UPDATE MEMO "
					+ " SET content=? "
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());
			pstmt.setInt(2, dto.getNum());
			flag = pstmt.executeUpdate();
			System.out.println("수정했습니다.");
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
	}//update()
	
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "DELETE FROM MEMO "
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			flag = pstmt.executeUpdate();
			System.out.println("삭제했습니다.");
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
	}//delete()
	
}//MemoDao

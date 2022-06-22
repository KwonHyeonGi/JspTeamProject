package cs.dit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import cs.dit.dto.FreeBoardDto;

public class FreeBoardDao {
	
	private DataSource ds;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public FreeBoardDao() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			ds=(DataSource)envContext.lookup("jdbc/ljmdb");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			if(con != null) {
				con.close();
				con=null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<FreeBoardDto> list() {
		String sql = "select* from freeboard";
		
		ArrayList<FreeBoardDto> dtos = new ArrayList<FreeBoardDto>();
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FreeBoardDto dto = new FreeBoardDto();
				dto.setTitle(rs.getString("title"));
				dto.setTextarea(rs.getString("textarea"));
				dto.setId(rs.getString("id"));
				dto.setDate(rs.getString("date"));
				dtos.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dtos;		
	}
	
	/*public FreeBoardDto selectOne(String title) {
		String sql = "select * From freeboard where title=?";
		FreeBoardDto dto = new FreeBoardDto();
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			)
		{
			pstmt.setString(1, title);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				rs.next();
				
				dto.setTitle(title);
				dto.setId(rs.getString("id"));
				dto.setDate(rs.getString("date"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	*/
	public String getDate() {
		//이건 mysql에서 현재의 시간을 가져오는 하나의 문장
		String sql = "SELECT NOW()";
		try {
			//각각 함수끼리 데이터 접근에 있어서 마찰방지용으로 내부 pstmt선언 (현재 연결된 객체를 이용해서 SQL문장을 실행 준비단계로 만들어준다.)
			PreparedStatement pstmt = con.prepareStatement(sql);
			//rs내부에 실제로 실행했을때 나오는 결과를 가져온다
			rs = pstmt.executeQuery();
			//결과가 있는경우는 다음과 같이 getString 1을 해서 현재의 그 날짜를 반환할 수 있게 해준다.
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			//오류 발생 내용을 콘솔에 띄움
			e.printStackTrace();
		}
		//데이터베이스 오류인데 웬만해선 디비오류가 날 이유가없기때문에 빈문장으로 넣어준다.
		return ""; 
	}
	
	public void insert(FreeBoardDto dto) {
		String sql = "insert into freeboard(title, id, textarea , date) values (?, ?, ?, ?)";
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getTextarea());
			pstmt.setString(4, getDate());
			
			pstmt.executeUpdate();
				
			} catch (SQLException ex) {
				
			}
	}
	public boolean update(FreeBoardDto dto) {
		String sql = "update freeboard set textarea = ?, date = ? where title =?";
		boolean check = false;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getTextarea());
			pstmt.setString(2, dto.getDate());
			pstmt.setString(3, dto.getTitle());
			
			int x = pstmt.executeUpdate();
			
			if(x < 1) {
				System.out.println("정상적으로 저장되지않았습니다.");
			}else {
				check=true;
			}
			pstmt.close();			
		}catch(SQLException ex) {
			System.out.println("SQL insert 오류 : " + ex.getLocalizedMessage());
			check=false;
		}
		return check;
	}
	
	public boolean delete(String title) {
		String sql = "delete from freeboard where title=?";
		boolean check = false;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			
			int x = pstmt.executeUpdate();
			if(x<1) {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}else {
				check = true;
			}
			pstmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL delete 오류 : " + ex.getLocalizedMessage());
			check=false;
		}
		return check;
	}
	
	public FreeBoardDto view(String title) {
		String sql = "select id,textarea, date from freeboard where title=?";
		FreeBoardDto dto = new FreeBoardDto();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setTitle(title);
				dto.setId(rs.getString("id"));
				dto.setTextarea(rs.getString("textarea"));		
				dto.setDate(rs.getString("date"));
			}
			rs.close();
			pstmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
}

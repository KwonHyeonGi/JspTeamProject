package cs.dit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import cs.dit.dto.InfBoardDto;

public class InfBoardDao {
	
	private DataSource ds;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public InfBoardDao() {
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
	
	public ArrayList<InfBoardDto> list() {
		String sql = "select* from infboard";
		
		ArrayList<InfBoardDto> dtos = new ArrayList<InfBoardDto>();
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				InfBoardDto dto = new InfBoardDto();
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				dto.setTextarea(rs.getString("textarea"));
				dto.setDate(rs.getString("date"));
				dto.setFilename(rs.getString("filename"));
				dtos.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dtos;		
	}
	
	
	public String getDate() {
		//�̰� mysql���� ������ �ð��� �������� �ϳ��� ����
		String sql = "SELECT NOW()";
		try {
			//���� �Լ����� ������ ���ٿ� �־ �������������� ���� pstmt���� (���� ����� ��ü�� �̿��ؼ� SQL������ ���� �غ�ܰ�� ������ش�.)
			PreparedStatement pstmt = con.prepareStatement(sql);
			//rs���ο� ������ ���������� ������ ����� �����´�
			rs = pstmt.executeQuery();
			//����� �ִ°��� ������ ���� getString 1�� �ؼ� ������ �� ��¥�� ��ȯ�� �� �ְ� ���ش�.
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			//���� �߻� ������ �ֿܼ� ���
			e.printStackTrace();
		}
		//�����ͺ��̽� �����ε� �����ؼ� �������� �� ���������⶧���� �������� �־��ش�.
		return ""; 
	}
	
	public void insert(InfBoardDto dto) {
		String sql = "insert into Infboard(title, id, textarea, date, filename) values (?, ?, ?, ?, ?)";
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getTextarea());
			pstmt.setString(4, getDate());
			pstmt.setString(5, dto.getFilename());
			
			pstmt.executeUpdate();
				
			} catch (SQLException ex) {
				
			}
	}
	public boolean update(InfBoardDto dto) {
		String sql = "update infboard set textarea = ?, filename=?, date = ? where title =?";
		boolean check = false;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getTextarea());
			pstmt.setString(2, dto.getFilename());
			pstmt.setString(3, dto.getDate());
			pstmt.setString(4, dto.getTitle());
			
			int x = pstmt.executeUpdate();
			
			if(x < 1) {
				System.out.println("���������� ��������ʾҽ��ϴ�.");
			}else {
				check=true;
			}
			pstmt.close();			
		}catch(SQLException ex) {
			System.out.println("SQL insert ���� : " + ex.getLocalizedMessage());
			check=false;
		}
		return check;
	}
	
	public boolean delete(String title) {
		String sql = "delete from infboard where title=?";
		boolean check = false;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			
			int x = pstmt.executeUpdate();
			if(x<1) {
				System.out.println("���������� �������� �ʾҽ��ϴ�.");
			}else {
				check = true;
			}
			pstmt.close();
		} catch (SQLException ex) {
			System.out.println("SQL insert ���� : " + ex.getLocalizedMessage());
			check=false;
		}
		return check;
	}
	
	public InfBoardDto view(String title) {
		String sql = "select textarea, filename, id, date from infboard where title=?";
		InfBoardDto dto = new InfBoardDto();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setTitle(title);
				dto.setTextarea(rs.getString("textarea"));
				dto.setFilename(rs.getString("filename"));
				dto.setId(rs.getString("id"));
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

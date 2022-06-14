package cs.dit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import cs.dit.dto.FreeBoardDto;

/**
 * 패키지명 : cs.dit
 * 파일명 : NoticeDao.java
 * 변경이력 :
 *
 * 프로젝트 설명 : DB연동 기능 구현
 *   
 *   
 */
public class FreeBoardDao {
	
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/KwonHyeonGi");
		Connection con = ds.getConnection();
		
		return con;
	}
	
	public ArrayList<FreeBoardDto> list() {
		String sql ="select id,title,txtarea,date,viewcount from notice";
		ArrayList<FreeBoardDto> dtos = new ArrayList<FreeBoardDto>();	
		
		try(
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				
			)	
		{
		
			while(rs.next()) {
				FreeBoardDto dto = new FreeBoardDto();
				
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setTxtarea(rs.getString("txtarea"));
				dto.setDate(rs.getString("date"));
				dto.setViewcount(rs.getInt("viewcount"));
				
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dtos;
	}
	
	public FreeBoardDto selectOne(String id) {
		String sql = "select * From notice where id=?";
		FreeBoardDto dto = new FreeBoardDto();
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			)
		{
			pstmt.setString(1, id);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				rs.next();
				
				dto.setId(id);
				dto.setTitle(rs.getString("title"));
				dto.setTxtarea(rs.getString("txtarea"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	
	public void insert(FreeBoardDto dto) {
		String sql = "insert into notice(id, title, txtarea, date, viewcount) values (?, ?, ?, sysdate, 0)";
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			) 
			{
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getTxtarea());
				pstmt.setString(4, dto.getDate());
				pstmt.setInt(5, dto.getViewcount());

				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public void update(FreeBoardDto dto) {
		String sql = "update notice set date = sysdate, title = ?, txtarea = ? where id =?";
		try(
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			)
		{

			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getTxtarea());
			pstmt.setString(3, dto.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String id) {
		String sql = "delete from notice where id=?";
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		) 
		{
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

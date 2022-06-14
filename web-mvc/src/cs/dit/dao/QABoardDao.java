package cs.dit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import cs.dit.dto.QABoardDto;

/**
 * ��Ű���� : cs.dit
 * ���ϸ� : NoticeDao.java
 * �����̷� :
 *
 * ������Ʈ ���� : DB���� ��� ����
 *   
 *   
 */
public class QABoardDao {
	
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/KwonHyeonGi");
		Connection con = ds.getConnection();
		
		return con;
	}
	
	public ArrayList<QABoardDto> list() {
		String sql ="select id,date,title,txtarea,viewcount from notice";
		ArrayList<QABoardDto> dtos = new ArrayList<QABoardDto>();	
		
		try(
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				
			)	
		{
		
			while(rs.next()) {
				QABoardDto dto = new QABoardDto();
				
				dto.setId(rs.getString("id"));
				dto.setDate(rs.getString("date"));
				dto.setTitle(rs.getString("title"));
				dto.setTxtarea(rs.getString("txtarea"));
				dto.setViewcount(rs.getInt("viewcount"));
				
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dtos;
	}
	
	public QABoardDto selectOne(String id) {
		String sql = "select * From notice where id=?";
		QABoardDto dto = new QABoardDto();
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
	
	
	public void insert(QABoardDto dto) {
		String sql = "insert into notice(id, date, title, txtarea, viewcount) values (?, sysdate, ?, ?, 0)";
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			) 
			{
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getDate());
				pstmt.setString(3, dto.getTitle());
				pstmt.setString(4, dto.getTxtarea());
				pstmt.setInt(5, dto.getViewcount());

				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public void update(QABoardDto dto) {
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

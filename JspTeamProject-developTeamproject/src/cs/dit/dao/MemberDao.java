package cs.dit.dao;

import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import cs.dit.dto.MemberDto;

public class MemberDao {
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/ljmdb");
		Connection con = ds.getConnection();
		return con;
	}
	public ArrayList<MemberDto> list() {
		String sql = "select id, pwd, name from member";
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		try(
				Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
			){
			while(rs.next()) {
				MemberDto dto= new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("pwd"));
				dto.setNickName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				
				dtos.add(dto);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return dtos;
	}
	public boolean checkUser(String id,String pwd) {
		String sql = "select pwd from member where id=? and pwd=?";
		boolean check = false;
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			)
		{
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			
			try(ResultSet rs = pstmt.executeQuery();) {
				if(rs.next()) {
					String userpwd = rs.getString("pwd");
					if(pwd.equals(userpwd)) {
						check = true;
					} else {
						check = false;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	public void insert(MemberDto dto) {
		String sql = "insert into member(id,pwd,name,email,hobby)values(?,?,?,?,?)";
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			) 
		{
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getNickName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getHobby());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public MemberDto selectone(String id) {
		String sql = "select * from member where id=?";
		MemberDto dto = new MemberDto();
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
				dto.setPassword(rs.getString("pwd"));
				dto.setNickName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setHobby(rs.getString("hobby"));
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	public String getid(String id) {
		String sql = "select id from member where id=?";
		String userok = null;
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			) 
		{
			pstmt.setString(1, id);
			
			try(ResultSet rs = pstmt.executeQuery();) 
			{
				if(rs.next()) {
					String userid = rs.getString("id");
					if(userid.equals(id)) {
						userok = userid;
					}
				}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userok;
	}
	public void update(MemberDto dto) {
		String sql = "update member set pwd = ?, name = ?, email = ? , hobby = ? where id = ?";
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			) 
		{
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getNickName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getHobby());
			pstmt.setString(5, dto.getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(String id,String pwd) {
		String sql = "delete from member where id = ? and pwd = ?";
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			) 
		{
			pstmt.setString(1, id);	
			pstmt.setString(2, pwd);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

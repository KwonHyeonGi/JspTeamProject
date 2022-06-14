package cs.dit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import cs.dit.dto.LoginDto;

/**
 * ��Ű���� : cs.dit
 * ���ϸ� : LoginDao.java
 * �����̷� :
 *
 * ������Ʈ ���� : DB���� ��� ����
 *   - list() : login ���̺��� ������ ȭ�鿡 ����� �� �ְ� �غ�
 *   - insert() : ������ �Էµ� �����͸� db�� ����
 *   - checkUser() : ��ȿ�� ����ڸ� 1, ��ȿ���� ���� ����ڸ� 0�� ��ȯ
 */
public class LoginDao {
	
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/KwonHyeonGi");
		Connection con = ds.getConnection();
		
		return con;
	}
	
	//db������ �Ͽ� login���̺��� record�� �����Ѵ�.
	public ArrayList<LoginDto> list() {
		String sql ="select id, pwd, name from Login";
		ArrayList<LoginDto> dtos = new ArrayList<LoginDto>();	
		
		try(
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				
			)	
		{
		
			while(rs.next()) {
				LoginDto dto = new LoginDto();
				
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dtos;
	}
	
	public LoginDto selectOne(String id) {
		String sql = "select * From login where id=?";
		LoginDto dto = new LoginDto();
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			)
		{ 	pstmt.setString(1, id);
			
			try(ResultSet rs = pstmt.executeQuery();)
			{
				rs.next();
				
				dto.setId(id);
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	// �޼ҵ� �ۼ� �� ����ؾ� �� ��
	// 1. public or private ����(Ŭ���� ���ο��� ����ϴ��� ���ϴ���)
	// 2. return(��ȯ��:output)
	// 3. �Ű������� �ִ°�?_?(input)
	// 3�� �����͸� �޾Ƽ� db�� �����Ѵ�.
	public void insert(LoginDto dto) {
		String sql = "insert into login(id, pwd, name) values(?, ?, ?)";
		try(
			Connection con = getConnection();
				//getConnection�� ����� ���� try&catch���� �ʿ��� -> ���⼭ try % rescource���� ���!
			PreparedStatement pstmt = con.prepareStatement(sql);
		) 
		{
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(LoginDto dto) {
		String sql = "update login set pwd = ?, name = ? where id =?";
		try(
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			)
		{
			pstmt.setString(1, dto.getPwd());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getId());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String id) {
		String sql = "delete from login where id=?";
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
	
	// �޼ҵ� �ۼ� �� ����l ��
	//1. pubilc / private ����
	//2. ��ȯ��(output)
	//3. �Ű�����(input)
	public int checkUser(String id, String pwd) {
		int check = 0;
		String sql = "select pwd from login where id=? and pwd=?";
		try(
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		)
		{
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			try(ResultSet rs = pstmt.executeQuery())
			{
				if(rs.next()) {
					check=1;
				}else {
					check=0;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}
}

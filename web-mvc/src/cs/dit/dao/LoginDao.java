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
 * 패키지명 : cs.dit
 * 파일명 : LoginDao.java
 * 변경이력 :
 *
 * 프로젝트 설명 : DB연동 기능 구현
 *   - list() : login 테이블의 내용을 화면에 출력할 수 있게 준비
 *   - insert() : 폼으로 입력된 데이터를 db에 저장
 *   - checkUser() : 유효한 사용자면 1, 유효하지 않은 사용자면 0로 반환
 */
public class LoginDao {
	
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/KwonHyeonGi");
		Connection con = ds.getConnection();
		
		return con;
	}
	
	//db연동을 하여 login테이블에서 record을 추출한다.
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
	// 메소드 작성 시 고려해야 할 것
	// 1. public or private 결정(클래스 내부에서 사용하는지 안하는지)
	// 2. return(반환값:output)
	// 3. 매개변수가 있는가?_?(input)
	// 3개 데이터를 받아서 db에 저장한다.
	public void insert(LoginDto dto) {
		String sql = "insert into login(id, pwd, name) values(?, ?, ?)";
		try(
			Connection con = getConnection();
				//getConnection을 사용할 때는 try&catch문이 필요함 -> 여기서 try % rescource문을 사용!
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
	
	// 메소드 작성 시 고려햘 점
	//1. pubilc / private 결정
	//2. 반환값(output)
	//3. 매개변수(input)
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

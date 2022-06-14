/**
 * 
 */
package cs.dit.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import cs.dit.dao.LoginDao;
import cs.dit.dto.LoginDto;

public class LoginInsertService implements LoginService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//1. �Է������� id�� name, pwd�� �����;���.		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		//2. id, name, pwd�� LoginDto�� ��������.
		LoginDto dto = new LoginDto(id, name, pwd);
		// Dto ���� ���� LoginDto�� String id~~ �ȰŰ� �־ �׳� �̷��� �ص���. �ؿ�ó�� ���ص��ȴٰ� �մϴ�//
		/*
		dto.setId(id);
		dto.setName(name);
		dto.setPwd(pwd);
		*/
		
		//3. Dao ��ü�� �����Ѵ�.
		LoginDao dao = new LoginDao();
		
		//4. insert(LoginDto)�� �����Ѵ�.(��ȯ�� ����)
		dao.insert(dto);
	}

}

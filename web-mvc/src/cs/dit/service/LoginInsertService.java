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

		//1. 입력폼에서 id와 name, pwd를 가져와야함.		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		//2. id, name, pwd를 LoginDto로 만들어야함.
		LoginDto dto = new LoginDto(id, name, pwd);
		// Dto 가서 보면 LoginDto에 String id~~ 된거가 있어서 그냥 이렇게 해도됨. 밑에처럼 안해도된다고 합니다//
		/*
		dto.setId(id);
		dto.setName(name);
		dto.setPwd(pwd);
		*/
		
		//3. Dao 객체를 생성한다.
		LoginDao dao = new LoginDao();
		
		//4. insert(LoginDto)를 실행한다.(반환값 없음)
		dao.insert(dto);
	}

}

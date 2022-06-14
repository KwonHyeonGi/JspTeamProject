package cs.dit.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.dao.LoginDao;
import cs.dit.dto.LoginDto;

public class LoginListService implements LoginService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. DB 객체 생성
		LoginDao dao = new LoginDao();
		
		//2. DB 메소드 실행과 결과값 저장
		ArrayList<LoginDto> dtos = dao.list();
		
		//3. ReqeustScope에 반환값 저장
		request.setAttribute("dtos", dtos);
	}

}

package cs.dit.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.dao.FreeBoardDao;
import cs.dit.dto.FreeBoardDto;


public class FreeBoardListService implements FreeBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. DB ��ü ����
		FreeBoardDao dao = new FreeBoardDao();
		
		//2. DB �޼ҵ� ����� ����� ����
		ArrayList<FreeBoardDto> dtos = dao.list();
		
		//3. ReqeustScope�� ��ȯ�� ����
		request.setAttribute("dtos", dtos);
	}

}

package cs.dit.command.FreeBoardservice;

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
		request.setCharacterEncoding("UTF-8");

		FreeBoardDao dao = new FreeBoardDao();
		
		ArrayList<FreeBoardDto> dtos = dao.list();
		
		request.setAttribute("dtos", dtos);
		
	}

}

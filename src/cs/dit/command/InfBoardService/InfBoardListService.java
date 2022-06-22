package cs.dit.command.InfBoardService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.dao.InfBoardDao;
import cs.dit.dto.InfBoardDto;

public class InfBoardListService implements InfBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		InfBoardDao dao = new InfBoardDao();
		ArrayList<InfBoardDto> dtos = dao.list();
		request.setAttribute("dtos", dtos);
	}

}

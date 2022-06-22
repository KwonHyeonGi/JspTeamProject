package cs.dit.command.InfBoardService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.dao.FreeBoardDao;
import cs.dit.dao.InfBoardDao;
import cs.dit.dto.FreeBoardDto;
import cs.dit.dto.InfBoardDto;

public class InfBoardUpdateService implements InfBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String text = request.getParameter("textarea");
		String nowdate = simpleDateFormat.format(date);
		String files = request.getParameter("uploadfiles");
		String title = request.getParameter("title");
		InfBoardDto dto = new InfBoardDto(text,nowdate,files,title);
		
		InfBoardDao dao = new InfBoardDao();
		dao.update(dto);
	}
	
}

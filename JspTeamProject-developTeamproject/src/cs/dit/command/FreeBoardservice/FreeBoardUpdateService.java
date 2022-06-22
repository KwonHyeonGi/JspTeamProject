package cs.dit.command.FreeBoardservice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.dao.FreeBoardDao;
import cs.dit.dto.FreeBoardDto;

public class FreeBoardUpdateService implements FreeBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String nowdate = simpleDateFormat.format(date);
		String text = request.getParameter("textarea");
		String title = request.getParameter("title");
		FreeBoardDto dto = new FreeBoardDto(text,nowdate,title);
		
		FreeBoardDao dao = new FreeBoardDao();
		dao.update(dto);
	}
}

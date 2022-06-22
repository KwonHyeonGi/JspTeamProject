package cs.dit.command.FreeBoardservice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs.dit.dao.FreeBoardDao;
import cs.dit.dto.FreeBoardDto;

public class FreeBoardInsertService implements FreeBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String nowdate = simpleDateFormat.format(date);
		
		String title = request.getParameter("title");
		String textarea = request.getParameter("textarea");
		String id = (String)session.getAttribute("userid");
		
		FreeBoardDto dto = new FreeBoardDto(title,id,textarea,nowdate);
		FreeBoardDao dao = new FreeBoardDao();
		
		dao.insert(dto);
	}

}

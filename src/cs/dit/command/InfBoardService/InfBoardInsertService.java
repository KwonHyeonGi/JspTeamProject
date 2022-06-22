package cs.dit.command.InfBoardService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs.dit.dao.InfBoardDao;
import cs.dit.dto.InfBoardDto;

public class InfBoardInsertService implements InfBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String title = request.getParameter("title");
		String id = (String)session.getAttribute("userid");
		String textarea = request.getParameter("textarea");
		String files = request.getParameter("uploadfiles");
		String nowdate = simpleDateFormat.format(date);

		
		InfBoardDto dto = new InfBoardDto(title,id,textarea,nowdate,files);
		
		InfBoardDao dao = new InfBoardDao();
		dao.insert(dto);
	}

}

package cs.dit.command.FreeBoardservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs.dit.dao.FreeBoardDao;
import cs.dit.dao.MemberDao;
import cs.dit.dto.FreeBoardDto;

public class FreeBoardViewService implements FreeBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		
		FreeBoardDao dao = new FreeBoardDao();
		
		FreeBoardDto dto = dao.view(title);
		
		request.setAttribute("dto", dto);
		
		String id = (String)session.getAttribute("userid");
		
		MemberDao daos = new MemberDao();
		
		String checked = daos.getid(id);
		
		if(checked != null) {
			session.setAttribute("checkid", checked);
		}
	}

}

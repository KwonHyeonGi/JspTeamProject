package cs.dit.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs.dit.dao.MemberDao;
import cs.dit.dto.MemberDto;

public class selectoneLogin implements LogSerivce {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("userid");
		
		MemberDto dto = new MemberDto();
		MemberDao dao = new MemberDao();
		
		dto = dao.selectone(id);
		
		session.setAttribute("dtos", dto);
	}	
}

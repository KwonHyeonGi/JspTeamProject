package cs.dit.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.dao.MemberDao;
import cs.dit.dto.MemberDto;

public class updateLogin implements LogSerivce {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("ids");
		String pwd = request.getParameter("pwds");
		String name = request.getParameter("names");
		String email = request.getParameter("emails");
		String hobby = request.getParameter("hobbys");
		
		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto(id,pwd,name,email,hobby);
		
		dao.update(dto);
	}
	
}

package cs.dit.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs.dit.dao.MemberDao;
import cs.dit.dto.MemberDto;

public class deleteLogin implements LogSerivce {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberDto dto = (MemberDto)session.getAttribute("dtos");
		MemberDao dao = new MemberDao();
		dao.delete(dto.getId(), dto.getPassword());
	}
	
}

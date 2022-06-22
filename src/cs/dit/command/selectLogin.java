package cs.dit.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs.dit.dao.MemberDao;

public class selectLogin implements LogSerivce {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id_text");
		String pwd = request.getParameter("pwd_text");
		
		MemberDao dao = new MemberDao();
		boolean check = dao.checkUser(id, pwd);
		
		if(check == true) {
			HttpSession session = request.getSession();
			session.setAttribute("userid", id);
			session.setAttribute("check", check);
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("check", check);	
		}
		
	}
	
}

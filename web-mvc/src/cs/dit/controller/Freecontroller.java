package cs.dit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.service.FreeBoardInsertService;
import cs.dit.service.FreeBoardListService;
import cs.dit.service.FreeBoardService;

@WebServlet("*.do")
public class Freecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".do"));
		String page = null;
		
		if(com != null && com.trim().equals("list")) {
			FreeBoardListService service = new FreeBoardListService();
			service.execute(request, response);
			
			page="/WEB-INF/view/FreeBoardList.jsp";
		}else if(com != null && com.trim().equals("FreeBoardInsertForm")) {
			// "/WEB=INF/view/list.jsp" �� �κ��� view ������ Form���� �־��µ�, �̰� web-inf�� �־����ϱ� �ܺο��� ����. �ٵ� �̷����ϸ� �ܺο��� �� �� �ִٰ� �ϳ׿�~~
			
			page="/WEB-INF/view/FreeBoardInsertInsertForm.jsp";
		}else if(com != null && com.trim().contentEquals("insert")) {
			FreeBoardService service = new FreeBoardInsertService();
			service.execute(request, response);
			page="FreeBoardlist.do";
		}else if(com != null && com.trim().contentEquals("udapte")) {
			
		}
		
		// �� �κ��� ���ؼ� requestScope�� controller�� list�� �����ִ°���
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

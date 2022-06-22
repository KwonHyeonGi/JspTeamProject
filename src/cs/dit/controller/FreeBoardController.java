package cs.dit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.command.FreeBoardservice.*;


@WebServlet("*.fr")

public class FreeBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".fr"));
		String page = null;
		
		if(com != null && com.trim().equals("FreeBoardList")) {
			FreeBoardListService service = new FreeBoardListService();
			service.execute(request, response);
			page="FreeBoardList.jsp";
			
		}else if(com != null && com.trim().equals("FreeBoardInsertForm")) {
			page="FreeBoardInsertForm.jsp";
			
		}else if(com != null && com.trim().contentEquals("insert")) {
			FreeBoardInsertService service = new FreeBoardInsertService();
			service.execute(request, response);
			
			page="FreeBoardList.fr";
			
		}else if(com != null && com.trim().equals("view")){
			FreeBoardViewService service = new FreeBoardViewService();
			service.execute(request, response);
			page = "FreeBoardView.jsp";
			
		}else if(com != null && com.trim().contentEquals("delete")) {
			FreeBoardDeleteService service = new FreeBoardDeleteService();
			service.execute(request, response);
			page = "FreeBoardList.jsp";
		}else if(com != null && com.trim().equals("update")){
			FreeBoardUpdateService service = new FreeBoardUpdateService();
			service.execute(request, response);
			page = "FreeBoardList.jsp";
		}else if(com != null && com.trim().equals("updateview")){
			FreeBoardViewService service = new FreeBoardViewService();
			service.execute(request, response);
			page = "FreeBoardUpdate.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

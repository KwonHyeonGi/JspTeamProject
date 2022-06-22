package cs.dit.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cs.dit.command.InfBoardService.*;
import cs.dit.dao.InfBoardDao;
import cs.dit.dto.InfBoardDto;

@MultipartConfig(
		maxFileSize = -1,
		maxRequestSize = -1
)


@WebServlet("*.in")

public class InfBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		InfBoardDao dao = new InfBoardDao();
		InfBoardDto dto = new InfBoardDto();
		
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".in"));
		String page = null;
		
		if(com != null && com.trim().equals("InfBoardList")) {
			InfBoardListService service = new InfBoardListService();
			service.execute(request, response);
			page="InfBoardList.jsp";
			
		}else if(com != null && com.trim().equals("InfBoardInsertForm")) {
			page="InfBoardInsertForm.jsp";
			
		}else if(com != null && com.trim().contentEquals("insert")) {
			InfBoardInsertService service = new InfBoardInsertService();
			service.execute(request, response);
			
			page="InfBoardList.in";
			
		}else if(com != null && com.trim().equals("view")){
			InfBoardViewService service = new InfBoardViewService();
			service.execute(request, response);
			page = "InfBoardView.jsp";
			
		}else if(com != null && com.trim().contentEquals("delete")) {
			InfBoardDeleteService service = new InfBoardDeleteService();
			service.execute(request, response);
			page = "InfBoardList.jsp";
		}else if(com != null && com.trim().contentEquals("list")) {
			ArrayList<InfBoardDto> dtos = dao.list();
			request.setAttribute("dtos", dtos);
			page = "InfBoardView.jsp";
		}else if(com != null && com.trim().contentEquals("updateview")) {
			InfBoardViewService service = new InfBoardViewService();
			service.execute(request, response);
			page = "InfBoardUpdate.jsp";
		}else if(com != null && com.trim().contentEquals("update")) {
			InfBoardUpdateService service = new InfBoardUpdateService();
			service.execute(request, response);
			page = "InfBoardList.jsp";
		}else if(com != null && com.trim().equals("upload")) {
			String contentType = request.getContentType();
			if(contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
				String dir = request.getServletContext().getRealPath("/uploadfiles");
				
				File f = new File(dir);
				if(!f.exists()) {
					f.mkdirs();
				}
				Collection<Part> parts = request.getParts();
				
				for(Part p : parts) {
					if(p.getHeader("Content-Disposition").contains("filename=")) {
						
						if(p.getSize()>0) {
							String filename = p.getSubmittedFileName();
							String filePath = dir + File.separator + filename;
							p.write(filePath);
							p.delete();
					}
				}
			}
			String title = request.getParameter("title");
			String textarea = request.getParameter("textarea");
			String filename = request.getParameter("filename");
			String id = request.getParameter("id");
			String date = request.getParameter("date");
			dao.insert(dto);
		}		
		ArrayList<InfBoardDto> dtos = dao.list();
		request.setAttribute("dtos", dtos);
		page = "InfBoardView.jsp";
	}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

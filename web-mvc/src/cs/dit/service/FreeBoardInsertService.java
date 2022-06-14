/**
 * 
 */
package cs.dit.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import cs.dit.dao.FreeBoardDao;
import cs.dit.dto.FreeBoardDto;

public class FreeBoardInsertService implements FreeBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String txtarea = request.getParameter("txtarea");
		String date = request.getParameter("date");
		int viewcount = Integer.parseInt(request.getParameter("viewcount"));
		
		FreeBoardDto dto = new FreeBoardDto(id, title, txtarea, date, viewcount);

		FreeBoardDao dao = new FreeBoardDao();
		
		dao.insert(dto);
	}

}

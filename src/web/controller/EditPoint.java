package web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PointBusinessService;
import service.impl.PointBusinessServiceImpl;
import utils.WebUtils;
import domain.Point;

public class EditPoint extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		PointBusinessService service = new PointBusinessServiceImpl();
		Point point = service.findPoint(id);
		request.setAttribute("point", point);
		request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		String author = request.getParameter("author");
		Date postTime = new Date();
		String id = request.getParameter("id");

		Point p = new Point();
		p.setTitle(title);
		p.setId(Integer.parseInt(id));
		p.setAuthor(author);
		p.setPostTime(postTime);
		p.setText(text);
		

		PointBusinessService service = new PointBusinessServiceImpl();
		service.updatePoint(p);

		request.setAttribute("message", "±à¼­³É¹¦£¡");
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(
				request, response);

	}

}

package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PointBusinessService;
import service.impl.PointBusinessServiceImpl;
import domain.Point;

public class Detail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		PointBusinessService service = new PointBusinessServiceImpl();
		Point point = service.findPoint(id);
		request.setAttribute("point", point);
		request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}

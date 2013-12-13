package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PointBusinessService;
import service.impl.PointBusinessServiceImpl;
import domain.Point;

public class ViewServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PointBusinessService service = new PointBusinessServiceImpl();
				
		List<Point> list = service.getAll();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/show.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}

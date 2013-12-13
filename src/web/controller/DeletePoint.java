package web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PointBusinessService;
import service.impl.PointBusinessServiceImpl;
import Exception.PointExistException;

public class DeletePoint extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		PointBusinessService service = new PointBusinessServiceImpl();
		
		String message;
		try {
			service.delete(id);
			request.setAttribute("message",	"删除成功！");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", "服务器出现未知错误！");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		} 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}

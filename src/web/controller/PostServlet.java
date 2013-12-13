package web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.PointExistException;

import service.PointBusinessService;
import service.impl.PointBusinessServiceImpl;
import domain.Point;
import domain.User;

public class PostServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		
		User user = (User) request.getSession().getAttribute("user");
		String username = user.getUsername();
		Point p = new Point();

		p.setAuthor(username);
		p.setPostTime(new Date());
		p.setTitle(title);
		p.setText(text);
		
		PointBusinessService service = new PointBusinessServiceImpl();
		
		String message;
		try {
			service.post(p);
			request.setAttribute("message",	"发布成功！");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", "服务器出现未知错误！");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		} catch (PointExistException e) {
			message = "热点已经存在！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}

package web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserBusinessService;
import service.impl.UserBusinessServiceImpl;
import domain.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserBusinessService service = new UserBusinessServiceImpl();
		User user;

		try {
			user = service.login(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", "服务器出现未知错误！");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		}
		
		if(user != null){
			request.getSession().setAttribute("user", user);
			request.setAttribute("message", "登录成功！");
			if ("0".equals(user.getFlag())) {
				request.getSession().setAttribute("admin", user);
			}
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		}
		
		request.setAttribute("message", "用户名或密码错误！！");
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}

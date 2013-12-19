package web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserBusinessService;
import service.impl.UserBusinessServiceImpl;
import utils.WebUtils;
import web.form.RegisterForm;

import Exception.UserExistException;

import com.sun.org.apache.commons.beanutils.BeanUtils;

import domain.User;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
			boolean b = form.validate();
			
			if (!b) {
				request.setAttribute("form", form);
				request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
				return;
			}
			
			
			String client_checkcode = request.getParameter("client_checkcode");
			String checkCode = ((String) request.getSession().getAttribute("checkcode"));
			if (client_checkcode == null || !client_checkcode.equals(checkCode)) {
				request.setAttribute("message",
						"验证码错误！");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				return;
			}
			
			User user = new User();
			BeanUtils.copyProperties(user, form);
			
			UserBusinessService service = new UserBusinessServiceImpl();
			
			String message = null;
			try {
				service.register(user);
				//<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/index.jsp'>
				request.setAttribute("message",
						"恭喜您，注册成功！");
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				return;
			} catch (UserExistException e) {
				form.getErrors().put("username", "用户名已经存在!");
				request.setAttribute("form", form);
				request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "服务器出现未知错误！");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				return;
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}

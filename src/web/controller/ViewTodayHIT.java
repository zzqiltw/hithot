package web.controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewTodayHIT extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		URL url =  new URL("http://today.hit.edu.cn/depart/14.htm");
		URLConnection conn = url.openConnection();
		
		InputStream in = conn.getInputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		String s1 = "<div id='content' class='newsList'>";
		int flag = 0;
		String s2 = null;
		String s3 = "";
		
		PrintWriter out = response.getWriter();
       
		
		while ((s2 = reader.readLine())!=null && flag != 2) {
			if (s2.contains(s1)) {
				s3 += s2.substring(s2.indexOf(s1));
				flag = 1;
			}
			
			if (1 == flag) {
				s3 += s2;
			}
			
			if (s2.contains("</li></ul></div>")) {
				flag = 2;
			}
		}
			
		request.setAttribute("result", s3);
		request.getRequestDispatcher("/WEB-INF/jsp/showToday.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}

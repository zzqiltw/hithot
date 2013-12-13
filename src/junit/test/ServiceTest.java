package junit.test;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import Exception.PointExistException;
import Exception.UserExistException;

import service.PointBusinessService;
import service.UserBusinessService;
import service.impl.PointBusinessServiceImpl;
import service.impl.UserBusinessServiceImpl;

import dao.impl.PointDaoImpl;
import domain.Point;
import domain.User;

public class ServiceTest {
	@Test
	public void testRegister() {
		User user = new User();
		user.setId(500);
		user.setUsername("ppp");
		user.setPassword("ppppp");
		user.setEmail("pp@pp.com");
		user.setFlag("1");
		
		UserBusinessService service = new UserBusinessServiceImpl();
		try {
			service.register(user);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLogin() {
		String username = "newzzqiuii";
		String password = "newzzqisuii";
		
		UserBusinessService service = new UserBusinessServiceImpl();
		try {
			User user = service.login(username, password);
			System.out.println(user.getEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	@Test
	public void testPost() {
		Point p = new Point();
		p.setId(1322);
		p.setAuthor("zzzsdfz");
		p.setPostTime(new Date());
		p.setTitle("tessdft");
		p.setText("sdfsdfssdfdfsdfsdf");
		
		PointBusinessService service = new PointBusinessServiceImpl();
		try {
			service.post(p);
		} catch (PointExistException e) {
			System.out.println("帖子未能成功发表");
		} catch (Exception e1) {
			
		}
	}
	
	@Test
	public void delete() {
		PointBusinessService service = new PointBusinessServiceImpl();
		try {
			service.delete(1322);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

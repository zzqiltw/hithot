package junit.test;

import java.sql.SQLException;

import org.junit.Test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;

public class UserDaoTest {
	@Test
	public void testAdd() {
		User user = new User();
		user.setId(50);
		user.setUsername("zzq");
		user.setPassword("zzq");
		user.setEmail("zzq@gmail.com");
		user.setFlag("0");
		
		UserDao dao = new UserDaoImpl();
		dao.add(user);
		
		
	}
	
	@Test
	public void testFind1() {
		String username = "newzsdfszqisuii";
		String password = "newzzqiuii";
		UserDao dao = new UserDaoImpl();
		User user = null;
		try {
			user = dao.find(username, password);
			System.out.println(user.getEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testFind2() {
		String username = "newzsdfszqiuii";
		UserDao dao = new UserDaoImpl();
		try {
			System.out.println(dao.find(username));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

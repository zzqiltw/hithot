package junit.test;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import utils.ServiceUtils;
import dao.PointDao;
import dao.impl.PointDaoImpl;
import domain.Point;

public class PointDaoTest {
	@Test
	public void testAdd() {
		Point p = new Point();
		p.setId(132);
		p.setAuthor("zzzz");
		p.setPostTime(new Date());
		p.setTitle("test");
		p.setText("sdfsdfsdfsdfsdf");
		
		PointDao dao = new PointDaoImpl();
		try {
			dao.add(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete() {
		PointDao dao = new PointDaoImpl();
		try {
			dao.delete(132);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

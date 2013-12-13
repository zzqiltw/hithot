package service.impl;

import java.sql.SQLException;
import java.util.List;

import service.PointBusinessService;
import utils.DatabaseUtils;
import Exception.PointExistException;
import dao.PointDao;
import dao.impl.PointDaoImpl;
import domain.Point;

public class PointBusinessServiceImpl implements PointBusinessService {
	private PointDao dao = new PointDaoImpl();
	
	@Override
	public void post(Point p) throws SQLException, PointExistException {
		if (dao.add(p)) {
			DatabaseUtils.close();
		} else {
			throw new PointExistException(); 
		}
	}
	
	@Override
	public void delete(int id) throws SQLException {
		if (dao.delete(id) != 0) {
			DatabaseUtils.close();
		}
	}
	
	public List<Point> getAll() {
		return dao.getAll();
	}
	
	public Point findPoint(String id) {
		return dao.findPoint(id);
	}
	
	public void updatePoint(Point p) {
		dao.update(p);
	}
}

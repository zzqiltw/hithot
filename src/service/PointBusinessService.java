package service;

import java.sql.SQLException;
import java.util.List;

import Exception.PointExistException;
import domain.Point;

public interface PointBusinessService {

	public abstract void post(Point p) throws SQLException, PointExistException;

	public abstract void delete(int id) throws SQLException;

	public abstract List<Point> getAll();

	public abstract Point findPoint(String id);
	
	public abstract void updatePoint(Point p);

}
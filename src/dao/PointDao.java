package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Point;

public interface PointDao {

	public abstract boolean add(Point p) throws SQLException;

	public abstract int delete(int id) throws SQLException;

	public abstract List<Point> getAll();

	public abstract Point findPoint(String id);

	public abstract int update(Point p);

}
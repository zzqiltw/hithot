package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utils.DatabaseUtils;
import dao.PointDao;
import domain.Point;

public class PointDaoImpl implements PointDao {
	/* (non-Javadoc)
	 * @see dao.impl.PointDao#add(domain.Point)
	 */
	@Override
	public boolean add(Point p) throws SQLException {
		boolean b;
		String sql = "insert into point values (?,?,?,?,?)";
		b = DatabaseUtils.insert(sql, null, p.getAuthor(), p.getPostTime(), p.getTitle(), p.getText());
		return b;
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.PointDao#delete(int)
	 */
	@Override
	public int delete(int id) throws SQLException {
		
		String sql = "delete from point where id = ?";
		
		return DatabaseUtils.delete(sql, id);
	}
	
	public List<Point> getAll() {
		
		String sql = "select * from point";
		List<Point> list = new ArrayList<Point>();
		try {
			ResultSet rs = DatabaseUtils.select(sql);
			
			while (rs.next()) {
				Point point = new Point();
				point.setId(rs.getInt("id"));
				point.setAuthor(rs.getString("author"));
				point.setPostTime(rs.getDate("postTime"));
				point.setTitle(rs.getString("title"));
				point.setText(rs.getString("text"));
				list.add(point);
			}
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Point findPoint(String id) {
		String sql = "select * from point where id = ?";
		
		try {
			ResultSet rs = DatabaseUtils.select(sql, id);
			
			if (rs.next()) {
				Point point = new Point();
				point.setId(rs.getInt("id"));
				point.setAuthor(rs.getString("author"));
				point.setPostTime(rs.getDate("postTime"));
				point.setTitle(rs.getString("title"));
				point.setText(rs.getString("text"));
				return point;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int update(Point p) {
		String sql = "update point set title = ?, text = ?, postTime = ? where id = ?";
		
		try {
			return DatabaseUtils.update(sql, p.getTitle(), p.getText(), new Date(), p.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	
	
	
}

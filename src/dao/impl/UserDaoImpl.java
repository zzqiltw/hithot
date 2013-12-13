package dao.impl;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ServiceUtils;
import utils.DatabaseUtils;
import dao.UserDao;
import domain.User;

public class UserDaoImpl implements UserDao {
	
	/* (non-Javadoc)
	 * @see dao.impl.UserDaoInterface#add(domain.User)
	 */
	@Override
	public boolean add(User user) {
		//int id = user.getId();
		String username = user.getUsername();
		String password = user.getPassword();
		
		String email = user.getEmail();		
		
		String sql = "insert into user values (?,?,?,?,?)";
		
		try {
			boolean b = DatabaseUtils.insert(sql, null, username, password, email, "1");
			return b;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.UserDaoInterface#find(java.lang.String, java.lang.String)
	 */
	@Override
	public User find(String username, String password) throws SQLException {
				
		String sql = "select * from user where username = ? and password = ?";

		ResultSet rs = DatabaseUtils.select(sql, username, password);

		User user = null;
		
		while (rs.next()) {
			user = new User();
			user.setId(rs.getInt(1));
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(rs.getString("email"));
			user.setFlag(rs.getString("flag"));
			
		}
		return user;
		
		
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.UserDaoInterface#find(java.lang.String)
	 */
	@Override
	public boolean find(String username) throws SQLException {

		String sql = "select * from user where username = ?";
		ResultSet rs = DatabaseUtils.select(sql, username);
		User user = new User();
		
		if (rs.next()) {
			
			return true;
		}

		return false;
		
		
	}

}

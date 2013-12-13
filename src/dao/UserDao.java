package dao;

import java.sql.SQLException;

import domain.User;

public interface UserDao {

	public abstract boolean add(User user);

	public abstract User find(String username, String password)
			throws SQLException;

	public abstract boolean find(String username) throws SQLException;

}
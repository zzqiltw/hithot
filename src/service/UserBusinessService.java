package service;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import Exception.UserExistException;
import domain.User;

public interface UserBusinessService {

	public abstract void register(User user) throws NoSuchAlgorithmException,
			SQLException, UserExistException;

	public abstract User login(String username, String password)
			throws SQLException;

}
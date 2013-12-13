package service.impl;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import Exception.UserExistException;

import service.UserBusinessService;
import utils.DatabaseUtils;
import utils.ServiceUtils;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;

public class UserBusinessServiceImpl implements UserBusinessService {
	private UserDao dao = new UserDaoImpl();
	
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#register(domain.User)
	 */
	@Override
	public void register(User user) throws NoSuchAlgorithmException, SQLException, UserExistException {
		if (!dao.find(user.getUsername())) {
			user.setPassword(ServiceUtils.getMd5(user.getPassword()));
			dao.add(user);
		} else {
			throw new UserExistException();
		}
	}
	
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User login(String username, String password) throws SQLException {
		try {
			password = ServiceUtils.getMd5(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		User user = dao.find(username, password);
		
		return user;
	}
}

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtils {
	private static String user = "root";
	private static String password = "root";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/hithot";
	
	private static Connection conn = null;
	
	static {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	public static void close() throws SQLException {
		if (conn != null && conn.isClosed()) {
			conn.close();
		}
	}
	
	public static ResultSet select(String sql, Object...args) throws SQLException {
		ResultSet rd = null;
		
		PreparedStatement cmd = conn.prepareStatement(sql);
		
		for (int i = 0; i < args.length; ++i) {
			cmd.setObject(i + 1, args[i]);
		}
		
		rd = cmd.executeQuery();
		
		return rd;
	}
	
	public static boolean insert(String sql, Object...args) throws SQLException {
		PreparedStatement cmd = conn.prepareStatement(sql);
		
		for (int i = 0; i < args.length; ++i) {
			cmd.setObject(i + 1, args[i]);
		}
		
		boolean isOk = true;
		if (cmd.executeUpdate() != 1) {
			isOk = false;
		}
		
		return isOk;
	}
	
	public static int update(String sql, Object ... args) throws Exception {
		PreparedStatement cmd = conn.prepareStatement(sql);
		
		for (int i = 0; i < args.length; ++i) {
			cmd.setObject(i + 1, args[i]);
		}
		
		return cmd.executeUpdate();
	}
	
	public static int delete(String sql, Object ... args) throws SQLException {
		PreparedStatement cmd = conn.prepareStatement(sql);
		
		for (int i = 0; i < args.length; ++i) {
			cmd.setObject(i + 1, args[i]);
		}
		
		return cmd.executeUpdate();
	}
}

package agenda2.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabaseConnection implements IConnection{

	private final String USER = "root";
	private final String PASSWORD = "root!@#";
	private final String ADDRESS = "localhost";
	private final String PORT = "3306";
	private final String DATABASE = "agenda2";
	
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://"+ADDRESS+":"+PORT+"/"+DATABASE, USER, PASSWORD);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}

package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/concessionaria?useTimezone=true&serverTimezone=UTC","root","root"); 
	}
}

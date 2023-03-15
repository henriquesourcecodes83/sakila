package javawebappconnection.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
public Connection getConnection() {
		
		Connection connection = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sakila", "root", "root");
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return connection;
	}
}

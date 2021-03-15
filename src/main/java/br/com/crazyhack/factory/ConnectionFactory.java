package br.com.crazyhack.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		//String driverName = "org.gjt.mm.mysql.Driver";
		String driverName = "com.mysql.cj.jdbc.Driver";
		Class.forName(driverName);
		String serverName = "localhost";
		String mydatabase = "crazyhack";
		String url = "jdbc:mysql://" + serverName + ":3306/" + mydatabase;
		String username = "root";
		String password = "secreta";
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
}
package com.revature;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private Connection connection;
	private String url;
	private String user;
	private String password;
	
	
	ConnectionUtil() {
		try {
			Properties properties = new Properties();
			properties.load(new FileReader("connection.properties"));
			this.url = properties.getProperty("url");
			this.user = properties.getProperty("user");
			this.password = properties.getProperty("password");
			this.connection = DriverManager.getConnection(this.url,this.user,this.password);
		}
		catch(SQLException e) {
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getconnection() {
		return connection;
	}
	
	public void close() {
		try {
			this.connection.close();
		}
		catch(SQLException e) {	
		}
	}
}

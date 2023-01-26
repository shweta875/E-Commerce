package com.velocity.miniproject.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataBaseConnection {
	
	Connection con=null;
	
	public Connection getConnectionDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
			
		} catch (Exception e) {
			e.printStackTrace();
			}
		return con;
	}
	
	

}

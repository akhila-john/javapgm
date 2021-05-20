package com.services.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

static Connection conn = null;
	
	private GetConnection()  {
		
	}
	
	public static Connection GetConnection()  {
		try {
			if(conn==null)  {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/institution","root","akhila8mysql");
				conn.setAutoCommit(false);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
		
		return conn;
}
}

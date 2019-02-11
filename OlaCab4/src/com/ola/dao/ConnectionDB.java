package com.ola.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	
	static Connection conn=null;
	public static Connection connectionDb(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ola", "root", null);
			
		} catch (Exception e) {
			
		}
		return conn;
	}
	/*public static void main(String[] args) {
		if(ConnectionDB.connectionDb()!=null)
		{
			System.out.println("connection Successful");
		}else{
			System.out.println("Connection not Successful");
		}
	}*/
}

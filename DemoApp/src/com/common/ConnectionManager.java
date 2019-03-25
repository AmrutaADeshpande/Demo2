package com.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {

	public static Connection getConnection() throws IOException {
		
		Connection con= null;
		FileInputStream fis = new FileInputStream("E:\\connection.properties");
		Properties pro= new Properties();
		pro.load(fis);
		String driver =pro.getProperty("dbdriver");
		String url = pro.getProperty("dburl");
		String id =pro.getProperty("dbid");
		String pass =pro.getProperty("dbpass");
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,id,pass);
			System.out.println("connected");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
		
	
	}
	/*public static  void mian() throws IOException {
		// TODO Auto-generated method stub
		ConnectionManager.getConnection();
	}*/
}

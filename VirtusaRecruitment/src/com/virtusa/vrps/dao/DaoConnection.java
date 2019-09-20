package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class DaoConnection {
	private DaoConnection() {
		
	}
	static Logger logger = Logger.getLogger(DaoConnection.class);

	static Connection con;
	public static Connection getConnection() {
		
		try {
			String pass="tiger";
			
			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:ORCL","scott",pass);

			return con;
		} catch (Exception e) {

			logger.error(e);
		} 
		return null;
	}
}

package com.virtusa.vrps.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class ConnDB {
	private ConnDB() {
		
	}
	static Logger logger = Logger.getLogger(ConnDB.class);
	public static Connection getCon() {
		Connection con = null;
		
		try {
			Driver d = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(d);
			String pass="tiger";
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", pass);
		} catch (Exception e) {
			logger.error(e);
		}

		return con;
	}

}

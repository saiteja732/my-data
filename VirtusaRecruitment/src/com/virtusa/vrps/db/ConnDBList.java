package com.virtusa.vrps.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;


public class ConnDBList implements ServletContextListener {
	static Logger logger = Logger.getLogger(ConnDBList.class);

	
@Override
	public void contextInitialized(ServletContextEvent sce) {
	

		try {
			Driver d = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(d);
			String pass="tiger";

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", pass);
			ServletContext sc = sce.getServletContext();
			sc.setAttribute("callconn", con);
		} catch (Exception e) {
			logger.error(e);
		}

	}


@Override
public void contextDestroyed(ServletContextEvent arg0) {

	
}
}

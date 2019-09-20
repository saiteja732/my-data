package com.virtusa.vrps.testcase;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

import com.virtusa.vrps.dao.AppIdGenerator;

class AppIdGeneratorTest {
	


	@Test
	void appIdTest() {
		Connection con = null;
		try {
			Driver d = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(d);
			String pass="tiger";
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", pass);
		} catch (Exception e) {
			
		}
		AppIdGenerator apd=new AppIdGenerator(con);
		int id=apd.getIdApp();
		boolean b=false;
		if(id!=0) {
			b=true;
		}
		assertEquals(true, b);
	}
	
	@Test
	void idAppTest() {
		Connection con = null;
		try {
			Driver d = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(d);
			String pass="tiger";
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", pass);
		} catch (Exception e) {
			
		}
		AppIdGenerator apd=new AppIdGenerator(con);
		String id=apd.getAppId();
		boolean b=false;
		if(id!=null) {
			b=true;
		}
		assertEquals(true, b);
	}

}

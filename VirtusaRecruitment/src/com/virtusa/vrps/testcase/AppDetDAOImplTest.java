package com.virtusa.vrps.testcase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.virtusa.vrps.dao.AppDetDAOImpl;
import com.virtusa.vrps.model.ApplicantDet;

public class AppDetDAOImplTest {
	
	
	@Test
	void getAppListTest() {
		AppDetDAOImpl ad=new AppDetDAOImpl();
		List<ApplicantDet> jList = ad.getAppList();
		boolean b=true;
		if(jList==null) {
			b=false;
		}
		assertEquals(b, false);
	}
	
	@Test
	void getAppListTestTrue() {
		Connection con = null; 
		try {
			Driver d = new oracle.jdbc.driver.OracleDriver(); 
			DriverManager.registerDriver(d);
			String pass="tiger";
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", pass);
		} catch (Exception e) {
			
		}
		AppDetDAOImpl ad=new AppDetDAOImpl(con);
		List<ApplicantDet> jList = ad.getAppList();
		boolean b=false;
		if(jList!=null) {
			b=true;
		}
		assertEquals(b, true);
	}

}

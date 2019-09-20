package com.virtusa.vrps.testcase;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

import com.virtusa.vrps.dao.EmpDAOImpl;

class EmpDAOImplTest {

	@Test
	void testGetByIdTrue() {
		Connection con = null; 
		try {
			Driver d = new oracle.jdbc.driver.OracleDriver(); 
			DriverManager.registerDriver(d);
			String pass="tiger";
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", pass);
		} catch (Exception e) {
		}
		
		EmpDAOImpl emp=new EmpDAOImpl(con);
		int status=emp.getById("EMP-2", "1234");
		boolean b=false;
		if(status!=0) {
			b=true;
		}
		assertEquals(true, b);
	}
	@Test
	void testGetByIdFalse() {
		Connection con = null; 
		try {
			Driver d = new oracle.jdbc.driver.OracleDriver(); 
			DriverManager.registerDriver(d);
			String pass="tiger";
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", pass);
		} catch (Exception e) {
		}
		
		EmpDAOImpl emp=new EmpDAOImpl(con);
		int status=emp.getById("7854", "78963");
		boolean b=true;
		if(status==0) {
			b=false;
		}
		assertEquals(false, b);
	}
	
	@Test
	void getDesigTestTrue() {
		Connection con = null; 
		try {
			Driver d = new oracle.jdbc.driver.OracleDriver(); 
			DriverManager.registerDriver(d);
			String pass="tiger";
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", pass);
		} catch (Exception e) {
		}
		
		EmpDAOImpl emp=new EmpDAOImpl(con);
		String status=emp.getDesig("EMP-2");
		boolean b=false;
		if(status!=null) {
			b=true;
		}
		assertEquals(true, b);
	}
	
	@Test
	void getDesigTestFalse() {
		Connection con = null; 
		try {
			Driver d = new oracle.jdbc.driver.OracleDriver(); 
			DriverManager.registerDriver(d);
			String pass="tiger";
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", pass);
		} catch (Exception e) {
		}
		
		EmpDAOImpl emp=new EmpDAOImpl(con);
		String status=emp.getDesig("7896");
		boolean b=true;
		if(status.equals("not found")) { 
			b=false;
		}
		assertEquals(false, b);
	}
	
	
	

}

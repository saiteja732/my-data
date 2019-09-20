package com.virtusa.vrps.testcase;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import com.virtusa.vrps.dao.EditProfileDAO;
import com.virtusa.vrps.dao.EditProfileDAOImpl;
import com.virtusa.vrps.model.EditProfileInfo;

class EditProfileDAOImplTest {

	@Test
	void testEditProfileTrue() {
		Date dob=null;
		String gender="female";
		String add="delhi";
		String city="Delhi";
		String state="Delhi";
		String country="India";
		int pincode=110092;
		String stream="CS";
		String degree="MCA";
		double cgpa=8;
		String inst="GLB";
		String university="Uptu";
		Date pass=null;
		String gap="no";
		String hb="Cbse";
		double hp=78;
		String sb="Cbse";
		double sp=65;
		double ey=0;
		String comp="";
		String loc="";
		
		String sDate1="02/01/1996";
		String sdate2="28/02/2018";
		Connection con = null;
		try {
			Driver d = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(d);
			String pas="tiger";
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", pas);
		} catch (Exception e) {
			
		}
		 try {
			 java.util.Date dd=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			 java.util.Date dd1=new SimpleDateFormat("dd/MM/yyyy").parse(sdate2);
			 dob=new Date(dd.getTime());
			 pass=new Date(dd1.getTime());
		} catch (ParseException e) {
		}
		EditProfileDAO ed=new EditProfileDAOImpl(con);
		EditProfileInfo edi=new EditProfileInfo(dob, gender, add, city, state, country, pincode, stream, degree, cgpa, inst, university, pass, gap, hb, hp, sb, sp, ey, comp, loc);
		boolean status = ed.updateProfile(edi,"JSK-4");
		assertEquals(true, status);
	}
	
}

package com.virtusa.vrps.testcase;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.virtusa.vrps.model.EditProfileInfo;

class EditProfileTest {

	EditProfileInfo ed=new EditProfileInfo(); 
	Date dob;
	String gender="female";
	String add="oandav nagar";
	String city="delhi";
	String state="delhi";
	String country="india";
	int pincode=110098;
	String stream="CS";
	String degree="MCA";
	double cgpa=4;
	String inst="GLB";
	String university="uptu";
	Date pass;
	String gap="no";
	String hb="cbse";
	double hp=75;
	String sb="cbse";
	double sp=56;
	double ey=2;
	String comp="hcl";
	String loc="delhi";
	static Logger logger = Logger.getLogger(JobListInfoTest.class);
	
	@Test
	void profileTest() {
		String sDate1="31/12/1998";
		
		 try {
			 java.util.Date dd=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			 Date dob=new Date(dd.getTime());
			 Date pass=new Date(dd.getTime());
			EditProfileInfo ed=new EditProfileInfo(dob, sDate1, sDate1, sDate1, sDate1, sDate1, pincode, sDate1, sDate1, cgpa, sDate1, sDate1, pass, sDate1, sDate1, hp, sDate1, sp, ey, sDate1, sDate1); 
		} catch (ParseException e) {
		
		}
		 
	}
	
	@Test
	void dobTest() { 
		String sDate1="31/12/1998";
		try {
			java.util.Date dd=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			Date ddn=new Date(dd.getTime());
			ed.setDob(ddn);
			assertEquals(ddn, ed.getDob()); 
		} catch (ParseException e) {
			
		}
	}
	
	@Test
	void genderTest() {
		ed.setGender("female");
		assertTrue(ed.getGender().equalsIgnoreCase("female"));
	}
	
	@Test
	void addressTest() {
		ed.setAdd("pandav nagar");
		assertTrue(ed.getAdd().equalsIgnoreCase("pandav nagar"));
	}
	
	@Test
	void cityTest() {
		ed.setCity("delhi");
		assertTrue(ed.getCity().equalsIgnoreCase("Delhi"));
	}
	
	@Test
	void stateTest() {
		ed.setState("delhi");
		assertTrue(ed.getState().equalsIgnoreCase("Delhi"));
	}

	@Test
	void countryTest() {
		ed.setCountry("India");
		assertTrue(ed.getCountry().equalsIgnoreCase("India"));
	}
	
	@Test
	void pincodeTest() {
		ed.setPincode(110092);
		assertTrue(ed.getPincode()==110092);
	}
	
	@Test
	void streamTest() {
		ed.setStream("CS");
		assertTrue(ed.getStream().equalsIgnoreCase("CS"));
	}
	
	@Test
	void degreeTest() {
		ed.setDegree("MCA");
		assertTrue(ed.getDegree().equalsIgnoreCase("mca"));
	}
	
	@Test
	void cgpaTest() {
		ed.setCgpa(5);
		assertTrue(ed.getCgpa()==5);
	}
	
	@Test
	void instTest() {
		ed.setInst("kalayan");
		assertTrue(ed.getInst().equalsIgnoreCase("kalayan"));
	}
	
	@Test
	void universityTest() {
		ed.setUniversity("uptu");
		assertTrue(ed.getUniversity().equalsIgnoreCase("uptu"));
	}
	
	@Test
	void passoutTest() {
		String sDate1="31/12/1998";
		 
		 try {
			 java.util.Date dd=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
			 Date ddn=new Date(dd.getTime());
			ed.setPass(ddn);
			assertEquals(ddn, ed.getPass()); 
			
		} catch (ParseException e) {

			
		}
	}
	
	@Test
	void gapTest() {
		ed.setGap("no");
		assertTrue(ed.getGap().equalsIgnoreCase("no"));
	}
	
	@Test
	void hbTest() {
		ed.setHb("cbse");
		assertTrue(ed.getHb().equalsIgnoreCase("cbse"));
	}
	
	@Test
	void hpTest() {
		ed.setHp(45);
		assertTrue(ed.getHp()==45);
	}
	
	@Test
	void sbTest() {
		ed.setSb("cbse");
		assertTrue(ed.getSb().equalsIgnoreCase("cbse"));
	}
	
	@Test
	void spTest() {
		ed.setSp(85);
		assertTrue(ed.getSp()==85);
	}
	
	@Test
	void expYearTest() {
		ed.setEy(2);
		assertTrue(ed.getEy()==2);
	}
	
	@Test
	void compTest() {
		ed.setComp("HCL");
		assertTrue(ed.getComp().equalsIgnoreCase("HCL"));
	}
	
	@Test
	void locationTest() {
		ed.setLoc("Delhi");
		assertTrue(ed.getLoc().equalsIgnoreCase("delhi"));
	}
}

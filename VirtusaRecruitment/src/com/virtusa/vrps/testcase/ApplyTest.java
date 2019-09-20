package com.virtusa.vrps.testcase;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.virtusa.vrps.dao.JsDetailsDAOImpl;
import com.virtusa.vrps.model.ApplicantDet;


class ApplyTest {

	static Logger logger = Logger.getLogger(ApplyTest.class);
	@Test
	void appIdTest() {
		ApplicantDet ad=new ApplicantDet();
		ad.setAppid("App-01");
		assertTrue(ad.getAppid().equalsIgnoreCase("App-01"));
	}
	
	@Test
	void jbidTest() {
		ApplicantDet ad=new ApplicantDet();
		ad.setJbid("Job-01");
		assertTrue(ad.getJbid().equalsIgnoreCase("Job-01"));  
	}
	
	@Test
	void jsidTest() {
		ApplicantDet ad=new ApplicantDet();
		ad.setJsid("Js-01");
		assertTrue(ad.getJsid().equalsIgnoreCase("Js-01"));
	}
	
	@Test
	void applydateTest() {
		ApplicantDet ad=new ApplicantDet();
		 String sDate1="31/12/1998";
		 SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
		 Date date1 = null;
		 
		try {
			date1 = formatter1.parse(sDate1);
			ad.setApplydate(date1);
			assertTrue(ad.getApplydate()==date1);
		} catch (ParseException e) {
			logger.error(e);
		}  
	}
	
	@Test
	void trstatusTest() {
		ApplicantDet ad=new ApplicantDet();
		ad.setTrstatus("Technical");
		assertTrue(ad.getTrstatus().equalsIgnoreCase("Technical"));
	}
	
	@Test 
	void hrstatusTest(){
		ApplicantDet ad=new ApplicantDet();
		ad.setHrstatus("HR");
		assertTrue(ad.getHrstatus().equalsIgnoreCase("HR"));
	}
	
	@Test
	void appstatusTest() {
		ApplicantDet ad=new ApplicantDet();
		ad.setAppstatus("Selected");
		assertTrue(ad.getAppstatus().equalsIgnoreCase("selected"));
	}
	
	@Test
	void fnameTest() {
		ApplicantDet ad=new ApplicantDet();
		ad.setFname("Ravi");
		assertTrue(ad.getFname().equalsIgnoreCase("Ravi"));
	}
	
	@Test
	void lnameTest() {
		ApplicantDet ad=new ApplicantDet();
		ad.setLname("Kumar");
		assertTrue(ad.getLname().equalsIgnoreCase("Kumar"));
	}
	
	@Test
	void cityTest() {
		ApplicantDet ad=new ApplicantDet();
		ad.setCity("Delhi");
		assertTrue(ad.getCity().equalsIgnoreCase("Delhi"));
	}
	
	@Test
	void stateTest() {
		ApplicantDet ad=new ApplicantDet();
		ad.setState("Delhi");
		assertTrue(ad.getState().equalsIgnoreCase("Delhi"));
	}
	
	@Test
	void streamTest() {
		ApplicantDet ad=new ApplicantDet();
		ad.setStream("CS");
		assertTrue(ad.getStream().equalsIgnoreCase("CS"));
	}
	
	@Test
	void degreeTest() {
		ApplicantDet ad=new ApplicantDet();
		ad.setDegree("B.tech");
		assertTrue(ad.getDegree().equalsIgnoreCase("B.tech"));
		
	}
}

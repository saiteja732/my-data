package com.virtusa.vrps.testcase;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.virtusa.vrps.model.JobApplicationInfo;

class JobApplicationTest {

	JobApplicationInfo jb=new JobApplicationInfo();
	static Logger logger = Logger.getLogger(JobApplicationTest.class);
	
	@Test
	void idTest() {
		jb.setId(74);
		assertTrue(jb.getId()==74);
	}
	
	@Test
	void applicationIdTest() {
		jb.setApplicationId("App-01");
		assertTrue(jb.getApplicationId().equalsIgnoreCase("App-01"));
	}
	
	@Test
	void jbIdTest() {
		jb.setJbId("Job-01");
		assertTrue(jb.getJbId().equalsIgnoreCase("Job-01"));
	}
	
	@Test
	void jsIdTest() {
		jb.setJsId("Js-01");
		assertTrue(jb.getJsId().equalsIgnoreCase("Js-01"));
	}
	
	@Test
	void applyDateTest() {
		String sDate1="31/12/1998";
		 SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
		 Date date1 = null;
		 try {
				date1 = formatter1.parse(sDate1);
				jb.setApplyDate(date1);
				assertTrue(jb.getApplyDate()==date1);
			} catch (ParseException e) {
				logger.error(e);
			}  
	}
	
	@Test
	void trStatusTest() {
		jb.setTrStatus("Technical");
		assertTrue(jb.getTrStatus().equalsIgnoreCase("technical"));
	}
	
	@Test
	void hrStatusTest() {
		jb.setHrStatus("HR");
		assertTrue(jb.getHrStatus().equalsIgnoreCase("hr"));
	}
	
	@Test
	void appStatusTest() {
		jb.setAppStatus("selected");
		assertTrue(jb.getAppStatus().equalsIgnoreCase("selected"));
	}
	
	@Test
	void jobApplicationInfo() {
		JobApplicationInfo jf=new JobApplicationInfo(2, "App-02", "Job-01", "Js-04");
	}

}

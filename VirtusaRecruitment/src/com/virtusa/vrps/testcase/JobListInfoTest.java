package com.virtusa.vrps.testcase;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.virtusa.vrps.model.JobListInfo;

class JobListInfoTest {

	int id=1;
	String jbId="Job-02";
	String jbTitle="Developer";
	String jbDesc="Worked on some application";
	String jbEligibility="MCA";
	String jbTechReq="java";
	String jbLoc="Pune";
	float jbExpReq=2;
	float jbPackage=3.5f;
	String gap="no";
	Date jbPostDate;
	Date jbExpireDate; 
	JobListInfo jf=new JobListInfo();
	static Logger logger = Logger.getLogger(JobListInfoTest.class);
	
	@Test
	void jobListInfo() {
		String sDate1="31/12/1998";
		 SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
		 try {
			jbPostDate = formatter1.parse(sDate1);
			jbExpireDate = formatter1.parse(sDate1);
			JobListInfo jf=new JobListInfo(id, jbId, jbTitle, jbDesc, jbEligibility, jbTechReq, jbLoc, jbExpReq, jbPackage, jbExpireDate, gap);
		} catch (ParseException e) {
			logger.error(e);
		}
	}
	
	@Test
	void idTest() {
		jf.setId(5);
		assertTrue(jf.getId()==5);
	}
	
	@Test
	void jbIdTest() {
		jf.setJbId("Job-02");
		assertTrue(jf.getJbId().equalsIgnoreCase("Job-02"));
	}
	
	@Test
	void jbTitleTest() {
		jf.setJbTitle("Developer");
		assertTrue(jf.getJbTitle().equalsIgnoreCase("Developer"));
	}
	
	@Test
	void jbDescTest() {
		jf.setJbDesc(jbDesc);
		assertTrue(jf.getJbDesc().equalsIgnoreCase(jbDesc));
	}
	
	@Test
	void jbEligibilityTest() {
		jf.setJbEligibility(jbEligibility);
		assertTrue(jf.getJbEligibility().equalsIgnoreCase(jbEligibility));
	}
	
	@Test
	void jbTechReqTest() {
		jf.setJbTechReq(jbTechReq);
		assertTrue(jf.getJbTechReq().equalsIgnoreCase(jbTechReq));
	}
	
	@Test
	void jbLocTest() {
		jf.setJbLoc(jbLoc);
		assertTrue(jf.getJbLoc().equalsIgnoreCase(jbLoc));
	}
	
	@Test
	void jbExpReqTest() {
		jf.setJbExpReq(jbExpReq);
		assertTrue(jf.getJbExpReq()==jbExpReq);
	}
	
	@Test
	void jbPackageTest() {
		jf.setJbPackage(jbPackage);
		assertTrue(jf.getJbPackage()==jbPackage);
	}
	
	@Test
	void gapTest() {
		jf.setGap(gap);
		assertTrue(jf.getGap().equalsIgnoreCase(gap));
	}
	
	@Test
	void jbPostDateTest() {
		String sDate1="31/12/1998";
		 SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
		 try {
			jbPostDate = formatter1.parse(sDate1);
			jf.setJbPostDate(jbPostDate);
			assertTrue(jf.getJbPostDate()==jbPostDate);
		} catch (ParseException e) {
			logger.error(e);
		}
	}
	
	@Test
	void jbExpireDateTest() {
		String sDate1="31/12/1998";
		 SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
		 try {
			 jbExpireDate = formatter1.parse(sDate1);
			 jf.setJbExpireDate(jbExpireDate);
			 assertTrue(jf.getJbExpireDate()==jbExpireDate);
		 } catch (ParseException e) {
			logger.error(e);
		}
	}

}

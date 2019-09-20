package com.virtusa.vrps.testcase;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.virtusa.vrps.model.JobSeeker;
import com.virtusa.vrps.model.JsSignup;

class JsSignupTest {

	
	String jsid="Js-02";
	String fisrtName="rajat";
	String lastName="sharma";
	String state="delhi";
	String country="india";
	String degree="MCA";
	String stream="CS";
	int experience=1;
	String email="rajat@gmail.com";
	String password="rj45";
	String phone="7896541230";
	Date dob; 
	String gender="female";
	String address="pandav nagar";
	String city="delhi";
	int pincode=110092;
	float cgpa=8;
	String institute="gl bajaj";
	String university="uptu";
	Date passout;
	String hBoard="cbse";
	String hMarks="75";
	String sBoard="cbse";
	String sMarks="70";
	String company="hcl";
	String location="delhi";
	String question="what is your pet name ?";
	String answer="dog";
	int commentNo=2;
	Float rateAVG=3.5f;
	String gap="no";
	String jsStatus="active";
	static Logger logger = Logger.getLogger(JobListInfoTest.class);
	JsSignup js=new JsSignup(); 
	
	

	
	@Test
	void jsidTest() {
		js.setJsId(jsid);
		assertTrue(js.getJsId().equalsIgnoreCase(jsid));
	}
	
	@Test
	void fisrtNameTest() {
		js.setFirstName(fisrtName);
		assertTrue(js.getFirstName().equalsIgnoreCase(fisrtName));
	}
	
	@Test
	void lastNameTest() {
		js.setLastName(lastName);
		assertTrue(js.getLastName().equalsIgnoreCase(lastName));
	}
	
	@Test
	void stateTest() {
		js.setState(state);
		assertTrue(js.getState().equalsIgnoreCase(state));
	}
	
	@Test
	void countryTest() {
		js.setCountry(country);
		assertTrue(js.getCountry().equalsIgnoreCase(country));
	}
	
	@Test
	void degreeTest() {
		js.setDegree(degree);
		assertTrue(js.getDegree().equalsIgnoreCase(degree));
	}
	
	@Test
	void streamTest() {
		js.setStream(stream);
		assertTrue(js.getStream().equalsIgnoreCase(stream));
	}
	
	
	
	@Test
	void emailTest() {
		js.setJsEmail(email);
		assertTrue(js.getJsEmail().equalsIgnoreCase(email));
	}
	
	
	@Test
	void phoneTest() {
		js.setJsPhoneNo(phone);
		assertTrue(js.getJsPhoneNo().equalsIgnoreCase(phone));
	}
	
	@Test
	void dobTest() {
		
		String sDate1="31/12/1998";
		 SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
		 try {
			dob = formatter1.parse(sDate1);
			js.setDoB(dob);
			assertTrue(js.getDoB()==dob);
		} catch (ParseException e) {
			logger.error(e);
		}
	}
	
	@Test
	void genderTest() {
		js.setGender(gender);
		assertTrue(js.getGender().equalsIgnoreCase(gender));
	}
	
	@Test
	void addressTest() {
		js.setAddress(address);
		assertTrue(js.getAddress().equalsIgnoreCase(address));
	}
	
	@Test
	void cityTest() {
		js.setCity(city);
		assertTrue(js.getCity().equalsIgnoreCase(city));
	}
	
	@Test
	void pincodeTest() {
		js.setPincode(pincode);
		assertTrue(js.getPincode()==pincode);
	}
	
	@Test
	void cgpaTest() {
		js.setCgpa(cgpa);
		assertTrue(js.getCgpa()==cgpa);
	}
	
	@Test
	void instituteTest() {
		js.setInstitute(institute);
		assertTrue(js.getInstitute().equalsIgnoreCase(institute));
	}
	
	@Test
	void universityTest() {
		js.setUniversity(university);
		assertTrue(js.getUniversity().equalsIgnoreCase(university));
	}
	
	@Test
	void passoutTest() {
		String sDate1="31/12/1998";
		 SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
		 try {
			
			passout = formatter1.parse(sDate1);
			js.setPassout(passout); 
			assertTrue(js.getPassout()==passout);
		} catch (ParseException e) {
			logger.error(e);
		}
	}
	
	@Test
	void hBoardTest() {
		js.setHsBoard(hBoard);
		assertTrue(js.getHsBoard().equalsIgnoreCase(hBoard));
	}
	
	@Test
	void hMarksTest() {
		js.setHsPercent(hMarks);
		assertTrue(js.getHsPercent()==hMarks);
	}
	
	@Test
	void sBoardTest() {
		js.setsBoard(sBoard);
		assertTrue(js.getsBoard().equalsIgnoreCase(sBoard));
	}
	
	@Test
	void sMarksTest() {
		js.setSbPercent(sMarks);
		assertTrue(js.getSbPercent()==sMarks);
	}
	
	@Test
	void companyTest() {
		js.setCompany(company);
		assertTrue(js.getCompany().equalsIgnoreCase(company));
	}
	
	@Test
	void locationTest() {
		js.setLocation(location);
		assertTrue(js.getLocation().equalsIgnoreCase(location));
	}
	
	@Test
	void questionTest() {
		js.setQuestion(question);
		assertTrue(js.getQuestion().equalsIgnoreCase(question));
	}
	
	@Test
	void answerTest() {
		js.setAnswer(answer);
		assertTrue(js.getAnswer().equalsIgnoreCase(answer));
	}
	

	
	@Test
	void gapTest() {
		js.setGap(gap);
		assertTrue(js.getGap().equalsIgnoreCase(gap));
	}
	
	@Test
	void jsStatusTest() {
		js.setJsStatus(jsStatus);
		assertTrue(js.getJsStatus().equalsIgnoreCase(jsStatus));
	}

}

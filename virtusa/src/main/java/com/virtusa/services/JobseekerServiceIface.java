package com.virtusa.services;

import java.util.List;

import com.virtusa.model.Jobseeker;

public interface JobseekerServiceIface {
	boolean RegisterJob(String fname,String lname,String email,String phoneno,String password,String question,String answer);
	String loginValidateService(Jobseeker jobseeker);
	String forgotpass(Jobseeker jobseeker);
	String editpass(Jobseeker jobseeker);
	public Jobseeker getJSDetails(String jsid);
	public void updateJSDetails(Jobseeker jobseeker);
}

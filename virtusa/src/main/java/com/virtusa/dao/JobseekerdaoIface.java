package com.virtusa.dao;

import java.sql.Date;
import java.util.List;

import com.virtusa.model.Jobseeker;

public interface JobseekerdaoIface {
	String loginValidate(Jobseeker jobseeker);
	public boolean RegisterJob(String fname, String lname, String email, String password, String question,String phoneno,
			String answer);
	String forgotpass(Jobseeker jobseeker);
	String editpass(Jobseeker jobseeker);
	public Jobseeker getJSDetails(String jsid);
	public void updateJSDetails(Jobseeker jobseeker);
	}

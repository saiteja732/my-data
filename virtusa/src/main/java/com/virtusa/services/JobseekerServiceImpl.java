package com.virtusa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.dao.JobseekerdaoIface;
import com.virtusa.dao.JobseekerdaoImpl;
import com.virtusa.model.Jobseeker;
@Service
@Transactional
public class JobseekerServiceImpl implements JobseekerServiceIface{
	@Autowired
	JobseekerdaoIface jobseekerdaoIface;
	
	public boolean RegisterJob(String fname, String lname, String email, String phoneno, String password,
			String question, String answer) {
			
		return jobseekerdaoIface.RegisterJob(fname, lname, email, password, question, phoneno, answer);
	}
	public String loginValidateService(Jobseeker jobseeker) {
		return jobseekerdaoIface.loginValidate(jobseeker);
	}
	public String forgotpass(Jobseeker jobseeker) {
	      
		return jobseekerdaoIface.forgotpass(jobseeker);
	}
	public String editpass(Jobseeker jobseeker) {
		return jobseekerdaoIface.editpass(jobseeker);
	}
	public Jobseeker getJSDetails(String jsid) {
		return jobseekerdaoIface.getJSDetails(jsid);
	}
	
	public void updateJSDetails(Jobseeker jobseeker) {
		jobseekerdaoIface.updateJSDetails(jobseeker);
	}
}

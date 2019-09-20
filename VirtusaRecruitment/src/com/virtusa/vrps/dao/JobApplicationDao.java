package com.virtusa.vrps.dao;

import com.virtusa.vrps.model.JobApplicationInfo;


public interface JobApplicationDao {
	public boolean insert(JobApplicationInfo jainfo);
	public String getStatus(String appid, String jsid);
	public String getJSid(String email);
	
	
	
}

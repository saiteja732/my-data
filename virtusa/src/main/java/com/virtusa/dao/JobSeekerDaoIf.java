package com.virtusa.dao;

import java.util.List;

import com.virtusa.model.Jobseeker;

public interface JobSeekerDaoIf {
	public void save(Jobseeker just);
	  public List<Jobseeker> show();
	  public String generateId();
}

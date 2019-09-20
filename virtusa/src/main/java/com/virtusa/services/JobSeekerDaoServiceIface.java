package com.virtusa.services;

import java.util.List;

import com.virtusa.model.Jobseeker;

public interface JobSeekerDaoServiceIface {
	public void save(Jobseeker just);
	  public List<Jobseeker> show();
	  public String generateId();
}

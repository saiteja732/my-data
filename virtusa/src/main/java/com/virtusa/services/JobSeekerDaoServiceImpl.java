package com.virtusa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.dao.JobSeekerDaoIf;
import com.virtusa.model.Jobseeker;
@Service
@Transactional
public class JobSeekerDaoServiceImpl implements JobSeekerDaoServiceIface {
	@Autowired
	JobSeekerDaoIf jobSeekerDaoIf;
	public void save(Jobseeker just) {
		jobSeekerDaoIf.save(just);
	}

	public List<Jobseeker> show() {
		return jobSeekerDaoIf.show();
	}

	public String generateId() {
		return jobSeekerDaoIf.generateId();
	}

}

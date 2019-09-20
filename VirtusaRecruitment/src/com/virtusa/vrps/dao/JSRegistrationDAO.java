package com.virtusa.vrps.dao;

import com.virtusa.vrps.model.JobSeeker;

public interface JSRegistrationDAO   {
public boolean insert(JobSeeker jsinfo);
public String getOneParam(String email);
public boolean getPassword(String pass, String email);
public boolean getQA(String ques, String ans, String email);
}

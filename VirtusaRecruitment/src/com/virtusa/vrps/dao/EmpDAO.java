package com.virtusa.vrps.dao;

import com.virtusa.vrps.model.EmployeeInfo;

public interface EmpDAO {
	public int getById(String empid, String psw);

	public String getDesig(String empid);
	
	public boolean insert(EmployeeInfo empinfo);
}

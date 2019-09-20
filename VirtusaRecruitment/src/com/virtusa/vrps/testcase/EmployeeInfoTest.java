package com.virtusa.vrps.testcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.virtusa.vrps.model.EmployeeInfo;

class EmployeeInfoTest {
	
	String empid="9874";
	String empFirstName="barkha";
	String empLastName="gupta";
	String empEmail="barkha@gmail.com";
	String empPhone="7896541230";
	String empPassword="work";
	String empDesignation="AE";
	String empDepartment="IT";
	String empStatus="active";
	String empRole="Junior";
	EmployeeInfo ep=new EmployeeInfo();

	@Test
	void employeeInfomation() {
		EmployeeInfo emp=new EmployeeInfo(empid, empFirstName, empLastName, empEmail, empPhone, empPassword, empDesignation, empDepartment, empStatus, empRole);
	}

	@Test
	void empidTest() {
		ep.setEmpid(empid);
		assertTrue(ep.getEmpid().equalsIgnoreCase(empid));
	}
	
	@Test
	void empFirstNameTest() {
		ep.setEmpFirstName(empFirstName);
		assertTrue(ep.getEmpFirstName().equalsIgnoreCase(empFirstName));
	}
	
	@Test
	void empLastNameTest() {
		ep.setEmpLastName(empLastName);
		assertTrue(ep.getEmpLastName().equalsIgnoreCase(empLastName));
	}
	
	@Test
	void empEmailTest() {
		ep.setEmpEmail(empEmail);
		assertTrue(ep.getEmpEmail().equalsIgnoreCase(empEmail));
	}
	
	@Test
	void empPhoneTest() {
		ep.setEmpPhone(empPhone);
		assertTrue(ep.getEmpPhone().equalsIgnoreCase(empPhone));
	}
	
	@Test
	void empPasswordTest() {
		ep.setEmpPassword(empPassword);
		assertTrue(ep.getEmpPassword().equalsIgnoreCase(empPassword));
	}
	
	@Test
	void empDesignationTest() {
		ep.setEmpDesignation(empDesignation);
		assertTrue(ep.getEmpDesignation().equalsIgnoreCase(empDesignation));
	}
	
	@Test
	void empDepartmentTest() {
		ep.setEmpDepartment(empDepartment);
		assertTrue(ep.getEmpDepartment().equalsIgnoreCase(empDepartment));
	}
	
	@Test
	void empStatusTest() {
		ep.setEmpStatus(empStatus);
		assertTrue(ep.getEmpStatus().equalsIgnoreCase(empStatus));
	}
	
	@Test
	void empRoleTest() {
		ep.setEmpRole(empRole);
		assertTrue(ep.getEmpRole().equalsIgnoreCase(empRole));
	}
}

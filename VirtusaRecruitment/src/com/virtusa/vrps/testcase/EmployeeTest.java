package com.virtusa.vrps.testcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.virtusa.vrps.model.Employee;

class EmployeeTest {

	@Test
	void empId() {
		Employee emp=new Employee();
		emp.setEmpId("8975");
		assertTrue(emp.getEmpId().equalsIgnoreCase("8975"));
	}

	@Test
	void empFirstName() {
		Employee emp=new Employee();
		emp.setEmpFirstName("Barkha");
		assertTrue(emp.getEmpFirstName().equalsIgnoreCase("Barkha"));
	}
	
	@Test
	void empLastName() {
		Employee emp=new Employee();
		emp.setEmpLastName("gupta");
		assertTrue(emp.getEmpLastName().equalsIgnoreCase("gupta"));
	}
	
	@Test
	void empEmail() {
		Employee emp=new Employee();
		emp.setEmpEmail("barkha@gmail.com");
		assertTrue(emp.getEmpEmail().equalsIgnoreCase("barkha@gmail.com"));
	}
	
	@Test
	void empDesignation() {
		Employee emp=new Employee();
		emp.setEmpDesignation("Manager");
		assertTrue(emp.getEmpDesignation().equalsIgnoreCase("Manager"));
	}
	
	@Test
	void empDepartment() {
		Employee emp=new Employee();
		emp.setEmpDepartment("IT");
		assertTrue(emp.getEmpDepartment().equalsIgnoreCase("IT"));
	}
	
	@Test
	void empPhone() {
		Employee emp=new Employee();
		emp.setEmpPhone("98745632");
		assertTrue(emp.getEmpPhone().equalsIgnoreCase("98745632"));
	}
}

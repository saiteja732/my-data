package com.virtusa.vrps.model;

public class EmployeeInfo {
	private String empid;
			
	private String empFirstName;
	private String empLastName;
	private String empEmail;
	private String empPhone;
	private String empPassword;
	private String empDesignation;
	private String empDepartment;
	private String empStatus;
	private String empRole;
	public EmployeeInfo() {}
	public EmployeeInfo(String empid, String empFirstName, String empLastName, String empEmail, String empPhone,
			String empPassword, String empDesignation, String empDepartment, String empStatus, String empRole) {
		super();
		this.empid = empid;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empPassword = empPassword;
		this.empDesignation = empDesignation;
		this.empDepartment = empDepartment;
		this.empStatus = empStatus;
		this.empRole = empRole;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

}

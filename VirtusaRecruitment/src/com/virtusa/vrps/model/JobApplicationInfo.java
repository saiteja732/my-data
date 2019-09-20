package com.virtusa.vrps.model;

import java.util.Date;

public class JobApplicationInfo {
	private int id;
	private String applicationId;
	private String jbId;
	private String jsId;
	private Date applyDate;
	private String trStatus;
	private String hrStatus;
	private String appStatus;
	public JobApplicationInfo() {
		
	}
	public JobApplicationInfo(int id,String applicationId,String jbId,String jsId) {
		super();
		this.id=id;
		this.applicationId = applicationId;
		this.jbId = jbId;
		this.jsId=jsId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getJbId() {
		return jbId;
	}

	public void setJbId(String jbId) {
		this.jbId = jbId;
	}

	public String getJsId() {
		return jsId;
	}

	public void setJsId(String jsId) {
		this.jsId = jsId;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getTrStatus() {
		return trStatus;
	}

	public void setTrStatus(String trStatus) {
		this.trStatus = trStatus;
	}

	public String getHrStatus() {
		return hrStatus;
	}

	public void setHrStatus(String hrStatus) {
		this.hrStatus = hrStatus;
	}

	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

}

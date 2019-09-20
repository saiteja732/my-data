package com.virtusa.vrps.model;

import java.util.Date;

public class JobListInfo {
	private int id;
	private String jbId;
	private String jbTitle;
	private String jbDesc;
	private String jbEligibility;
	private String jbTechReq;
	private String jbLoc;
	private float jbExpReq;
	private float jbPackage;
	private Date jbPostDate;
	private Date jbExpireDate;
	private String gap;

	public JobListInfo() {

	}

	public JobListInfo(int id, String jbId, String jbTitle, String jbDesc, String jbEligibility, String jbTechReq,
			String jbLoc, float jbExpReq, float jbPackage, Date jbExpireDate, String gap) {
		super();
		this.id = id;
		this.jbId = jbId;
		this.jbTitle = jbTitle;
		this.jbDesc = jbDesc;
		this.jbEligibility = jbEligibility;
		this.jbTechReq = jbTechReq;
		this.jbLoc = jbLoc;
		this.jbExpReq = jbExpReq;
		this.jbPackage = jbPackage;
		this.jbExpireDate = jbExpireDate;
		this.gap = gap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJbId() {
		return jbId;
	}

	public void setJbId(String jbId) {
		this.jbId = jbId;
	}

	public String getJbTitle() {
		return jbTitle;
	}

	public void setJbTitle(String jbTitle) {
		this.jbTitle = jbTitle;
	}

	public String getJbDesc() {
		return jbDesc;
	}

	public void setJbDesc(String jbDesc) {
		this.jbDesc = jbDesc;
	}

	public String getJbEligibility() {
		return jbEligibility;
	}

	public void setJbEligibility(String jbEligibility) {
		this.jbEligibility = jbEligibility;
	}

	public String getJbTechReq() {
		return jbTechReq;
	}

	public void setJbTechReq(String jbTechReq) {
		this.jbTechReq = jbTechReq;
	}

	public String getJbLoc() {
		return jbLoc;
	}

	public void setJbLoc(String jbLoc) {
		this.jbLoc = jbLoc;
	}

	public float getJbPackage() {
		return jbPackage;
	}

	public void setJbPackage(float jbPackage) {
		this.jbPackage = jbPackage;
	}

	public Date getJbPostDate() {
		return jbPostDate;
	}

	public void setJbPostDate(Date jbPostDate) {
		this.jbPostDate = jbPostDate;
	}

	public Date getJbExpireDate() {
		return jbExpireDate;
	}

	public void setJbExpireDate(Date jbExpireDate) {
		this.jbExpireDate = jbExpireDate;
	}

	public String getGap() {
		return gap;
	}

	public void setGap(String gap) {
		this.gap = gap;
	}

	public float getJbExpReq() {
		return jbExpReq;
	}

	public void setJbExpReq(float jbExpReq) {
		this.jbExpReq = jbExpReq;
	}

}

package com.virtusa.vrps.model;

import java.sql.Date;

public class EditProfileInfo {

	private Date dob;
	private String gender;
	private String add;
	private String city;
	private String state;
	private String country;
	private int pincode;
	private String stream;
	private String degree;
	private double cgpa;
	private String inst;
	private String university;
	private Date pass;
	private String gap;
	private String hb;
	private double hp;
	private String sb;
	private double sp;
	private double ey;
	private String comp;
	private String loc;
	
	public EditProfileInfo() {
		
	}
	public EditProfileInfo(Date dob) {
		this.dob=dob;
		
	}
	
	
	public EditProfileInfo(Date dob, String gender, String add, String city, String state, String country, int pincode,
			String stream, String degree, double cgpa, String inst, String university, Date pass, String gap, String hb,
			double hp, String sb, double sp, double ey, String comp, String loc) {
		super();
		this.dob = dob;
		this.gender = gender;
		this.add = add;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.stream = stream;
		this.degree = degree;
		this.cgpa = cgpa;
		this.inst = inst;
		this.university = university;
		this.pass = pass;
		this.gap = gap;
		this.hb = hb;
		this.hp = hp;
		this.sb = sb;
		this.sp = sp;
		this.ey = ey;
		this.comp = comp;
		this.loc = loc;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(int cgpa) {
		this.cgpa = cgpa;
	}
	public String getInst() {
		return inst;
	}
	public void setInst(String inst) {
		this.inst = inst;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public Date getPass() {
		return pass;
	}
	public void setPass(Date pass) {
		this.pass = pass;
	}
	public String getGap() {
		return gap;
	}
	public void setGap(String gap) {
		this.gap = gap;
	}
	public String getHb() {
		return hb;
	}
	public void setHb(String hb) {
		this.hb = hb;
	}
	public double getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getSb() {
		return sb;
	}
	public void setSb(String sb) {
		this.sb = sb;
	}
	public double getSp() {
		return sp;
	}
	public void setSp(int sp) {
		this.sp = sp;
	}
	public double getEy() {
		return ey;
	}
	public void setEy(int ey) {
		this.ey = ey;
	}
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	

}

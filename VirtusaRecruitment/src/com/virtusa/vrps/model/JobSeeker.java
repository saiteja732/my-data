package com.virtusa.vrps.model;

import java.util.Date;

public class JobSeeker{
	private int id;
	private String jsid;
	private String fisrtName;
	private String lastName;
	private String state;
	private String country;
	private String degree;
	private String stream;
	private int experience;
	private String email;
	private String password;
	private String phone;
	private Date dob;
	private String gender;
	private String address;
	private String city;
	private int pincode;
	private double cgpa;
	private String institute;
	private String university;
	private Date passout;
	private String hBoard;
	private double hMarks;
	private String sBoard;
	private double sMarks;
	private String company;
	private String location;
	private String question;
	private String answer;
	private int commentNo;
	private Float rateAVG;
	private String gap;
	
	public JobSeeker() {
		
	}
	
	public JobSeeker(int id, String jsid, String fisrtName, String lastName, String email, String password,
			String phone, String question, String answer) {
		super();
		this.id = id;
		this.jsid = jsid;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.question = question;
		this.answer = answer;
	}
	
	

	public String getGap() {
		return gap;
	}

	public void setGap(String gap) {
		this.gap = gap;
	}

	public Date getPassout() {
		return passout;
	}

	public void setPassout(Date passout) {
		this.passout = passout;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJsid() {
		return jsid;
	}

	public void setJsid(String jsid) {
		this.jsid = jsid;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String gethBoard() {
		return hBoard;
	}

	public void sethBoard(String hBoard) {
		this.hBoard = hBoard;
	}

	public double gethMarks() {
		return hMarks;
	}

	public void sethMarks(double hMarks) {
		this.hMarks = hMarks;
	}

	public String getsBoard() {
		return sBoard;
	}

	public void setsBoard(String sBoard) {
		this.sBoard = sBoard;
	}

	public double getsMarks() {
		return sMarks;
	}

	public void setsMarks(double sMarks) {
		this.sMarks = sMarks;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public Float getRateAVG() {
		return rateAVG;
	}

	public void setRateAVG(Float rateAVG) {
		this.rateAVG = rateAVG;
	}

	
	
	
	
	
}

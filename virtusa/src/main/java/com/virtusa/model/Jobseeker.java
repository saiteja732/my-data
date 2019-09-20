package com.virtusa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="jsregistration")
public class Jobseeker{
	@Column(name="id")
	private int id;
	@Id
	@Column(name="jsid")
	private String jsid;
	@Column(name="jsfirstname")
	private String firstName;
	@Column(name="jslastname")
	private String lastName;
	@Column(name="state")
	private String state;
	@Column(name="country")
	private String country;
	@Column(name="degree")
	private String degree;
	@Column(name="stream")
	private String stream;
	@Column(name="expyear")
	private Integer experience;
	@Column(name="jsemail")
	private String email;
	@Column(name="jspassword")
	private String password;
	@Column(name="jsphoneno")
	private String phone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="dob")
	private Date dob;
	@Column(name="gender")
	private String gender;
	@Column(name="address")
	private String address;
	@Column(name="city")
	private String city;
	@Column(name="pincode")
	private Integer pincode;
	@Column(name="cgpa")
	private Double cgpa;
	@Column(name="institute")
	private String institute;
	@Column(name="university")
	private String university;
	@Column(name="passout")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date passout;
	@Column(name="hsboard")
	private String hBoard;	
	@Column(name="hspercentage")
	private Double hMarks;
	@Column(name="sboard")
	private String sBoard;
	@Column(name="sbpercentage")
	private Double sMarks;
	@Column(name="company")
	private String company;
	@Column(name="location")
	private String location;
	@Column(name="question")
	private String question;
	@Column(name="answer")
	private String answer;
	//private int commentNo;
//	private Float rateAVG;
	@Column(name="gap")
	private String gap;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
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
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public Double getCgpa() {
		return cgpa;
	}
	public void setCgpa(Double cgpa) {
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
	public Date getPassout() {
		return passout;
	}
	public void setPassout(Date passout) {
		this.passout = passout;
	}
	public String gethBoard() {
		return hBoard;
	}
	public void sethBoard(String hBoard) {
		this.hBoard = hBoard;
	}
	public Double gethMarks() {
		return hMarks;
	}
	public void sethMarks(Double hMarks) {
		this.hMarks = hMarks;
	}
	public String getsBoard() {
		return sBoard;
	}
	public void setsBoard(String sBoard) {
		this.sBoard = sBoard;
	}
	public Double getsMarks() {
		return sMarks;
	}
	public void setsMarks(Double sMarks) {
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
	public String getGap() {
		return gap;
	}
	public void setGap(String gap) {
		this.gap = gap;
	}
	@Override
	public String toString() {
		return "Jobseeker [id=" + id + ", jsid=" + jsid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", state=" + state + ", country=" + country + ", degree=" + degree + ", stream=" + stream
				+ ", experience=" + experience + ", email=" + email + ", password=" + password + ", phone=" + phone
				+ ", dob=" + dob + ", gender=" + gender + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", cgpa=" + cgpa + ", institute=" + institute + ", university=" + university + ", passout="
				+ passout + ", hBoard=" + hBoard + ", hMarks=" + hMarks + ", sBoard=" + sBoard + ", sMarks=" + sMarks
				+ ", company=" + company + ", location=" + location + ", question=" + question + ", answer=" + answer
				+ ", gap=" + gap + "]";
	}
	
	

	/*
	 * public int getCommentNo() { return commentNo; }
	 * 
	 * public void setCommentNo(int commentNo) { this.commentNo = commentNo; }
	 * 
	 * public Float getRateAVG() { return rateAVG; }
	 * 
	 * public void setRateAVG(Float rateAVG) { this.rateAVG = rateAVG; }
	 * 
	 */	
	
	
	
	
}

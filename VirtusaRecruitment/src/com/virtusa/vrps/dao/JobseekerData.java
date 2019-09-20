package com.virtusa.vrps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.virtusa.vrps.model.JSComment;
import com.virtusa.vrps.model.JobSeeker;

public class JobseekerData {
	static Logger logger = Logger.getLogger(JobseekerData.class);

		Connection con=DaoConnection.getConnection();
		PreparedStatement pst;
		PreparedStatement ps;
		int sum;
		int count;
		ResultSet rs=null;
		ResultSet rd=null;
		List<JSComment> as=new ArrayList<>();
		Statement st;

	public JobSeeker getData(String str) {

		JobSeeker jk=null;
		
		try {
			pst=con.prepareStatement("select * from JSRegistration where jsid=?");
			pst.setString(1, str);
			rs=pst.executeQuery();
			if(rs.next()) {
				jk=new JobSeeker();
				jk.setJsid(rs.getString("JSId"));
				jk.setFisrtName(rs.getString("JSFIRSTNAME"));
				jk.setLastName(rs.getString("JSLASTNAME"));
				jk.setEmail(rs.getString("JSEMAIL"));
				jk.setPhone(rs.getString("JSPHONENO"));
				jk.setDob(rs.getDate("DOB")); //date
				jk.setGender(new ValidateItem().stringValidate(rs.getString("Gender")));
				jk.setAddress(new ValidateItem().stringValidate(rs.getString("ADDRESS")));
				jk.setCity(new ValidateItem().stringValidate(rs.getString("City")));
				jk.setState(new ValidateItem().stringValidate(rs.getString("State")));
				jk.setCountry(new ValidateItem().stringValidate(rs.getString("Country")));
				jk.setPincode(rs.getInt("PINCODE"));
				jk.setDegree(new ValidateItem().stringValidate(rs.getString("Degree")));
				jk.setStream(new ValidateItem().stringValidate(rs.getString("STREAM")));
				jk.setExperience(rs.getInt("EXPYEAR"));
				jk.setCgpa(rs.getInt("CGPA"));
				jk.setInstitute(new ValidateItem().stringValidate(rs.getString("INSTITUTE")));
				jk.setUniversity(new ValidateItem().stringValidate(rs.getString("UNIVERSITY")));
				jk.sethBoard(new ValidateItem().stringValidate(rs.getString("HSBOARD")));
				jk.sethMarks(rs.getDouble("HSPERCENTAGE"));
				jk.setsBoard(new ValidateItem().stringValidate(rs.getString("SBOARD")));
				jk.setsMarks(rs.getDouble("SBPERCENTAGE"));
				jk.setCompany(new ValidateItem().stringValidate(rs.getString("Company")));
				jk.setLocation(new ValidateItem().stringValidate(rs.getString("LOCATION")));
				ps=con.prepareStatement("select count(*) As ct from ratecomment where jsid=? AND commentdes IS NOT NULL");
				ps.setString(1, rs.getString("JSId"));
				rd=ps.executeQuery();
				if(rd.next()) {
					jk.setCommentNo(rd.getInt("ct"));
				}
				ps=con.prepareStatement("select count(*) As ct,Sum(rating) As st from ratecomment where jsid=?");
				ps.setString(1, rs.getString("JSId"));
				rd=ps.executeQuery();
				if(rd.next()) {
					sum=rd.getInt("st");
					
					count=rd.getInt("ct");
					
				}
				jk.setRateAVG(new ValidateItem().rateCalculation(sum,count));
				jk.setPassout(rs.getDate("PASSOUT"));
				jk.setGap(new ValidateItem().stringValidate(rs.getString("GAP")));
			}
		} catch (SQLException e) {
			logger.error(e);
		}finally {
			try {
			if(rs!=null) {
				rs.close();
			}
		}catch (SQLException e) {
			logger.error(e);
		}
			try {
			if(rd!=null) {
				rd.close();
			}
		}catch (SQLException e) {
			logger.error(e);
		}
	}

		
		return jk;
	}
	
	
	public JobSeeker getDataProfile(String str) {

		JobSeeker jk=null;
		
		try {
			pst=con.prepareStatement("select * from JSRegistration where JSEMAIL=?");
			pst.setString(1, str);
			rs=pst.executeQuery();
			if(rs.next()) {
				jk=new JobSeeker();
				jk.setJsid(rs.getString("JSId"));
				jk.setFisrtName(rs.getString("JSFIRSTNAME"));
				jk.setLastName(rs.getString("JSLASTNAME"));
				jk.setEmail(rs.getString("JSEMAIL"));
				jk.setPhone(rs.getString("JSPHONENO"));
				jk.setDob(rs.getDate("DOB")); //date
				jk.setGender(new ValidateItem().stringValidate(rs.getString("Gender")));
				jk.setAddress(new ValidateItem().stringValidate(rs.getString("ADDRESS")));
				jk.setCity(new ValidateItem().stringValidate(rs.getString("City")));
				jk.setState(new ValidateItem().stringValidate(rs.getString("State")));
				jk.setCountry(new ValidateItem().stringValidate(rs.getString("Country")));
				jk.setPincode(rs.getInt("PINCODE"));
				jk.setDegree(new ValidateItem().stringValidate(rs.getString("Degree")));
				jk.setStream(new ValidateItem().stringValidate(rs.getString("STREAM")));
				jk.setExperience(rs.getInt("EXPYEAR"));
				jk.setCgpa(rs.getInt("CGPA"));
				jk.setInstitute(new ValidateItem().stringValidate(rs.getString("INSTITUTE")));
				jk.setUniversity(new ValidateItem().stringValidate(rs.getString("UNIVERSITY")));
				jk.sethBoard(new ValidateItem().stringValidate(rs.getString("HSBOARD")));
				jk.sethMarks(rs.getDouble("HSPERCENTAGE"));
				jk.setsBoard(new ValidateItem().stringValidate(rs.getString("SBOARD")));
				jk.setsMarks(rs.getDouble("SBPERCENTAGE"));
				jk.setCompany(new ValidateItem().stringValidate(rs.getString("Company")));
				jk.setLocation(new ValidateItem().stringValidate(rs.getString("LOCATION")));
				ps=con.prepareStatement("select count(*) As ct from ratecomment where jsid=? AND commentdes IS NOT NULL");
				ps.setString(1, rs.getString("JSId"));
				rd=ps.executeQuery();
				if(rd.next()) {
					jk.setCommentNo(rd.getInt("ct"));
				}
				ps=con.prepareStatement("select count(*) As ct,Sum(rating) As st from ratecomment where jsid=?");
				ps.setString(1, rs.getString("JSId"));
				rd=ps.executeQuery();
				if(rd.next()) {
					sum=rd.getInt("st");
					
					count=rd.getInt("ct");
					
				}
				jk.setRateAVG(new ValidateItem().rateCalculation(sum,count));
				jk.setPassout(rs.getDate("PASSOUT"));
				jk.setGap(new ValidateItem().stringValidate(rs.getString("GAP")));
				System.out.println(rs.getString("GAP"));
			}
		} catch (SQLException e) {
			logger.error(e);
		}finally {
			try {
			if(rs!=null) {
				rs.close();
			}
		}catch (SQLException e) {
			logger.error(e);
		}
			try {
			if(rd!=null) {
				rd.close();
			}
		}catch (SQLException e) {
			logger.error(e);
		}
	}
		return jk;
	}
	
	public List<JSComment> getComments(String str){
		String sid=null;
		JSComment js;
			try {
				ps=con.prepareStatement("select * from JSRegistration where JSEMAIL=?");
				ps.setString(1, str);
				rs=ps.executeQuery();
				if(rs.next()) {
					sid=rs.getString("JSID");
				}
				ps=con.prepareStatement("select commentdes,Empid from ratecomment where jsid=? AND commentdes IS NOT NULL");
				ps.setString(1, sid);
				rs=ps.executeQuery();
				while(rs.next()) {
					js=new JSComment();
					js.setComment(rs.getString("commentdes"));
					js.setEmpid(rs.getString("Empid"));
					as.add(js);
				}
			} catch (SQLException e) {

				logger.error(e);
			}
			return as;
	}
}
